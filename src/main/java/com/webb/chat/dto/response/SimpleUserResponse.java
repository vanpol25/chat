package com.webb.chat.dto.response;

import com.webb.chat.entity.User;
import lombok.Data;

@Data

public class SimpleUserResponse {

    private Long id;
    private String username;

    public SimpleUserResponse(User user) {
        id = user.getId();
        username = user.getUsername();
    }
}
