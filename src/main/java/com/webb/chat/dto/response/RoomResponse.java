package com.webb.chat.dto.response;

import com.webb.chat.entity.Room;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data

public class RoomResponse {

    private Long id;
    private String name;
    private List<UserResponse> users;

    public RoomResponse(Room room) {
        id = room.getId();
        name = room.getName();
        users = room.getUsers().stream().map(UserResponse::new).collect(Collectors.toList());
    }
}
