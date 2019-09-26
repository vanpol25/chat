package com.webb.chat.dto.request;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.NotNull;

@Data

public class PaginationRequest {

    private final static Integer NUMBER_OF_MESSAGES_TO_LOAD = 20;

    @NotNull
    private Integer page;
    private Long room;

    public Integer getSize() {
        return NUMBER_OF_MESSAGES_TO_LOAD;
    }

    public Pageable toPageable() {
        return PageRequest.of(page, NUMBER_OF_MESSAGES_TO_LOAD, Sort.Direction.DESC, "id");
    }

}
