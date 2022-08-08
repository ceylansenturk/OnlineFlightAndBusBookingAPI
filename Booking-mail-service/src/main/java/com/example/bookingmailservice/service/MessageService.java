package com.example.bookingmailservice.service;

import com.example.bookingmailservice.model.Email;
import com.example.bookingmailservice.model.Message;
import com.example.bookingmailservice.repository.EmailRepository;
import com.example.bookingmailservice.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    public void sendMessage(String phone){ //email yollamak için (db'ye veri atıyor.)
    Message messageTemp = new Message();
        messageTemp.setPhone(phone);
        messageTemp.setMessage("Bilet bilgileriniz");
        messageTemp.setTitle("Booking.com");
        messageRepository.save(messageTemp);
}
}
