package kr.ko.ym.user.controller;

import com.google.common.net.HttpHeaders;
import kr.ko.ym.board.service.BoardService;
import kr.ko.ym.common.api.GithubApi;
import kr.ko.ym.common.jwt.JwtConfig;
import kr.ko.ym.hashtag.service.HashtagService;
import org.kohsuke.github.GHIssueComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BoardService boardService;
	@Autowired
	private HashtagService hashtagService;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Autowired
	private JwtConfig jwtConfig;

	@GetMapping(value = {"/", "/{word}"})
	public ModelAndView mainViewPage(HttpServletRequest request,
							   		 HttpServletResponse response,
									 @PathVariable(required = false) String word) throws Exception {

		ModelAndView mv = new ModelAndView("/main/main.tiles");
		HashMap<String,Object>paramMap = new HashMap<String,Object>();

		GithubApi githubApi = new GithubApi();
		List<Map<String,Object>> githubApiIssueComments = githubApi.getIssueRecentComments(jwtConfig.getOauthToken(), jwtConfig.getRepoName());

		//해시태그
		HashSet<String> set = hashtagService.selectAllHashTag();
		if(!set.isEmpty()) {
			mv.addObject("hash", set);
		}
		paramMap.put("hashTag", word);
		//댓글
		mv.addObject("comment", githubApiIssueComments);
		//목록
		mv.addObject("list", boardService.selectBoard(paramMap));

		return mv;
	}

	@GetMapping(value = {"/login"})
	public String loginViewPage(HttpServletRequest request,
									  HttpServletResponse response) throws Exception {
		return "userlogin";
	}

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/out", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginOutPage(HttpServletRequest request,
									 HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView("/main/main.tiles");

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
}