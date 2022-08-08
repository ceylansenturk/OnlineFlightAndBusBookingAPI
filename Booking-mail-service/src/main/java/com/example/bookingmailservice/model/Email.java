package com.example.bookingmailservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "booking_email")
@Data
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String toEmail;
    @Column
    private String title;
    @Column(name = "email_message")
    private String emailMessage;

}
