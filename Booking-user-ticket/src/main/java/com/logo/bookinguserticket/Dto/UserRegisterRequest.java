package com.logo.bookinguserticket.Dto;


import com.logo.bookinguserticket.Model.Enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private UserType userType;


    public UserRegisterRequest() {

    }
}