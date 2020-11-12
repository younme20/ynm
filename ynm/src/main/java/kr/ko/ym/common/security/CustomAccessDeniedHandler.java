package kr.ko.ym.common.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {

        response.setStatus(HttpStatus.FORBIDDEN.value());

        if(e instanceof AccessDeniedException){

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if(authentication != null){

                int error = HttpStatus.FORBIDDEN.value();

                response.sendRedirect(request.getContextPath() + "/error"+error);

            }
        }
    }
}
