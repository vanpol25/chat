package com.webb.chat.dto.response;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor

public class MessagesResponse<T> {

    private Long totalElements;
    private List<T> data;

}
