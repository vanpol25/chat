package com.webb.chat.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data

public class UserRequest {

    @NotNull
    private String username;
    @NotNull
    private String password;
    private String firstName;
    private String secondName;
    private Integer phoneNumber;

}
