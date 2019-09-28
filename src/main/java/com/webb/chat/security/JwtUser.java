package com.webb.chat.security;

import com.webb.chat.entity.User;
import com.webb.chat.entity.UserRole;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data

public class JwtUser implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private List<UserRole> authorities;

    public JwtUser(User user) {
        username = user.getUsername();
        password = user.getPassword();
        authorities = Arrays.asList(user.getUserRole());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
