package kr.ko.ym.user.controller;

import com.google.common.base.Strings;
import com.google.common.net.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Controller
public class UserController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "/login")
	public ModelAndView loginViewPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView("");
		boolean isAuth = false;
		String url = "";

		Cookie[] requestCookies = request.getCookies();

		for(Cookie requestCookie : requestCookies){
			if(HttpHeaders.AUTHORIZATION.equals(requestCookie.getName())){
				isAuth = true;
				break;
			}
		}

		//이미 인증 정보가 있을 경우
		if(isAuth){
			url = Strings.isNullOrEmpty(request.getHeader("Referer")) ? "/" : request.getHeader("Referer");
		}else{
			url = "/login/login.tiles";
		}

		mv.setViewName(url);
		mv.addObject("isAuth", isAuth);

		return mv;
	}

	@RequestMapping(value = "/logoutt", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginOutPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/");

		//클라이언트 측 쿠키 삭제
		Cookie[] requestCookies = request.getCookies();

		for(Cookie requestCookie : requestCookies){
			if(HttpHeaders.AUTHORIZATION.equals(requestCookie.getName())){
				requestCookie.setMaxAge(0);
				response.addCookie(requestCookie);
				break;
			}
		}

		return mv;
	}



}
