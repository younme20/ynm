package kr.ko.ym.schedule.controller;

import java.util.List;
import java.util.Map;

import kr.ko.ym.common.auth.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ko.ym.schedule.service.ScheduleService;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="/schedule", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('user:read,user:write')")
	public ModelAndView getScheduleView(@RequestParam Map<String, Object>param) throws Exception {
		ModelAndView mv = new ModelAndView("/schedule/scheduleLs.tiles");
		return mv;
	}
	
	@RequestMapping(value="/schedule/list", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('user:read,user:write')")
	public List<Map<String,Object>> selectSchedule(Authentication authentication, @RequestParam Map<String,Object>param) throws Exception {
		param.put("username", authentication.getPrincipal());
		List<Map<String,Object>>list = scheduleService.selectSchedule(param);
		return list;	
	}
	
	@RequestMapping(value="/schedule/select", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('user:read,user:write')")
	public List<Map<String,Object>> selectScheduleOne(@RequestParam Map<String,Object>param) throws Exception {		
		List<Map<String,Object>>list = scheduleService.selectSchedule(param);		
		return list;	
	}
	
	
	@RequestMapping(value="/schedule/insert", method=RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('user:read,user:write')")
	public List<Map<String, Object>> insertSchedule(@RequestParam Map<String,Object>param) throws Exception {
		return scheduleService.insertSchedule(param);	
	}
	
	@RequestMapping(value="/schedule/update", method=RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('user:read,user:write')")
	public List<Map<String, Object>> updateSchedule(@RequestParam Map<String,Object>param) throws Exception {
		return scheduleService.updateSchedule(param);	
	}
	
	@RequestMapping(value="/schedule/delete", method=RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('user:read,user:write')")
	public List<Map<String, Object>> deleteSchedule(@RequestParam Map<String,Object>param) throws Exception {
		return scheduleService.deleteSchedule(param);	
	}

}
