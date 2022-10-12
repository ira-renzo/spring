package com.ira.springexercise.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Role {

    @Id
    @GeneratedValue(generator = "role_sequence")
    @GenericGenerator(name = "role_sequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    private int id;

    @Column(nullable = false, unique = true)
    @NonNull
    private String roleName;

}