package com.webb.chat.controller;

import com.webb.chat.dto.request.UserRequest;
import com.webb.chat.dto.response.AuthenticationResponse;
import com.webb.chat.dto.response.UserResponse;
import com.webb.chat.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping("user")
@Controller
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("register")
    public AuthenticationResponse register(@Valid @RequestBody UserRequest userRequest) {
        return userServiceImpl.register(userRequest);
    }

    @PostMapping("login")
    public AuthenticationResponse login(@Valid @RequestBody UserRequest userRequest) {
        return userServiceImpl.login(userRequest);
    }

    @GetMapping("findByUsername")
    public UserResponse findByUsername(Principal username) {
        return new UserResponse(userServiceImpl.findByUsername(username.getName()));
    }

    @GetMapping("isExists")
    public boolean existsByUsername(Principal username) {
        return userServiceImpl.existsByUsername(username.getName());
    }

    @GetMapping("getName")
    public String getName(Principal principal) {
        String name = principal.getName();
        System.out.println("Principal - " + name);
        return name;
    }

}
