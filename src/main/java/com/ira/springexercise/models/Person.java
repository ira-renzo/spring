package com.ira.springexercise.models;

import com.ira.springexercise.models.contact.ContactAbstract;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(generator = "person_sequence")
    @GenericGenerator(name = "person_sequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    private int id;

    @Embedded
    private Name name;

    @Embedded
    private Address address;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(nullable = false)
    private Float gwa;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateHired;

    @Column(nullable = false)
    private Boolean currentlyEmployed;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_person_contact")
    private List<ContactAbstract> contacts = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "join_person_role")
    private Set<Role> roles = new LinkedHashSet<>();

}