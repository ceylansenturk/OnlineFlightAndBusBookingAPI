package com.example.bookingmailservice.service;

import com.example.bookingmailservice.model.Email;
import com.example.bookingmailservice.repository.EmailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {
    @Autowired
    EmailRepository emailRepository;
    public void sendEmail(String email){ //email yollamak için (db'ye veri atıyor.)

        Email emailTemp = new Email();
        emailTemp.setToEmail(email);
        emailTemp.setEmailMessage("Hesabın başarıyla oluşturuldu.");
        emailTemp.setTitle("Booking.com");
        emailRepository.save(emailTemp);
    }
}
