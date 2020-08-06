package kr.ko.ym.study.controller;

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

import kr.ko.ym.study.service.StudyService;

/*
 * 2020. 07. 15
 * 스터디관리 > 스터디관리 게시판
 */
@Controller
public class StudyController {
	
	/* ���� ���� */
	@Autowired
	private StudyService studyService;
	
	
	@RequestMapping(value={"/","/study"})
	public ModelAndView selectList(@RequestParam Map<String,Object>param) throws Exception {
		ModelAndView mv = new ModelAndView("/study/studyLs");
		
		mv.addObject("list", studyService.selectList(param));				
		return mv;		
	}
	
	@RequestMapping(value="/study/view/{idx}")
	public ModelAndView selectViewPage(@PathVariable int idx) throws Exception {
		ModelAndView mv = new ModelAndView("/study/studyEd");
		
		Map<String,Object>param = new HashMap<String,Object>();
		
		param.put("IDX", idx);			
		
		mv.addObject("editFlag", false);		
		mv.addObject("map", studyService.selectDetail(param));				
		return mv;		
	}
	
	@RequestMapping(value="/study/edit/{idx}")
	public ModelAndView selectDetailInfo(@PathVariable int idx) throws Exception {
		ModelAndView mv = new ModelAndView("/study/studyEd");
		
		Map<String,Object>param = new HashMap<String,Object>();
		
		param.put("IDX", idx);	
		
		mv.addObject("newIdx", idx);		
 		mv.addObject("editFlag", true);		
		
		Map<String,Object>result = studyService.selectDetail(param);
						
		if(result.isEmpty()) {
			mv.addObject("newFlag", true);
		}else {
			mv.addObject("map", result);
			mv.addObject("newFlag", false);
		}		
		
		return mv;		
	}
	
	@RequestMapping(value="/study/insert", method=RequestMethod.POST)
	public void insertBoard(HttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception {		
		studyService.insertBoard(param) ;
		
	}
	
	@RequestMapping(value="/study/update", method=RequestMethod.POST)
	public void updateBoard(HttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception {
		studyService.updateBoard(param);
		
	}
	
	@RequestMapping(value="/study/delete", method=RequestMethod.POST)
	public void deleteBoard(HttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception {
		studyService.deleteBoard(param);
		
	}

	

}
