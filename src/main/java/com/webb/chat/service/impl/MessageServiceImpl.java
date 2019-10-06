package com.webb.chat.service.impl;

import com.webb.chat.dto.request.MessageRequest;
import com.webb.chat.dto.request.PaginationRequest;
import com.webb.chat.dto.response.MessageResponse;
import com.webb.chat.dto.response.MessagesResponse;
import com.webb.chat.entity.Message;
import com.webb.chat.repository.MessageRepository;
import com.webb.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserServiceImpl userService;
    private final RoomServiceImpl roomService;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository,
                              UserServiceImpl userService,
                              RoomServiceImpl roomService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
        this.roomService = roomService;
    }

    @Override
    public void create(Principal principal, MessageRequest request) {
        Message message = new Message();
        message.setContent(request.getContent());
        message.setRoom(roomService.findById(request.getRoom()));
        message.setUser(userService.findByUsername(principal.getName()));
        message.setDateTime(new Date());
        messageRepository.save(message);
    }

    @Override
    public MessagesResponse<MessageResponse> getMessages(Long roomId, PaginationRequest request) {
        Page<Message> messages = messageRepository.findAllByRoomId(roomId, request.toPageable());
        return new MessagesResponse<>(
                messages.getTotalPages(),
                messages.getTotalElements(),
                messages.get().map(MessageResponse::new).collect(Collectors.toList()));
    }

}