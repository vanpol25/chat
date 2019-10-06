package com.webb.chat.repository;

import com.webb.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

    @Query("from User u where u.username=:firstUsername or u.username=:secondUsername")
    List<User> findAllByUsernames(@Param("firstUsername")String firstUsername, @Param("secondUsername")String secondUsername);

}
