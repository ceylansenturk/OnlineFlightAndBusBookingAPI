package com.logo.bookingpayment.service;

import com.logo.bookingpayment.dto.PaymentDto;
import com.logo.bookingpayment.model.Payment;
import com.logo.bookingpayment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    public PaymentDto createPayment(PaymentDto request) {
        log.info("Ödeme servisine ulaştı");
        paymentRepository.save(modelMapper.map(request, Payment.class));
        return request;
    }

    public PaymentDto getPaymentByEmail(String email) {
        log.info("Ödeme görütnüleme servisine ulaştı");
        return modelMapper.map(paymentRepository.findByUserEmail(email), PaymentDto.class);
    }

}
