package com.webb.chat.service.impl;

import com.webb.chat.dto.request.UserRequest;
import com.webb.chat.dto.response.AuthenticationResponse;
import com.webb.chat.dto.response.RoomResponse;
import com.webb.chat.entity.Room;
import com.webb.chat.entity.User;
import com.webb.chat.entity.UserRole;
import com.webb.chat.repository.RoomRepository;
import com.webb.chat.repository.UserRepository;
import com.webb.chat.security.JwtTool;
import com.webb.chat.security.JwtUser;
import com.webb.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JwtTool jwtTool;
    @Autowired
    private  AuthenticationManager authenticationManager;


    @PostConstruct
    public void init() {
        if (!userRepository.findByUsername("1").isPresent()) {
            User user = new User();
            user.setUsername("1");
            user.setPassword(bCryptPasswordEncoder.encode("1"));
            user.setUserRole(UserRole.ROLE_USER);
            userRepository.save(user);
        }
    }

    @Override
    public AuthenticationResponse register(UserRequest request) {
        if (existsByUsername(request.getUsername())) {
            throw new BadCredentialsException("User with username " + request.getUsername() + " already exists");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setUserRole(UserRole.ROLE_USER);
        user.setFirstName(request.getFirstName());
        user.setSecondName(request.getSecondName());
        user.setPhoneNumber(request.getPhoneNumber());
        userRepository.save(user);
        return login(request);
    }

    @Override
    public AuthenticationResponse login(UserRequest request) {
        System.out.println("In login method");
        String username = request.getUsername();
        User user = findByUsername(username);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, request.getPassword()));
        String token = jwtTool.createToken(username, user.getUserRole());
        return new AuthenticationResponse(username, token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        return new JwtUser(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with username " + username + "not found!"));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User with id " + id + "not found!"));
    }

    @Override
    public List<User> findAllByUsernames(String firstUsername, String secondUsername) {
        return userRepository.findAllByUsernames(firstUsername, secondUsername);
    }

}