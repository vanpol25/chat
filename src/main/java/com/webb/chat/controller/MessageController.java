package com.webb.chat.controller;

import com.webb.chat.dto.request.MessageRequest;
import com.webb.chat.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageServiceImpl;

    @PostMapping
    public void create(@Valid @RequestBody MessageRequest request) {
        messageServiceImpl.create(request);
    }
}
