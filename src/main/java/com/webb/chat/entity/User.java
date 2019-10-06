package com.webb.chat.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "user_role")
    private UserRole userRole;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "phone_number", unique = true)
    private Integer phoneNumber;
    @OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<>();
    @ManyToMany
    private List<Room> rooms = new ArrayList<>();

}
