package com.webb.chat.service;

import com.webb.chat.dto.request.UserRequest;
import com.webb.chat.dto.response.AuthenticationResponse;
import com.webb.chat.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    AuthenticationResponse register(UserRequest userRequest);
    AuthenticationResponse login(UserRequest userRequest);
    boolean existsByUsername(String username);
    User findByUsername(String username);
    User findById(Long id);
    List<User> findAllByUsernames(String firstUsername, String secondUsername);

}
