package com.ira.springexercise.models.contact;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactEmail extends ContactAbstract {

    private final ContactEnum type = ContactEnum.EMAIL;
    private String value;

    public ContactEmail() {
    }

    public ContactEmail(String value) {
        this.value = value;
    }

}