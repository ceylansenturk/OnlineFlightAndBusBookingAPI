package com.example.bookingmailservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "booking_message")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String phone;
    @Column
    private String title;
    @Column(name = "message")
    private String message;

}
