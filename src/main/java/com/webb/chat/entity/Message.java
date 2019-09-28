package com.webb.chat.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String text;

    @Column(name = "date_time")
    private Timestamp dateTime;

    @ManyToOne
    private Room room;

    @ManyToOne
    private User user;

}
