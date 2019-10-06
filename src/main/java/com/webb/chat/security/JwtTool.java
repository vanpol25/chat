package com.webb.chat.security;

import com.webb.chat.entity.UserRole;
import com.webb.chat.service.impl.UserServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@Component
public class JwtTool {

    @Value("${token.key}")
    private String key;

    @Value("${token.expiring}")
    private long expiring;

    @Autowired
    private UserServiceImpl userService;

    @PostConstruct
    public void init() {
        key = Base64.getEncoder().encodeToString(key.getBytes());
    }

    public String createToken(String username, UserRole userRole) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", Collections.singleton(userRole.name()));

        Date now = new Date();
        Date validity = new Date(now.getTime() + expiring);

        return Jwts.builder().
                setClaims(claims).
                setIssuedAt(now).
                setExpiration(validity).
                signWith(SignatureAlgorithm.HS256, key).
                compact();
    }

    public boolean isTokenValid(String token) {
        Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        return true;
    }

    public String getTokenByBody(HttpServletRequest servletRequest) {
        String token = servletRequest.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        } else {
            token = null;
        }
        return token;
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
    }

}