package com.logo.bookinguserticket.Dto;


import com.logo.bookinguserticket.Model.Enums.UserType;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    private String phone;

    private UserType userType;

    private PaymentDto payment;

    public UserDto(String name, String surname, String email, String password, String phone,UserType userType) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
    }
}

