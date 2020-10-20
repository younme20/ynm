package kr.ko.ym.common.jwt;

import com.google.common.net.HttpHeaders;
import io.jsonwebtoken.Jwts;

import org.springframework.cglib.core.Local;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter  {

    private final AuthenticationManager authenticationManager;
    private final SecretKey secretKey;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, SecretKey secretKey) {
        this.authenticationManager = authenticationManager;
        this.secretKey = secretKey;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        if(!"POST".equals(request.getMethod())){
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        Map<String,String[]> map = request.getParameterMap();

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                map.get("username")[0],
                map.get("password")[0]
        );

        Authentication authenticate = authenticationManager.authenticate(authentication);
        return authenticate;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

/*        String refreshToken = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new java.util.Date())
                .setExpiration(Date.valueOf(LocalDate.now().plusDays(14)))
                .signWith(secretKey)
                .compact();*/

        String accessToken = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new java.util.Date())
                .setExpiration(new Date(System.currentTimeMillis() + 300000))
                .signWith(secretKey)
                .compact();

        Cookie cookie = new Cookie(HttpHeaders.AUTHORIZATION,
                URLEncoder.encode("Bearer ", "UTF-8")+accessToken);

        response.addCookie(cookie);
    }


}
