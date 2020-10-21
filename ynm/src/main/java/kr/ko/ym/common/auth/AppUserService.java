package kr.ko.ym.common.auth;

import com.google.common.collect.Lists;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static kr.ko.ym.common.security.AppUserRole.*;

@Service
public class AppUserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    public AppUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return getApplicationUsers().get(0);
    }

    private List<AppUser> getApplicationUsers() {
        List<AppUser> applicationUsers = Lists.newArrayList(
                new AppUser(
                        "test",
                        passwordEncoder.encode("password"),
                        USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new AppUser(
                        "test2",
                        passwordEncoder.encode("password1"),
                        USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new AppUser(
                        "test3",
                        passwordEncoder.encode("password2"),
                        MANAGER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );

        return applicationUsers;
    }
}
