package com.ira.springexercise.dto;

import com.ira.springexercise.models.contact.ContactEnum;
import lombok.Data;

@Data
public class ContactDTO {

    private ContactEnum type;
    private String value;

}