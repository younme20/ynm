package kr.ko.ym.user.controller;

//import kr.ko.ym.common.auth.AppUserService;
//import kr.ko.ym.common.jwt.JwtAuthenticationRequest;
import kr.ko.ym.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	//@Autowired
	//private AppUserService appUserService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "login")
	public String loginViewPage() throws Exception {
		return "/login/login.tiles";
	}

	@RequestMapping(value = "auth", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> selectUserByName(@RequestParam Map<String,Object>param) throws Exception {
		List<Map<String,Object>>list = userService.selectUserByName(param);
		return list
				.stream()
				.filter(username -> username.equals(param.get("username")))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("this is not exist"));
	}

	//login 확인 과정 필요
	/* @RequestMapping(value = "authenticate", method = RequestMethod.POST)
	public RequestEntity<?> selectUserInfo (@RequestBody JwtAuthenticationRequest jwtRequest) throws Exception {

		jwtRequest.setUsername("test");
		jwtRequest.setPassword("password");

		final UserDetails userDetails = appUserService
				.loadUserByUsername(jwtRequest.getUsername());


		return null;
	} */





}
