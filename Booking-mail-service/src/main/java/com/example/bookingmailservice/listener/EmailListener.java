package com.example.bookingmailservice.listener;

import com.example.bookingmailservice.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailListener {
    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "booking.email")
    public void emailListener(String email) { // email dinlemek için

        log.info("email address: {}", email);
        emailService.sendEmail(email);
    }
}
