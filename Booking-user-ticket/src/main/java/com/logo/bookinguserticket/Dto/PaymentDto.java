package com.logo.bookinguserticket.Dto;


import com.logo.bookinguserticket.Model.Enums.CurrencyType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PaymentDto implements Serializable {
    private Long id;
    private String email;
    private @NotBlank String cardNumber;
    private @NotBlank Integer securityCode;
    private CurrencyType currencyType;
    private double amount;
    private LocalDateTime paymentTime;

    @Override
    public String toString() {
        return "PaymentDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", securityCode=" + securityCode +
                ", currencyType=" + currencyType +
                ", amount=" + amount +
                ", paymentTime=" + paymentTime +
                '}';
    }
}
