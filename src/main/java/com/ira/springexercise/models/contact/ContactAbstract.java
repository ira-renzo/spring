package com.ira.springexercise.models.contact;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
@Data
@NoArgsConstructor
public abstract class ContactAbstract {

    @Id
    @GeneratedValue(generator = "contact_sequence")
    @GenericGenerator(name = "contact_sequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    private int id;

}