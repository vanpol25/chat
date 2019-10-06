package com.webb.chat.dto.request;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.NotNull;

@Data

public class PaginationRequest {

    private final static Integer NUMBER_OF_MESSAGES_TO_LOAD = 50;

    @NotNull
    private Integer page;
    private Long room;
    private MessageRequest request;

    private Sort sort = new Sort(Sort.Direction.DESC, "date_time");

    public Pageable toPageable() {
        return PageRequest.of(page, NUMBER_OF_MESSAGES_TO_LOAD, sort);
    }

}
