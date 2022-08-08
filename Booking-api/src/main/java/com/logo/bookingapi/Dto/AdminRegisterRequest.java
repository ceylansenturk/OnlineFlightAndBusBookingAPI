package com.logo.bookingapi.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;


public class AdminRegisterRequest {
    private String name;
    private String surname;
    private String company;
    private String email;
    private String password;
    private String phone;

    public AdminRegisterRequest(String name, String surname, String company, String email, String password, String phone) {
        this.name = name;
        this.surname = surname;
        this.company = company;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
