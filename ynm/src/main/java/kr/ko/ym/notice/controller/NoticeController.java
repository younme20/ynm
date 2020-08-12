package kr.ko.ym.notice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.ko.ym.notice.service.NoticeService;
@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	/*
	 * 게시글 목록
	 * */
	@RequestMapping(value="/notice")
	public ModelAndView selectBoard(@RequestParam Map<String,Object>param) throws Exception {
		ModelAndView mv = new ModelAndView("/notice/noticeLs");
		mv.addObject("list", noticeService.selectBoard(param));				
		return mv;		
	}
	/*
	 * 게시글 상세보기
	 * */
	@RequestMapping(value="/notice/detail/{idx}" )
	public ModelAndView selectDetail( HttpServletRequest request, @PathVariable int idx) throws Exception {
		ModelAndView mv = new ModelAndView("notice/noticeVw");
		Map<String,Object>param = new HashMap<String,Object>();
		param.put("IDX", idx);			
		
		mv.addObject("data", noticeService.selectDetail(param));		
		noticeService.updateCount(param);
		return mv;		
	}
	
	/*
	 * 글쓰기 폼
	 * */
	@RequestMapping(value="/notice/write")
	public String writeForm() throws Exception {
		return "notice/noticeEd";
	}
	
	/*
	 * 새 글 등록
	 * */
	
	@RequestMapping(value="/notice/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insertBoard(HttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception {
		noticeService.insertBoard(param);	
		Map<String,Object> map =  noticeService.selectMaxIdx();
		return "redirect:/notice/detail/"+ map.get("IDX");	
	}

	/*
	 * 게시글 수정 폼
	 * */
	@RequestMapping(value="/notice/modify/{idx}")
	public ModelAndView modifyForm(HttpServletRequest request, @PathVariable int idx) throws Exception {
		ModelAndView mv = new ModelAndView("notice/noticeEd");
		Map<String,Object>param = new HashMap<String,Object>();
		param.put("IDX", idx);	
		mv.addObject("data", noticeService.selectDetail(param));				
		return mv;		
	}
	
	/*
	 * 게시글 수정
	 * */
	@RequestMapping(value="/notice/update")
	public String updateBoard(@RequestParam Map<String,Object>param) throws Exception {
		noticeService.updateBoard(param);
		return "notice/noticeLs";
	}
	/*
	 * 게시글 삭제
	 * */
	@RequestMapping(value="/notice/delete", method = RequestMethod.GET)
	public String deleteBoard(@RequestParam Map<String,Object>param) throws Exception {
		noticeService.deleteBoard(param);
		return "notice/noticeLs";
	}
	
	
	

}
