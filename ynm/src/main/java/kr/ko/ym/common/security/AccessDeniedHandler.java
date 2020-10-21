package kr.ko.ym.common.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {

        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());

        if(e instanceof AccessDeniedException){

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if(authentication != null){

                if(!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))){
                    httpServletRequest.setAttribute("msg", "접근 권한 없는 사용자 입니다.");
                    httpServletRequest.setAttribute("nextPage", "/");
                }

                httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest, httpServletResponse);


            }


        }



    }
}
