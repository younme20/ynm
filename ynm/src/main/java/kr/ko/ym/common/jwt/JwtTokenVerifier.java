package kr.ko.ym.common.jwt;

import com.google.common.base.Strings;
import com.google.common.net.HttpHeaders;
import io.jsonwebtoken.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

public class JwtTokenVerifier extends OncePerRequestFilter {

    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;
    private final StringRedisTemplate stringRedisTemplate;

    public JwtTokenVerifier(JwtConfig jwtConfig, SecretKey secretKey,
                            StringRedisTemplate stringRedisTemplate) {
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        String requestHeader = "";

        Cookie[] requestCookies = request.getCookies();

        if (requestCookies != null) {

            //쿠키에서 암호화된 헤더를 찾음
            for (Cookie requestCookie : requestCookies) {
                if (jwtConfig.getAuthorizaionHeader().equals(requestCookie.getName())) {
                    requestHeader = requestCookie.getValue();
                    break;
                }
            }

            if (Strings.isNullOrEmpty(requestHeader) || !requestHeader.startsWith(URLEncoder.encode(jwtConfig.getTokenPrefix(), "UTF-8"))) {
                filterChain.doFilter(request, response);
                return;
            }

            //액세스토큰
            String accessToken = requestHeader.replace(URLEncoder.encode(jwtConfig.getTokenPrefix(), "UTF-8"), " ");

            //블랙리스트에 엑세스 토큰이 이미 있을 시(로그아웃한 유저)
            if (stringRedisTemplate.opsForValue().get(accessToken.trim()) != null) {
                deleteAllToken(request, response, accessToken);
                return;

            }else{

                try {
                    makeAuthentication(accessToken);

                }catch(ExpiredJwtException expiredJwtException){
                    //토큰 만료되었을 시 리프레시 토큰 확인
                    String refreshToken = (String)stringRedisTemplate
                            .opsForHash().get("token", accessToken.trim());

                    if(refreshToken != null){

                        try{
                            Jws<Claims>refreshJws = Jwts.parser()
                                    .setSigningKey(secretKey)
                                    .parseClaimsJws(refreshToken);

                            //리프레시 토큰으로 새로 토큰 발급
                            String newToken = Jwts.builder()
                                    .setSubject(refreshJws.getBody().getSubject())
                                    .claim("authorities", refreshJws.getBody().get("authorities"))
                                    .setIssuedAt(new Date())
                                    .setExpiration(new java.sql.Date(System.currentTimeMillis() + 60000))
                                    .signWith(secretKey)
                                    .compact();

                            makeAuthentication(newToken);

                        //리프레시 토큰이 만료되었을 경우
                        }catch(ExpiredJwtException expiredRefreshJwtException){
                            deleteAllToken(request, response, accessToken);
                            return;

                        }
                    }

                    filterChain.doFilter(request, response);

                }catch(JwtException e) {
                    throw new IllegalStateException(String.format("Token %s cannot be trust", accessToken));
                }
            }
        }
        //filter1에서 filter2로 넘겨줘야함
        filterChain.doFilter(request, response);
    }

    public void makeAuthentication(String token){

        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);

        Claims body = claimsJws.getBody();

        String username = body.getSubject();

        List<Map<String, String>> authorities = (List<Map<String, String>>) body.get("authorities");

        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream()
                .map(m -> new SimpleGrantedAuthority(m.get("authority")))
                .collect(Collectors.toSet());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                username,
                null,
                simpleGrantedAuthorities
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

    public void deleteAllToken(HttpServletRequest request, HttpServletResponse response, String accessToken) throws IOException {
        //리프레시토큰, 액세스토큰, 쿠키 토큰 전부 삭제
        if(accessToken != null){
            stringRedisTemplate.opsForHash().delete("token", accessToken);
            stringRedisTemplate.delete(accessToken.trim());
        }

        for (Cookie requestCookie : request.getCookies()) {
            if (HttpHeaders.AUTHORIZATION.equals(requestCookie.getName())) {
                requestCookie.setMaxAge(0);
                response.addCookie(requestCookie);
                break;
            }
        }
        response.sendRedirect(request.getContextPath() + "/");

    }

}
