package com.webb.chat.dto.response;

import com.webb.chat.entity.Room;
import com.webb.chat.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data

public class RoomResponse {

    private Long id;
    private String name;
    private List<SimpleUserResponse> users;

    public RoomResponse(Room room) {
        id = room.getId();
        name = room.getName();
        users = room.getUsers().stream().map(SimpleUserResponse::new).collect(Collectors.toList());
    }
}
