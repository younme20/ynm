package kr.ko.ym.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginViewPage() throws Exception {
		return "/login/login.tiles";
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_USER')")
	public String auth(HttpServletRequest request) throws Exception {
		System.out.println(request.getContentType());
		System.out.println(request.getReader().readLine());
		return null;
	}


}
