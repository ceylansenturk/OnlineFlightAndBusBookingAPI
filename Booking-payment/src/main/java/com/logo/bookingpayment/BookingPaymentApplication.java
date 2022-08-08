package com.logo.bookingpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookingPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingPaymentApplication.class, args);
    }

}
