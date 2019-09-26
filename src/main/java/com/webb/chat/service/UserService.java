package com.webb.chat.service;

import com.webb.chat.dto.request.UserRequest;
import com.webb.chat.dto.response.AuthenticationResponse;
import com.webb.chat.entity.User;

import java.util.List;

public interface UserService {

    AuthenticationResponse register(UserRequest userRequest);
    AuthenticationResponse login(UserRequest userRequest);
    boolean existsByUsername(String username);
    User findByUsername(String username);
    User findById(Long id);
    List<User> findAllById(List<Long> id);

}
