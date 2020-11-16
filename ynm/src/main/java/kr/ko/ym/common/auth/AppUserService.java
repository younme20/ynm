package kr.ko.ym.common.auth;

import kr.ko.ym.common.dao.CommonDao;
import kr.ko.ym.common.security.AppUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    public CommonDao commonDao;

    private final PasswordEncoder passwordEncoder;

    public AppUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getApplicationUsers(username);
    }

    private AppUser getApplicationUsers(String username) {
        AppUser appUser =
                (AppUser)commonDao.selectOptional("user.selectUserByUserName", username);

        String role = (String)commonDao.selectOptional("user.selectUserRolesByUserName", username);

        appUser.setGrantedAuthorityList(AppUserRole.valueOf(role).getGrantedAuthorities());
        return appUser;
    }


}
