package com.webb.chat.dto.response;

import com.webb.chat.entity.Message;
import com.webb.chat.entity.User;

import java.sql.Timestamp;

public class MessageResponse {

    private String text;
    private Timestamp dateTime;
    private User user;

    public MessageResponse(Message message) {
        text = message.getText();
        dateTime = message.getDateTime();
        user = message.getUser();
    }

}
