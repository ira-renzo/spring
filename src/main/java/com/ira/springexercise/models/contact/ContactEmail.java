package com.ira.springexercise.models.contact;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactEmail extends ContactAbstract {

    private String email;

    public ContactEmail() {
    }

    public ContactEmail(String email) {
        this.email = email;
    }

}