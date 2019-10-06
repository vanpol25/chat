package com.webb.chat.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data

public class RoomRequest {

    @NotNull
    private Long id;
    private String RoomName;
    private String myUsername;
    private String friendUsername;

}
