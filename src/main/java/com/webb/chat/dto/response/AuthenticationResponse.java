package com.webb.chat.dto.response;

import lombok.Data;

@Data

public class AuthenticationResponse {

    private String username;
    private String token;

    public AuthenticationResponse(String username, String token) {
        this.username = username;
        this.token = token;
    }

}
