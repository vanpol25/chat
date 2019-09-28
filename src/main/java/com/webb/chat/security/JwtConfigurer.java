package com.webb.chat.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private JwtTool jwtTool;

    public JwtConfigurer(JwtTool jwtTool) {
        this.jwtTool = jwtTool;
    }

    @Override
    public void configure(HttpSecurity httpSecurity){
        JwtFilter jwtFilter = new JwtFilter(jwtTool);
        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
