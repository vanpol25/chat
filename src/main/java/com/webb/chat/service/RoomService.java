package com.webb.chat.service;

import com.webb.chat.dto.request.RoomRequest;
import com.webb.chat.entity.Room;

public interface RoomService {

    void createUpdate(RoomRequest request);
    Room findById(Long id);

}
