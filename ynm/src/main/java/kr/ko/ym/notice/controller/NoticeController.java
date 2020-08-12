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
	 * list
	 * */
	@RequestMapping(value="/notice")
	public ModelAndView selectBoard(@RequestParam Map<String,Object>param) throws Exception {
		ModelAndView mv = new ModelAndView("/notice/noticeLs");
		mv.addObject("list", noticeService.selectBoard(param));				
		return mv;		
	}
	/*
	 * view
	 * */
	@RequestMapping(value="/notice/detail/{idx}" , method = RequestMethod.GET)
	public ModelAndView selectDetail( HttpServletRequest request, @PathVariable int idx) throws Exception {
		ModelAndView mv = new ModelAndView("notice/noticeVw");
		Map<String,Object>param = new HashMap<String,Object>();
		param.put("IDX", idx);			
		
		mv.addObject("data", noticeService.selectDetail(param));		
		noticeService.updateCount(param);
		return mv;		
	}
	
	/*
	 * write form
	 * */
	@RequestMapping(value="/notice/write")
	public ModelAndView  writeForm() throws Exception {
		ModelAndView mv = new ModelAndView("notice/noticeEd");
		mv.addObject("mode", "new");	
		return mv;
	}
	
	/*
	 * insert
	 * */
	
	@RequestMapping(value="/notice/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insertBoard(HttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception {
		noticeService.insertBoard(param);	
		Map<String,Object> map =  noticeService.selectMaxIdx();
		return "detail/"+ map.get("IDX");	
	}

	/*
	 * modify form
	 * */
	@RequestMapping(value="/notice/modify/{idx}", method = RequestMethod.GET)
	public ModelAndView modifyForm(HttpServletRequest request, @PathVariable int idx) throws Exception {
		ModelAndView mv = new ModelAndView("notice/noticeEd");
		Map<String,Object>param = new HashMap<String,Object>();
		param.put("IDX", idx);	
		mv.addObject("data", noticeService.selectDetail(param));	
		mv.addObject("mode", "modify");		
		return mv;		
	}
	
	/*
	 * update
	 * */
	@RequestMapping(value="/notice/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateBoard(HttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception {
		noticeService.updateBoard(param);
		return "detail/"+param.get("IDX");
	}
	/*
	 * delete
	 * */
	@RequestMapping(value="/notice/delete/{idx}" , method = RequestMethod.GET)
	public String deleteBoard(HttpServletRequest request, @PathVariable int idx) throws Exception {
		Map<String,Object>param = new HashMap<String,Object>();
		param.put("IDX", idx);	
		noticeService.deleteBoard(param);
		return "redirect:/notice";	
	}
	
	
	

}
