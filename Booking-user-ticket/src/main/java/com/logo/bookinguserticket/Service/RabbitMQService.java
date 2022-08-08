package com.logo.bookinguserticket.Service;
import com.logo.bookinguserticket.Config.RabbitMQConfig;
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
    public void sendMessage(String phone) {
        rabbitTemplate.convertAndSend(rabbitMqConfig.getQueueName(), phone);
        // email değeri json tipine convert edilip kuyruğa yazılıyor.
    }
}
