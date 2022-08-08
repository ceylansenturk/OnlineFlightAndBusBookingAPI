package com.logo.bookinguserticket.Dto;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class MessageDto implements Serializable {
    private @Id Integer id;
    private String phone;
    private String title;
    private String description;
}
