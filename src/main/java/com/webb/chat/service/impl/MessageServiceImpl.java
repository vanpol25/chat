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
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoomServiceImpl roomService;

    @Override
    public void create(MessageRequest request) {
        Message message = new Message();
        message.setText(request.getText());
        message.setRoom(roomService.findById(request.getRoom()));
        message.setUser(userService.findById(request.getUser()));
        message.setDateTime(new Timestamp(new Date().getTime()));
        messageRepository.save(message);
    }

    @Override
    public MessagesResponse<MessageResponse> getMessages(PaginationRequest request) {
        List<Message> messages = messageRepository.findAllByRoomId(request.getRoom());
        Page<Message> page = new PageImpl<>(messages, request.toPageable(), request.getSize());
        return new MessagesResponse<>(page.getTotalElements(),
                page.get().map(MessageResponse::new).collect(Collectors.toList()));
    }

}
