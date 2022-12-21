package com.ira.springexercise.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Address {

    @NonNull
    @Column(nullable = false)
    private String streetNo;

    @NonNull
    @Column(nullable = false)
    private String barangay;

    @NonNull
    @Column(nullable = false)
    private String city;

    @NonNull
    @Column(nullable = false)
    private String zipCode;

}