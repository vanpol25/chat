package com.webb.chat.dto.request;

import lombok.Data;

@Data

public class MessageRequest {

    private String text;
    private Long room;
    private Long user;

}
