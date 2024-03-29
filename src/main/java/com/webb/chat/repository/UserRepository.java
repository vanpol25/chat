package com.webb.chat.repository;

import com.webb.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsernameContaining(String username);
    Optional<User> findById(Long id);
    @Query("from User u where u.username in (:firstUsername, :secondUsername)")
    List<User> findAllByUsernames(@Param("firstUsername")String firstUsername, @Param("secondUsername")String secondUsername);

}
