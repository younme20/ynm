package kr.ko.ym.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.ko.ym.common.auth.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.ko.ym.study.service.StudyService;

/*
 * 2020. 07. 15
 */
@Controller
public class StudyController {
	
	@Autowired
	private StudyService studyService;
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="/study", method= {RequestMethod.GET, RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('user:read,user:write')")
	public ModelAndView selectList(Authentication authentication, @RequestParam Map<String, Object>param) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardLs.tiles");
		
 		List<Map<String,Object>>list = studyService.selectList(param);
		Map<String,Object>map = studyService.selectTotalCount(param);

		//TODO: test중, 추후에 추가 예정
		Map<String,Integer>hs = new HashMap<String, Integer>();

		hs.put("java", 5);
		hs.put("spring", 3);
		hs.put("test", 7);

		mv.addObject("categories", hs);

		mv.addObject("list", list);		
		mv.addObject("param", param);		
		
		mv.addObject("page", param.get("page"));
		mv.addObject("totalCount", map.get("TOTAL_COUNT"));
		mv.addObject("username", authentication.getPrincipal());

 		return mv;		
	}
	
	@RequestMapping(value="/study/view/{idx}")
	@PreAuthorize("hasAnyAuthority('user:read,user:write')")
	public ModelAndView selectViewPage(Authentication authentication, @PathVariable int idx) throws Exception {
		ModelAndView mv = new ModelAndView("/study/studyEd.tiles");
		
		Map<String,Object>param = new HashMap<String,Object>();
		
		param.put("IDX", idx);
		param.put("username", authentication.getPrincipal());
		
		mv.addObject("editFlag", false);		
		mv.addObject("map", studyService.selectDetail(param));				
		return mv;		
	}
	
	@RequestMapping(value="/study/edit/{idx}")
	@PreAuthorize("hasAnyAuthority('user:read,user:write')")
	public ModelAndView selectDetailInfo(@PathVariable int idx, AppUser appUser) throws Exception {
		ModelAndView mv = new ModelAndView("/study/studyEd.tiles");

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
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('user:read,user:write')")
	public void insertBoard(HttpServletRequest request, @RequestParam Map<String,Object>param, AppUser appUser) throws Exception {
		studyService.insertBoard(param);
		
	}
	
	@RequestMapping(value="/study/update", method=RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('user:read,user:write')")
	public void updateBoard(HttpServletRequest request, @RequestParam Map<String,Object>param, AppUser appUser) throws Exception {
		studyService.updateBoard(param);
		
	}
	
	@RequestMapping(value="/study/delete", method=RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('user:read,user:write') or (appUser.username == principal.username)")
	public void deleteBoard(HttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception {
		studyService.deleteBoard(param);
		
	}


}