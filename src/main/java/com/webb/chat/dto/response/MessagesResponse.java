package com.webb.chat.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class MessagesResponse<T> {

    private Integer totalContent;
    private Long totalElements;
    private List<T> data;

}
