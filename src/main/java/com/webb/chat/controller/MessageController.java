package com.webb.chat.controller;

import com.webb.chat.dto.request.MessageRequest;
import com.webb.chat.dto.request.PaginationRequest;
import com.webb.chat.dto.response.MessageResponse;
import com.webb.chat.dto.response.MessagesResponse;
import com.webb.chat.service.impl.MessageServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping("message")
public class MessageController {

    private final MessageServiceImpl messageServiceImpl;

    @Autowired
    public MessageController(MessageServiceImpl messageServiceImpl) {
        this.messageServiceImpl = messageServiceImpl;
    }

    @PreAuthorize("authentication.principal==#request.sender")
    @PostMapping
    public void create(@Valid @RequestBody MessageRequest request) {
        messageServiceImpl.create(request);
    }

    @GetMapping
    public MessagesResponse<MessageResponse> findAllByRoomId(@Valid @RequestBody PaginationRequest paginationRequest) {
        return messageServiceImpl.getMessages(paginationRequest);
    }

}
