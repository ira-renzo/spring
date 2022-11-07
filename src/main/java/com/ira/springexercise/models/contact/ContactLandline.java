package com.ira.springexercise.models.contact;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactLandline extends ContactAbstract {

    private final ContactEnum type = ContactEnum.LANDLINE;
    private String value;

    public ContactLandline() {
    }

    public ContactLandline(String value) {
        this.value = value;
    }

}