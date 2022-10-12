package com.ira.springexercise.models.contact;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactMobileNumber extends ContactAbstract {

    private String mobileNumber;

    public ContactMobileNumber() {
    }

    public ContactMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}