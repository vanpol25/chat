package com.webb.chat.dto.request;

import lombok.Data;

import java.util.List;

@Data

public class RoomRequest {

    private Long id;
    private List<Long> users;
    private String name;

}
