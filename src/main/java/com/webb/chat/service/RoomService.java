package com.webb.chat.service;

import com.webb.chat.dto.request.RoomRequest;
import com.webb.chat.dto.response.RoomResponse;
import com.webb.chat.entity.Room;

import java.security.Principal;
import java.util.List;

public interface RoomService {

    void create(Principal principal, RoomRequest request);

    void updateName(RoomRequest request);

    Room findById(Long id);

    List<RoomResponse> findRoomsByUserId(Long id);

    void addAndRemoveUserInRoom(RoomRequest request);
}
