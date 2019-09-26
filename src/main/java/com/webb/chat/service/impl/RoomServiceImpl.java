package com.webb.chat.service.impl;

import com.webb.chat.dto.request.RoomRequest;
import com.webb.chat.entity.Room;
import com.webb.chat.repository.RoomRepository;
import com.webb.chat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void createUpdate(RoomRequest request) {
        if (request.getId() == null) {
            save(new Room(), request);
        } else {
            save(findById(request.getId()), request);
        }
    }

    private void save(Room room, RoomRequest request) {
        room.setUsers(userService.findAllById(request.getUsers()));
        room.setName(request.getName());
        roomRepository.save(room);
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no room with id: " + id));
    }
}
