package com.logo.bookingapi.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminChangeInfoRequest {
    private String name;
    private String password;
}
