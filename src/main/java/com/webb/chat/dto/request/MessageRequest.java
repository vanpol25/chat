package com.webb.chat.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data

public class MessageRequest {

    private Long id;
    @NotNull
    private String content;
    @NotNull
    private Long roomId;
    @NotNull
    private String sender;

}
