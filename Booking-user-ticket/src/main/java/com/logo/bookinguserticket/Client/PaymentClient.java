package com.logo.bookinguserticket.Client;


import com.logo.bookinguserticket.Dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${payment.url}", value = "payment-service")
public interface PaymentClient {
    @PostMapping
    ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto request);
    @GetMapping("{email}")
    ResponseEntity<PaymentDto> getPaymentByEmail(@PathVariable String email);
}