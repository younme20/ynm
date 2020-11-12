package kr.ko.ym.user.controller;

import com.google.common.base.Strings;
import com.google.common.net.HttpHeaders;
import io.jsonwebtoken.Jwts;
import kr.ko.ym.common.auth.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class UserController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AppUserService appUserService;

	@GetMapping(value = {"/", "/login"})
	public ModelAndView loginViewPage(Authentication authentication, HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView("");
		String url = "";
		boolean isAuth = this.isAuth(request, response);

		//이미 인증 정보가 있을 경우
		if(isAuth){
			url = "/main/main.tiles";
			mv.addObject("username", authentication.getPrincipal());
		}else{
			url = "userlogin";
		}

		mv.setViewName(url);
		mv.addObject("isAuth", isAuth);

		return mv;
	}

	@GetMapping(value = {"/register"})
	public void registerNewMember(HttpServletRequest request,
								  HttpServletResponse response) throws Exception {



	}

	//TODO: 서버측 로그아웃 처리하기, refresh토큰 추가
	@RequestMapping(value = "/out", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginOutPage(HttpServletRequest request,
									 HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("userlogin");

		//클라이언트 측 쿠키 삭제
		Cookie[] requestCookies = request.getCookies();

		for(Cookie requestCookie : requestCookies){
			if(HttpHeaders.AUTHORIZATION.equals(requestCookie.getName())){
				requestCookie.setMaxAge(0);
				response.addCookie(requestCookie);
				break;
			}
		}

		//서버 측 jwt token 기한 만료시키기



		return mv;
	}

	public Boolean isAuth(HttpServletRequest request, HttpServletResponse response){
		boolean isAuth = false;

		Cookie[] requestCookies = request.getCookies();

		if(requestCookies != null){
			for(Cookie requestCookie : requestCookies) {
				if (HttpHeaders.AUTHORIZATION.equals(requestCookie.getName())) {
					isAuth = true;
					break;
				}
			}
		}


		return isAuth;
	}

}