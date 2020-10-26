package kr.ko.ym.common.jwt;

import com.google.common.base.Strings;
import com.google.common.net.HttpHeaders;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtTokenVerifier extends OncePerRequestFilter {

    private final SecretKey secretKey;

    public JwtTokenVerifier(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String requestHeader = "";

        Cookie[] requestCookies = request.getCookies();

        if(requestCookies != null){

            for(Cookie requestCookie : requestCookies){
                if(HttpHeaders.AUTHORIZATION.equals(requestCookie.getName())){
                    requestHeader = requestCookie.getValue();
                    break;
                }
            }
        }else{
            filterChain.doFilter(request, response);
            return;
        }

        if(Strings.isNullOrEmpty(requestHeader) || !requestHeader.startsWith(URLEncoder.encode("Bearer ", "UTF-8"))){
            filterChain.doFilter(request, response);
            return;
        }

        String token = requestHeader.replace(URLEncoder.encode("Bearer ", "UTF-8"), " ");

        try {

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

        } catch(JwtException e) {
            throw new IllegalStateException(String.format("Token %s cannot be trust", token));
        }


        //filter1에서 filter2로 넘겨줘야함
        filterChain.doFilter(request, response);


    }
}
