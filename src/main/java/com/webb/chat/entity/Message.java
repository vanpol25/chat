package com.webb.chat.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "date_time")
    private Date dateTime;

    @ManyToOne
    private Room room;

    @ManyToOne
    private User user;

}
