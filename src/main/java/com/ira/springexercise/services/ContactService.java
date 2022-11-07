package com.ira.springexercise.services;

import com.ira.springexercise.models.Person;
import com.ira.springexercise.models.contact.ContactAbstract;
import com.ira.springexercise.models.contact.ContactEmail;
import com.ira.springexercise.models.contact.ContactLandline;
import com.ira.springexercise.models.contact.ContactMobileNumber;
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
        return String.format("Added: %s", getContactValue(contact));
    }

    public String contactUpdate(Integer personId, Integer contactIdToUpdate, ContactAbstract newContact) {
        Person personToEdit = personRepository.findById(personId).orElse(null);
        if (personToEdit == null) return "Person ID Not Found";
        for (ContactAbstract contact : personToEdit.getContacts()) {
            if (contact.getId() == contactIdToUpdate) {
                personToEdit.getContacts().remove(contact);
                personToEdit.getContacts().add(newContact);
                personRepository.save(personToEdit);
                return String.format("Updated: [%d] %s", contactIdToUpdate, getContactValue(contact));
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
                return String.format("Deleted: [%d] %s", contactIdToDelete, getContactValue(contact));
            }
        }
        return "Contact ID Not Found In User";
    }

    private String getContactValue(ContactAbstract contact) {
        if (contact instanceof ContactEmail) return ((ContactEmail) contact).getValue();
        else if (contact instanceof ContactLandline) return ((ContactLandline) contact).getValue();
        else if (contact instanceof ContactMobileNumber) return ((ContactMobileNumber) contact).getValue();
        return null;
    }

}