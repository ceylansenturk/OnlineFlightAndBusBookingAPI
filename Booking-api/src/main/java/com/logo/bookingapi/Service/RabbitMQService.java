package com.logo.bookingapi.Service;

import com.logo.bookingapi.Config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitMQConfig rabbitMqConfig;

    public void sendEmail(String email) {
        rabbitTemplate.convertAndSend(rabbitMqConfig.getQueueName(), email);
        // email değeri json tipine convert edilip kuyruğa yazılıyor.
    }
}
