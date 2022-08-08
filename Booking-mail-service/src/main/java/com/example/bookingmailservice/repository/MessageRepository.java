package com.example.bookingmailservice.repository;

import com.example.bookingmailservice.model.Email;
import com.example.bookingmailservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
}
