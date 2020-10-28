package kr.ko.ym.notice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.ko.ym.common.service.FileUploadService;
import kr.ko.ym.hashtag.service.HashtagService;
import kr.ko.ym.notice.service.NoticeService;
@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	@Autowired
	private FileUploadService fileuploadService;
	@Autowired
	private HashtagService hashtagService;
	/*
	 * list select
	 * */
	@RequestMapping(value="/notice", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView selectBoard(@RequestParam Map<String,Object>param) throws Exception {
		
		ModelAndView mv = new ModelAndView("notice/noticeLs.tiles");
		
		if(param.get("MENU_CODE") == null) {
			param.put("MENU_CODE", "B");
		}
		mv.addObject("list", noticeService.selectBoard(param));	
		
		Map<String,Object>map = noticeService.selectCount(param);
		mv.addObject("param", param);	
		mv.addObject("page", param.get("page"));
		mv.addObject("totalCount", map.get("TOTAL_COUNT"));
		
		return mv;
	}
	
	/*
	 * view
	 * */
	@RequestMapping(value="/notice/detail/{idx}" , method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView selectDetail(HttpServletRequest request, @RequestParam Map<String,Object>param, @PathVariable int idx) throws Exception {
		ModelAndView mv = new ModelAndView("notice/noticeVw.tiles");
	
		param.put("IDX", idx);		
		mv.addObject("data", noticeService.selectDetail(param));
		
		//파일 obj
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = fileuploadService.selectAttachFileListByIDX(param);
		if(!list.isEmpty() || list != null ) {
			mv.addObject("files", list);
		}
		
		//해시태그 obj
		Map<String,Object> tag = hashtagService.selectOneHashTag(param);
		String[] tagArray = ((String) tag.get("CONTENTS")).split(",");
		mv.addObject("hash", tagArray);
		
		noticeService.updateCount(param);
		mv.addObject("param", param);
		return mv;		
	}
	
	/*
	 * write form
	 * */
	@RequestMapping(value="/notice/write")
	public ModelAndView  writeForm() throws Exception {
		ModelAndView mv = new ModelAndView("notice/noticeEd.tiles");
		mv.addObject("mode", "new");	
		return mv;
	}
	
	/*
	 * insert
	 * */
	
	@RequestMapping(value="/notice/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insertBoard(@RequestParam Map<String,Object>param) throws Exception {
		noticeService.insertBoard(param);
		
		
		Map<String,Object> map =  noticeService.selectMaxIdx();
		
		param.put("IDX", map.get("IDX"));	
		if(param.get("HASHTAG") != null) {
			hashtagService.insertHashTag(param);
		}
		
		param.put("BOARD_IDX", map.get("IDX"));
		return "detail/"+ map.get("IDX");	
	}


	/*
	 * modify form
	 * */
	@RequestMapping(value="/notice/modify/{idx}", method = RequestMethod.GET)
	public ModelAndView modifyForm(HttpServletRequest request, @PathVariable int idx) throws Exception {
		ModelAndView mv = new ModelAndView("notice/noticeEd.tiles");
		
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
		Map<String,Object> tag = hashtagService.selectOneHashTag(param);
		String[] tagArray = ((String) tag.get("CONTENTS")).split(",");
		mv.addObject("hash", tagArray);
		mv.addObject("HASHTAG", (String)tag.get("CONTENTS"));
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
		hashtagService.updateHashTag(param);
		String idx = (String) param.get("IDX");
		return idx;
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