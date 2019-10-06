package com.webb.chat.repository;

import com.webb.chat.entity.Room;
import com.webb.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("from Room r join r.users u where u.username=:username")
    List<Room> findRoomsByUserUsername(@Param("username") String username);

}
