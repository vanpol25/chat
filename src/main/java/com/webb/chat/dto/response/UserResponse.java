package com.webb.chat.dto.response;

import com.webb.chat.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data

public class UserResponse {

    private Long id;
    private String username;
    private String firstName;
    private String secondName;
    private Integer phoneNumber;
    private List<RoomResponse> rooms;

    public UserResponse(User user) {
        id = user.getId();
        username = user.getUsername();
        firstName = user.getFirstName();
        secondName = user.getSecondName();
        phoneNumber = user.getPhoneNumber();
        rooms = user.getRooms().stream().map(RoomResponse::new).collect(Collectors.toList());
    }

}