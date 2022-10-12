package com.ira.springexercise.services;

import com.ira.springexercise.models.Person;
import com.ira.springexercise.models.Role;
import com.ira.springexercise.repositories.PersonRepository;
import com.ira.springexercise.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonService {

    final PersonRepository personRepository;
    final RoleRepository roleRepository;

    public PersonService(PersonRepository personRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
    }

    public String personCreate(Person newPerson) {
        personRepository.save(newPerson);
        return String.format("Saved: [%d] %s %s",
                newPerson.getId(),
                newPerson.getName().getFirstName(),
                newPerson.getName().getLastName());
    }

    public String personDelete(Integer id) {
        try {
            Person toBeDeletedPerson = personRepository.findById(id).orElseThrow();
            personRepository.deleteById(id);
            return String.format("Deleted: [%d] %s %s",
                    id,
                    toBeDeletedPerson.getName().getFirstName(),
                    toBeDeletedPerson.getName().getLastName());
        } catch (NoSuchElementException exception) {
            return "ID Not Found";
        }
    }

    public String personUpdate(Person personToUpdate) {
        if (!personRepository.existsById(personToUpdate.getId())) return "Person Does Not Exist";
        personRepository.save(personToUpdate);
        return String.format("Updated: [%d] %s %s",
                personToUpdate.getId(),
                personToUpdate.getName().getFirstName(),
                personToUpdate.getName().getLastName());
    }

    public List<Person> personList() {
        return StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .sorted(Comparator.comparing(Person::getGwa)
                        .thenComparing(Person::getDateHired)
                        .thenComparing(person -> person.getName().getLastName()))
                .collect(Collectors.toList());
    }

    public String personRoleAdd(Integer personId, String roleNameToAdd) {
        Person personToEdit = personRepository.findById(personId).orElse(null);
        if (personToEdit == null) return "Person ID Not Found";
        Role roleToAdd = roleRepository.findByRoleNameEqualsIgnoreCase(roleNameToAdd);
        if (roleToAdd == null) return "Role ID Not Found";
        personToEdit.getRoles().add(roleToAdd);
        personRepository.save(personToEdit);
        return String.format("Added: %s to %s", roleToAdd.getRoleName(), personToEdit.getName().getFirstName());
    }

    public String personRoleDelete(Integer personId, String roleNameToAdd) {
        Person personToEdit = personRepository.findById(personId).orElse(null);
        if (personToEdit == null) return "Person ID Not Found";
        Role roleToAdd = roleRepository.findByRoleNameEqualsIgnoreCase(roleNameToAdd);
        if (roleToAdd == null) return "Role ID Not Found";
        personToEdit.getRoles().remove(roleToAdd);
        personRepository.save(personToEdit);
        return String.format("Removed: %s in %s", roleToAdd.getRoleName(), personToEdit.getName().getFirstName());
    }
}