package com.webb.chat.service;

import com.webb.chat.dto.request.MessageRequest;
import com.webb.chat.dto.request.PaginationRequest;
import com.webb.chat.dto.response.MessageResponse;
import com.webb.chat.dto.response.MessagesResponse;

import java.security.Principal;


public interface MessageService {

    void create(Principal principal, MessageRequest request);
    MessagesResponse<MessageResponse> getMessages(Long id, PaginationRequest request);

}
