package com.webb.chat.controller;

import com.webb.chat.dto.request.RoomRequest;
import com.webb.chat.dto.response.RoomResponse;
import com.webb.chat.dto.response.UserResponse;
import com.webb.chat.service.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("room")
public class RoomController {

    private final RoomServiceImpl roomServiceImpl;

    @Autowired
    public RoomController(RoomServiceImpl roomServiceImpl) {
        this.roomServiceImpl = roomServiceImpl;
    }
    
    @PostMapping
    public void create(Principal principal, @Valid @RequestBody RoomRequest request) {
        roomServiceImpl.create(principal, request);
    }

    @PutMapping("updateName")
    public void updateName(@RequestBody RoomRequest request) {
        roomServiceImpl.updateName(request);
    }

}

