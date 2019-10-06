package com.webb.chat.dto.request;

import lombok.Data;

@Data

public class UserRequest {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private Integer phoneNumber;

}
