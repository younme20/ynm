package kr.ko.ym.common.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping(value="/menu/{sub}")
	@PreAuthorize("hasAnyRole('ROLE_USER') or hasAnyRole('ROLE_MANAGER')")
	public String selectViewPage(@PathVariable String sub) throws Exception {
		
		return "redirect:/"+sub;	
	}
}
