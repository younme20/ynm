package kr.ko.ym.board.controller;

import kr.ko.ym.board.service.BoardService;
import kr.ko.ym.common.service.FileUploadService;
import kr.ko.ym.hashtag.service.HashtagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private FileUploadService fileuploadService;
	@Autowired
	private HashtagService hashtagService;
	
	/*
	 * list select
	 * */
	@RequestMapping(value="/board", method = {RequestMethod.POST,RequestMethod.GET})
	@PreAuthorize("hasAnyAuthority('user:read,user:write')")
	public ModelAndView selectBoard(Authentication authentication,
									@RequestParam Map<String,Object>param) throws Exception {

		String username = authentication.getPrincipal().toString();
		param.put("username", username);
		
		ModelAndView mv = new ModelAndView("board/boardLs.tiles");
		Map<String,Object>map = boardService.selectCount(param);

		//TODO: 해시 태그 test중, 추후에 추가 예정
		Map<String,Integer>hs = new HashMap<String, Integer>();
		hs.put("java", 5);
		hs.put("spring", 3);
		hs.put("test", 7);
		mv.addObject("categories", hs);

		mv.addObject("list", boardService.selectBoard(param));
		mv.addObject("param", param);
		mv.addObject("page", param.get("page"));
		mv.addObject("totalCount", map.get("TOTAL_COUNT"));
		mv.addObject("username", username);

		return mv;
	}

	/*
	 * view
	 * */
	@RequestMapping(value="/board/detail/{idx}" , method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView selectDetail(Authentication authentication,
									 HttpServletRequest request,
									 HttpServletResponse response,
									 @RequestParam Map<String,Object>param,
									 @PathVariable int idx) throws Exception {

		ModelAndView mv = new ModelAndView("board/boardVw.tiles");

		param.put("IDX", idx);
		mv.addObject("param", param);
		mv.addObject("data", boardService.selectDetail(param));
		mv.addObject("username", authentication.getPrincipal());

		List<Map<String, Object>> list = fileuploadService.selectAttachFileListByIDX(param);

		if(!list.isEmpty() || list != null ) {
			mv.addObject("files", list);
		}
		
		//해시태그 obj
		
		Map<String,Object> hash = hashtagService.selectOneHashTag(param);
		if(hash != null) {
			if(hash.size() > 0) {
				String[] arr = ((String) hash.get("CONTENTS")).split(",");
				mv.addObject("hash", arr);
			}
		}
		
		
		boardService.updateCount(param);
		return mv;
	}
	
	/*
	 * write form
	 * */
	@RequestMapping(value="/board/edit")
	public ModelAndView  writeForm() throws Exception {
		ModelAndView mv = new ModelAndView("board/boardEd.tiles");
		mv.addObject("mode", "new");	
		return mv;
	}
	
	/*
	 * insert
	 * */
	
	@RequestMapping(value="/board/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insertBoard(@RequestParam Map<String,Object>param) throws Exception {
		
		boardService.insertBoard(param);
		Map<String,Object> map =  boardService.selectMaxIdx();
		
		int idx = (int) map.get("IDX");
		
		param.put("IDX",idx);	
		if(param.get("HASHTAG") != null) {
			hashtagService.insertHashTag(param);
		}
		
		//param.put("BOARD_IDX", idx);
		return "/ynm/board/detail/"+ idx;	
	}
	
	/*
	 * modify form
	 * */
	@RequestMapping(value="/board/modify/{idx}", method = RequestMethod.GET)
	public ModelAndView modifyForm(HttpServletRequest request, @PathVariable int idx) throws Exception {
		ModelAndView mv = new ModelAndView("board/boardEd.tiles");
		
		Map<String,Object>param = new HashMap<String,Object>();
		param.put("IDX", idx);	
		
		List<Map<String, Object>> files = null;
		files = fileuploadService.selectAttachFileListByIDX(param);
		// "false".equals(files.isEmpty()) || (Integer)files.get(0).get("FILE_GROUP") > 0 
		if(!files.isEmpty()) {
			
			int FILE_GROUP = (Integer) files.get(0).get("FILE_GROUP");
			if (FILE_GROUP > 0) {
				mv.addObject("FILE_GROUP",FILE_GROUP);
				mv.addObject("files", files);
			}
		}
		
		
		//해시태그 obj
		String[] arr = null;
		String hasnStr = "";
		Map<String,Object> hash = hashtagService.selectOneHashTag(param);
		
		if(hash != null) {
			if(hash.size() > 0) {
				hasnStr = (String)hash.get("CONTENTS");
				arr = ((String) hash.get("CONTENTS")).split(",");
				mv.addObject("hash", arr);
				mv.addObject("HASHTAG",hasnStr);
			}
		}
	
		mv.addObject("data", boardService.selectDetail(param));
		mv.addObject("mode", "modify");		
		
		return mv;		
	}
	
	/*
	 * update
	 * */
	@RequestMapping(value="/board/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateBoard(HttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception {
		boardService.updateBoard(param);
		hashtagService.updateHashTag(param);
		String idx = (String) param.get("IDX");
		return idx;
	}
	
}