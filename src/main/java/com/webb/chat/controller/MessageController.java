package com.webb.chat.controller;

import com.webb.chat.dto.request.MessageRequest;
import com.webb.chat.dto.request.PaginationRequest;
import com.webb.chat.dto.response.MessageResponse;
import com.webb.chat.dto.response.MessagesResponse;
import com.webb.chat.service.impl.MessageServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void create(Principal principal, @Valid @RequestBody MessageRequest request) {
        messageServiceImpl.create(principal, request);
    }

    @GetMapping
    public MessagesResponse<MessageResponse> findAllByRoomId(Long roomId, @Valid @RequestBody PaginationRequest paginationRequest) {
        return messageServiceImpl.getMessages(roomId, paginationRequest);
    }

}
