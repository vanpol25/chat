package com.webb.chat.repository;

import com.webb.chat.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

   Page<Message> findAllByRoomId(Long id, Pageable pageable);

   boolean existsByUser_Username(String username);
}
