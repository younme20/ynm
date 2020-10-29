package kr.ko.ym.main;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView selectList(HttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception {
		
		log.debug("ss", request.getSession());
		
		ModelAndView mv = new ModelAndView("/index.tiles");
 		return mv;		
	}


}