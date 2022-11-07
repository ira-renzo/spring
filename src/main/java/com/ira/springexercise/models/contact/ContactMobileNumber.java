package com.ira.springexercise.models.contact;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactMobileNumber extends ContactAbstract {

    private final ContactEnum type = ContactEnum.MOBILE;
    private String value;

    public ContactMobileNumber() {
    }

    public ContactMobileNumber(String value) {
        this.value = value;
    }

}