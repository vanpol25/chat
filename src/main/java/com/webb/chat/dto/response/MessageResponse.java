package com.webb.chat.dto.response;

import com.webb.chat.entity.Message;
import lombok.Data;

import java.util.Date;

@Data

public class MessageResponse {

    private Long id;
    private String content;
    private Date dateTime;
    private UserResponse userResponse;

    public MessageResponse(Message message) {
        id = message.getId();
        content = message.getContent();
        dateTime = message.getDateTime();
        userResponse = new UserResponse(message.getUser());
    }

}
