package com.logo.bookingpayment.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Data
public class PaymentDto implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String userEmail;
    private String cardNumber;
    private Integer securityCode;
    private Currency currency;
    private BigDecimal amount;
    private LocalDateTime paymentTime;

}
