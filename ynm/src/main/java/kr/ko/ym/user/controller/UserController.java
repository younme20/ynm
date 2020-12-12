package kr.ko.ym.user.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.net.HttpHeaders;
import kr.ko.ym.board.service.BoardService;
import kr.ko.ym.common.auth.AppUserService;
import kr.ko.ym.hashtag.service.HashtagService;
import kr.ko.ym.kakao.service.KakaoAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


@Controller
public class UserController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AppUserService appUserService;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Autowired
	private BoardService boardService;
	@Autowired
	private HashtagService hashtagService;
	
	
	@GetMapping(value = {"/", "/{word}", "/login"})
	public ModelAndView loginViewPage(Authentication authentication, HttpServletRequest request, HttpServletResponse response,
			@PathVariable(required = false) String word) throws Exception {

		ModelAndView mv = new ModelAndView("");
		String url = "";
		boolean isAuth = this.isAuth(request, response);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		HashSet<String> set = hashtagService.selectAllHashTag();
		//이미 인증 정보가 있을 경우
		if(isAuth){
			url = "/main/main.tiles";
			
			if(!set.isEmpty()) {
				mv.addObject("hash", set);
				
			}
			
			paramMap.put("hashTag", word);
			mv.addObject("comment", boardService.selectLastComment());
			mv.addObject("list", boardService.selectBoard(paramMap));
			mv.addObject("username", authentication.getPrincipal());
		}else{
			url = "userlogin";
		}

		mv.setViewName(url);
		mv.addObject("isAuth", isAuth);
		return mv;
	}

	@RequestMapping(value = "/out", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginOutPage(Authentication authentication,
			 						 HttpServletRequest request,
									 HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView("userlogin");

		//클라이언트 측 쿠키 삭제
		Cookie[] requestCookies = request.getCookies();

		for(Cookie requestCookie : requestCookies){
			if(HttpHeaders.AUTHORIZATION.equals(requestCookie.getName())){
				requestCookie.setMaxAge(0);
				requestCookie.setHttpOnly(true);
				response.addCookie(requestCookie);

				//redis에 blacklist 저장(access token)
				stringRedisTemplate.opsForValue()
						.set(requestCookie.getValue().replace(URLEncoder.encode("Bearer ", "UTF-8"), " "), "blacklist");

				response.addCookie(requestCookie);
				break;
			}
		}

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