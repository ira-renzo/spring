package com.ira.springexercise.models;

import com.ira.springexercise.models.contact.ContactAbstract;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {

    @Id
    @GeneratedValue(generator = "person_sequence")
    @GenericGenerator(name = "person_sequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    private int id;

    @NonNull
    @Column(nullable = false)
    @Embedded
    private Name name;

    @NonNull
    @Column(nullable = false)
    @Embedded
    private Address address;

    @NonNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @NonNull
    @Column(nullable = false)
    private Float gwa;

    @NonNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateHired;

    @NonNull
    @Column(nullable = false)
    private Boolean currentlyEmployed;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_person_contact")
    private List<ContactAbstract> contacts = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "join_person_role")
    private Set<Role> roles = new LinkedHashSet<>();

}