package com.ira.springexercise.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {

    @Column(nullable = false)
    private String streetNo;

    @Column(nullable = false)
    private String barangay;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String zipCode;

}