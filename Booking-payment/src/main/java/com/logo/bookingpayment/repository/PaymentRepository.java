package com.logo.bookingpayment.repository;

import com.logo.bookingpayment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Payment findByUserEmail(String email);
}
