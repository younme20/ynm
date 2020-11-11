package kr.ko.ym.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrorController {

    @RequestMapping("/error403")
    public ModelAndView errorPageView(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView("userError");
        return mv;
    }

}