package com.logo.bookingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingApiApplication.class, args);
    }

}
