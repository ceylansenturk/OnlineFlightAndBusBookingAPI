package com.logo.bookinguserticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookingUserTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingUserTicketApplication.class, args);
    }

}
