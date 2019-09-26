package com.webb.chat.service;

import com.webb.chat.dto.request.MessageRequest;
import com.webb.chat.dto.request.PaginationRequest;
import com.webb.chat.dto.response.MessageResponse;
import com.webb.chat.dto.response.MessagesResponse;

public interface MessageService {

    void create(MessageRequest request);
    MessagesResponse<MessageResponse> getMessages(PaginationRequest request);

}
