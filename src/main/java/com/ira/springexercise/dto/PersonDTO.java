package com.ira.springexercise.dto;

import com.ira.springexercise.models.Address;
import com.ira.springexercise.models.Name;
import lombok.Data;

import java.util.Date;

@Data
public class PersonDTO {

    private Name name;
    private Address address;
    private Date birthday;
    private Float gwa;
    private Date dateHired;
    private Boolean currentlyEmployed;

}