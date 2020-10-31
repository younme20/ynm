package kr.ko.ym.board.controller;

import kr.ko.ym.board.service.BoardService;
import kr.ko.ym.common.service.FileUploadService;
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

		boardService.updateCount(param);
		return mv;
	}

}