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
	public ModelAndView selectList(@RequestParam Map<String,Object>param) throws Exception {
		ModelAndView mv = new ModelAndView("/notice/noticeLs");
		mv.addObject("list", noticeService.selectList(param));				
		return mv;		
	}
	/*
	 * 게시글 상세보기
	 * */
	@RequestMapping(value="/notice/detail/{idx}" )
	public ModelAndView noticeDetail(@PathVariable int idx) throws Exception {
		ModelAndView mv = new ModelAndView("notice/noticeVw");
		Map<String,Object>param = new HashMap<String,Object>();
		param.put("IDX", idx);			
		
		mv.addObject("data", noticeService.noticeDetail(param));		
		noticeService.noticeHitcnt(param);
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
	public ModelAndView boardInsert(HttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception {
		ModelAndView mv = new ModelAndView("notice/noticeLs");
		noticeService.noticeInsert(param);			
		return mv;		
	}

	/*
	 * 게시글 수정 폼
	 * */
	@RequestMapping(value="/notice/modify")
	public ModelAndView modifyForm(@RequestParam Map<String,Object>param) throws Exception {
		System.out.println("픔오르 이동");
		ModelAndView mv = new ModelAndView("notice/noticeEd");
		mv.addObject("data", noticeService.noticeDetail(param));				
		return mv;		
	}
	
	/*
	 * 게시글 수정
	 * */
	@RequestMapping(value="/notice/update")
	public String updateBoard(@RequestParam Map<String,Object>param) throws Exception {
		noticeService.noticeUpdate(param);
		return "notice/noticeLs";
	}
	/*
	 * 게시글 삭제
	 * */
	@RequestMapping(value="/notice/delete", method = RequestMethod.GET)
	public String deleteBoard(@RequestParam Map<String,Object>param) throws Exception {
		noticeService.noticeDelete(param);
		return "notice/noticeLs";
	}
	
	
	

}
