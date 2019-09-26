package com.webb.chat.controller;

import com.webb.chat.dto.request.UserRequest;
import com.webb.chat.dto.response.UserResponse;
import com.webb.chat.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("register")
    public void register(@RequestBody UserRequest userRequest) {
        userServiceImpl.create(userRequest);
    }

    @GetMapping("findByUsername")
    public UserResponse findByUsername(String username) {
        return new UserResponse(userServiceImpl.findByUsername(username));
    }

    @GetMapping("findById")
    public UserResponse findById(Long id) {
        return new UserResponse(userServiceImpl.findById(id));
    }

    @GetMapping("isExists")
    public boolean existsByUsername(String username) {
        return userServiceImpl.existsByUsername(username);
    }

}
