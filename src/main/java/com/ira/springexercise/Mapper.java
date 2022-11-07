package com.ira.springexercise;

import com.ira.springexercise.dto.ContactDTO;
import com.ira.springexercise.dto.PersonDTO;
import com.ira.springexercise.models.Person;
import com.ira.springexercise.models.contact.ContactAbstract;
import com.ira.springexercise.models.contact.ContactEmail;
import com.ira.springexercise.models.contact.ContactLandline;
import com.ira.springexercise.models.contact.ContactMobileNumber;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Person toPerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setAddress(personDTO.getAddress());
        person.setBirthday(personDTO.getBirthday());
        person.setGwa(personDTO.getGwa());
        person.setDateHired(personDTO.getDateHired());
        person.setCurrentlyEmployed(personDTO.getCurrentlyEmployed());
        return person;
    }

    public ContactAbstract toContact(ContactDTO contactDTO) {
        switch (contactDTO.getType()) {
            case EMAIL:
                return new ContactEmail(contactDTO.getValue());
            case LANDLINE:
                return new ContactLandline(contactDTO.getValue());
            case MOBILE:
                return new ContactMobileNumber(contactDTO.getValue());
            default:
                return null;
        }
    }

}