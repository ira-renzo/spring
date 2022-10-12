package com.ira.springexercise.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Name {

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    private String suffix;

    private String title;

}