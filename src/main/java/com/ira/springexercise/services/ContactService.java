package com.ira.springexercise.services;

import com.ira.springexercise.models.Person;
import com.ira.springexercise.models.contact.ContactAbstract;
import com.ira.springexercise.repositories.ContactRepository;
import com.ira.springexercise.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    final ContactRepository contactRepository;
    final PersonRepository personRepository;

    public ContactService(ContactRepository contactRepository, PersonRepository personRepository) {
        this.contactRepository = contactRepository;
        this.personRepository = personRepository;
    }

    public String contactAdd(Integer personId, ContactAbstract contact) {
        Person personToEdit = personRepository.findById(personId).orElse(null);
        if (personToEdit == null) return "Person ID Not Found";
        personToEdit.getContacts().add(contact);
        personRepository.save(personToEdit);
        return String.format("Added: %s", contact.getClass());
    }

    public String contactUpdate(Integer personId, Integer contactIdToUpdate, ContactAbstract newContact) {
        Person personToEdit = personRepository.findById(personId).orElse(null);
        if (personToEdit == null) return "Person ID Not Found";
        for (ContactAbstract contact : personToEdit.getContacts()) {
            if (contact.getId() == contactIdToUpdate) {
                personToEdit.getContacts().remove(contact);
                personToEdit.getContacts().add(newContact);
                personRepository.save(personToEdit);
                return String.format("Updated: [%d] %s", contactIdToUpdate, newContact.getClass());
            }
        }
        return "Contact ID Not Found In User";
    }

    public String contactDelete(Integer personId, Integer contactIdToDelete) {
        Person personToEdit = personRepository.findById(personId).orElse(null);
        if (personToEdit == null) return "Person ID Not Found";
        for (ContactAbstract contact : personToEdit.getContacts()) {
            if (contact.getId() == contactIdToDelete) {
                personToEdit.getContacts().remove(contact);
                personRepository.save(personToEdit);
                return String.format("Delete: [%d] %s", contactIdToDelete, contact.getClass());
            }
        }
        return "Contact ID Not Found In User";
    }

}