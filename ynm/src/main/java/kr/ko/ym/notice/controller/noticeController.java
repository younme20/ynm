package kr.ko.ym.notice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ko.ym.notice.service.NoticeService;
import kr.ko.ym.notice.service.NoticeServiceImpl;
@Controller
public class noticeController {

	@Autowired
	private NoticeService noticeService;
	
	/*
	 * 게시글 목록
	 * */
	@RequestMapping(value="/notice")
	public ModelAndView selectList(@RequestParam Map<String,Object>param) throws Exception {
		ModelAndView mv = new ModelAndView("/notice/noticeLs");
		
		mv.addObject("list", noticeService.selectList(param));				
		return mv;		
	}
	/*
	 * 게시글 상세보기
	 * */
	@RequestMapping(value="/noticeDetail" )
	public ModelAndView noticeDetail(@RequestParam Map<String,Object>param) throws Exception {
		ModelAndView mv = new ModelAndView("notice/noticeVw");
		
		mv.addObject("data", noticeService.noticeDetail(param));		
		noticeService.noticeHitcnt(param);
		return mv;		
	}
	
	/*
	 * 글쓰기 폼
	 * */
	@RequestMapping(value="/writeForm")
	public String boardWrite() throws Exception {
		return "notice/noticeEd";
	}
	
	/*
	 * 새 글 등록
	 * */
	@RequestMapping(value="/noticeInsert")
	public ModelAndView noticeInsert(@RequestParam Map<String,Object>param) throws Exception {
		ModelAndView mv = new ModelAndView("notice/noticeLs");
		mv.addObject("data", noticeService.noticeInsert(param));				
		return mv;		
	}

	/*
	 * 게시글 수정 폼
	 * */
	@RequestMapping(value="/modifyForm")
	public ModelAndView modifyForm(@RequestParam Map<String,Object>param) throws Exception {
		System.out.println("픔오르 이동");
		ModelAndView mv = new ModelAndView("notice/noticeEd");
		mv.addObject("data", noticeService.noticeDetail(param));				
		return mv;		
	}
	
	/*
	 * 게시글 수정
	 * */
	@RequestMapping(value="/noticeUpdate")
	public String noticeUpdate(@RequestParam Map<String,Object>param) throws Exception {
		noticeService.noticeUpdate(param);
		return "notice/noticeLs";
	}
	/*
	 * 게시글 삭제
	 * */
	@RequestMapping(value="/noticeDelete", method = RequestMethod.GET)
	public String noticeDelete(@RequestParam Map<String,Object>param) throws Exception {
		noticeService.noticeDelete(param);
		return "notice/noticeLs";
	}
	
	
	

}
