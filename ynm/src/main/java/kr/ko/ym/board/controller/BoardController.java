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
	 * view
	 * */
	@RequestMapping(value="/board/{idx}" , method = {RequestMethod.GET})
	@ResponseBody
	public ModelAndView selectDetail(HttpServletRequest request,
									 HttpServletResponse response,
									 @RequestParam Map<String,Object>param,
									 @PathVariable int idx) throws Exception {

		ModelAndView mv = new ModelAndView("board/boardVw.tiles");

		param.put("IDX", idx);
		mv.addObject("param", param);
		mv.addObject("list", boardService.selectBoard(param));
		mv.addObject("data", boardService.selectDetail(param));

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
	@RequestMapping(value="/board/edit", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER')")
	public ModelAndView writeForm(@RequestParam Map<String,Object>param) throws Exception {
		ModelAndView mv = new ModelAndView("board/boardEd.tiles");
		mv.addObject("mode", "new");	
		return mv;
	}
	
	/*
	 * insert
	 * */
	@RequestMapping(value="/board/insert", method = RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasRole('USER')")
	public String insertBoard(HttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception {
		
		boardService.insertBoard(param);
		Map<String,Object> map =  boardService.selectMaxIdx();
		
		int idx = (int) map.get("IDX");
		
		param.put("IDX",idx);	
		if(param.get("HASHTAG") != null) {
			hashtagService.insertHashTag(param);
		}
		return request.getContextPath()+"/board/"+ idx;
	}
	
	/*
	 * modify form
	 * */
	@RequestMapping(value="/board/modify/{idx}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER')")
	public ModelAndView modifyForm(Authentication authentication, HttpServletRequest request, @PathVariable int idx) throws Exception {
		ModelAndView mv = new ModelAndView("board/boardEd.tiles");
		Map<String,Object>param = new HashMap<String,Object>();

		mv.addObject("list", boardService.selectBoard(param));
		mv.addObject("username", authentication.getPrincipal().toString());

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
	@PreAuthorize("hasRole('USER')")
	public String updateBoard(HttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception {
		
		hashtagService.deleteHashTag(param);
		//if(param.get("HASHTAG") != "") {
		if(param.get("HASHTAG") != null || param.get("HASHTAG") != "") {
				hashtagService.insertHashTag(param);
		}
		
		boardService.updateBoard(param);
		
		String idx = (String) param.get("IDX");
		return idx;
	}

	@RequestMapping(value="/board/delete/{idx}", method=RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasRole('USER')")
	public void deleteBoard(HttpServletRequest request, @RequestParam Map<String,Object>param, @PathVariable int idx) throws Exception {
		boardService.deleteBoard(param);

	}


	
}