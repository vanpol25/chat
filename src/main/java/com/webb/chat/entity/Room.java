package com.webb.chat.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "updated")
    private Date updated;

    @ManyToMany(mappedBy = "rooms")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "room")
    private List<Message> messages = new ArrayList<>();

}
