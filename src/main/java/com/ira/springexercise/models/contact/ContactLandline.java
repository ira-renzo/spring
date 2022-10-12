package com.ira.springexercise.models.contact;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactLandline extends ContactAbstract {

    private String landline;

    public ContactLandline() {
    }

    public ContactLandline(String landline) {
        this.landline = landline;
    }

}