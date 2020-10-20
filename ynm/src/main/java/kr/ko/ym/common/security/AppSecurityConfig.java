package kr.ko.ym.common.security;


import kr.ko.ym.common.auth.AppUserService;
import kr.ko.ym.common.jwt.JwtAuthenticationFilter;
import kr.ko.ym.common.jwt.JwtTokenVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final AppUserService appUserService;
    private final SecretKey secretKey;

    @Autowired
    public AppSecurityConfig(PasswordEncoder passwordEncoder,
                             AppUserService appUserService,
                             SecretKey secretKey) {
        this.passwordEncoder = passwordEncoder;
        this.appUserService = appUserService;
        this.secretKey = secretKey;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                //.csrf()
                //    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //    .and()
                //.httpBasic().disable()
                //.formLogin().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey), JwtAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/", "/login", "/resources/**/**").permitAll()
                .anyRequest()
                .authenticated();
                //.permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }

}