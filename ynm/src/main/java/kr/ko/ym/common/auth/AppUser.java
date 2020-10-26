package kr.ko.ym.common.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class AppUser implements UserDetails {

    private Set<SimpleGrantedAuthority> grantedAuthorityList;
    private String username;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialNonExpired;
    private boolean isEnabled;

    private AppUser(){
    }; //디폴트 생성자

    public AppUser createInstance(
                   String username,
                   String password,
                   Set<SimpleGrantedAuthority> grantedAuthorityList,
                   boolean isAccountNonExpired,
                   boolean isAccountNonLocked,
                   boolean isCredentialNonExpired,
                   boolean isEnabled) {

        AppUser appUser = new AppUser();

        appUser.grantedAuthorityList = grantedAuthorityList;
        appUser.username = username;
        appUser.password = password;
        appUser.isAccountNonExpired = isAccountNonExpired;
        appUser.isAccountNonLocked = isAccountNonLocked;
        appUser.isCredentialNonExpired = isCredentialNonExpired;
        appUser.isEnabled = isEnabled;

        return appUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setGrantedAuthorityList(Set<SimpleGrantedAuthority> grantedAuthorityList) {
        this.grantedAuthorityList = grantedAuthorityList;
    }

}
