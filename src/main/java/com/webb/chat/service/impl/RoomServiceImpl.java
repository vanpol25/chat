package com.webb.chat.service.impl;

import com.webb.chat.dto.request.RoomRequest;
import com.webb.chat.dto.response.RoomResponse;
import com.webb.chat.entity.Room;
import com.webb.chat.entity.User;
import com.webb.chat.repository.RoomRepository;
import com.webb.chat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private final UserServiceImpl userService;
    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(UserServiceImpl userService,
                           RoomRepository roomRepository) {
        this.userService = userService;
        this.roomRepository = roomRepository;
    }

    @Override
    public void create(RoomRequest request) {
        Room room = new Room();
        room.setUsers(userService.findAllByUsernames(request.getMyUsername(), request.getFriendUsername()));
        room.setName(request.getRoomName());
        save(room);
    }

    @Override
    public void addAndRemoveUserInRoom(RoomRequest request) {
        Room room = findById(request.getId());
        User user = userService.findByUsername(request.getFriendUsername());
        if (!isExistInRoom(room, user)) {
            room.getUsers().add(user);
        } else {
            room.getUsers().remove(user);
        }
        save(room);
    }

    @Override
    public void updateName(RoomRequest request) {
        Room room = findById(request.getId());
        room.setName(request.getRoomName());
        save(room);
    }

    private void save(Room room) {
        roomRepository.save(room);
    }

    private boolean isExistInRoom(Room room, User user) {
        return room.getUsers().contains(user);
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no room with id: " + id));
    }

    @Override
    public List<RoomResponse> findRoomsByUserUsername(String username) {
        return roomRepository.findRoomsByUserUsername(username)
                .stream()
                .map(RoomResponse::new)
                .collect(Collectors.toList());
    }

}
