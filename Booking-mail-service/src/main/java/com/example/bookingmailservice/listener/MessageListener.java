package com.example.bookingmailservice.listener;

import com.example.bookingmailservice.service.EmailService;
import com.example.bookingmailservice.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageListener {
    @Autowired
    MessageService messageService;

    @RabbitListener(queues = "booking.email")
    public void messageListener(String phone) { // email dinlemek için

        log.info("phone: {}", phone);
        messageService.sendMessage(phone);
    }
}
