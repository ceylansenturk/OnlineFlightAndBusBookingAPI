package com.logo.bookinguserticket.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserChangeInfoRequest {
    private String name;
    private String password;
}

