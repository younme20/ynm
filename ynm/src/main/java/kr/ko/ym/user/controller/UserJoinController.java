package kr.ko.ym.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.ko.ym.user.service.UserJoinService;

@Controller
public class UserJoinController {

	@Autowired
	private UserJoinService joinService;
	
	
	@RequestMapping(value = "/userjoin", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginJoinPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mv = new ModelAndView("login/join.tiles");
		ModelAndView mv = new ModelAndView("userjoin");

		return mv;
	}

	
	@RequestMapping(value = "/join", method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/json; charset=UTF-8")
	public ModelAndView loginJoin(@RequestBody  Map<String,Object> param) throws Exception {
		
		ModelAndView mv = new ModelAndView("userlogin");
		joinService.insertUser(param);
		
		return mv;
	}
	
	@RequestMapping(value = "/join/usercheck", method = RequestMethod.POST)
	public Object selectUserNameCheck(HttpServletRequest request,
			 HttpServletResponse response, Map<String,Object>param) throws Exception {
	
		return joinService.selectUserNameCehck(param);
	}
}
