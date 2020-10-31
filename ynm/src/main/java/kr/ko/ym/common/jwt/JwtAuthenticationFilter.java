package kr.ko.ym.common.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;
import com.mysql.cj.util.StringUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import kr.ko.ym.common.auth.AppUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.time.LocalDate;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter  {

    private final AuthenticationManager authenticationManager;
    private final SecretKey secretKey;


    public JwtAuthenticationFilter(AuthenticationManager authenticationManager,
                                   SecretKey secretKey) {
        this.authenticationManager = authenticationManager;
        this.secretKey = secretKey;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {


        try {
            BufferedReader reader = request.getReader();

            String line = reader.readLine();

            JwtAuthenticationRequest jwtAuthenticationRequest = new ObjectMapper()
                    .readValue(line, JwtAuthenticationRequest.class);

            if (StringUtils.isNullOrEmpty(jwtAuthenticationRequest.getUsername()) ||
                    StringUtils.isNullOrEmpty(jwtAuthenticationRequest.getPassword())) {
                throw new AuthenticationServiceException("Username or Password not provided");
            }

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    jwtAuthenticationRequest.getUsername(),
                    jwtAuthenticationRequest.getPassword()
            );

            Authentication authenticate = authenticationManager.authenticate(authentication);
            return authenticate;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
                .setExpiration(Date.valueOf(LocalDate.now().plusDays(14)))
                // .setExpiration(new Date(System.currentTimeMillis() + 300000))
                .signWith(secretKey)
                .compact();

        Cookie cookie = new Cookie(HttpHeaders.AUTHORIZATION,
                URLEncoder.encode("Bearer ", "UTF-8")+accessToken);

        response.addCookie(cookie);

    }


}
