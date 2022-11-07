package com.ira.springexercise.controllers;

import com.ira.springexercise.Mapper;
import com.ira.springexercise.dto.PersonDTO;
import com.ira.springexercise.dto.RoleDTO;
import com.ira.springexercise.models.Person;
import com.ira.springexercise.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    final PersonService personService;
    final Mapper mapper;

    public PersonController(PersonService personService, Mapper mapper) {
        this.personService = personService;
        this.mapper = mapper;
    }

    @PostMapping(value = "/create")
    public Map<String, Object> personCreate(@RequestBody PersonDTO personDTO) {
        Person newPerson = mapper.toPerson(personDTO);
        return personService.personCreate(newPerson);
    }

    @DeleteMapping("/delete/{personId}")
    public Map<String, String> personDelete(@PathVariable Integer personId) {
        return Collections.singletonMap("result", personService.personDelete(personId));
    }

    @PutMapping(value = "/update/{personId}")
    public Map<String, String> personUpdate(@PathVariable Integer personId, @RequestBody PersonDTO personDTO) {
        Person personToUpdate = mapper.toPerson(personDTO);
        personToUpdate.setId(personId);
        return Collections.singletonMap("result", personService.personUpdate(personToUpdate));
    }

    @GetMapping("/list")
    public List<Person> personList() {
        return personService.personList();
    }

    @PutMapping(value = "/add-role/{personId}")
    public Map<String, String> personRoleAdd(@PathVariable Integer personId, @RequestBody RoleDTO roleToAddDTO) {
        return Collections.singletonMap("result", personService.personRoleAdd(personId, roleToAddDTO.getRoleName()));
    }

    @DeleteMapping(value = "/delete-role/{personId}")
    public Map<String, String> personRoleDelete(@PathVariable Integer personId, @RequestBody RoleDTO roleToDeleteDTO) {
        return Collections.singletonMap("result", personService.personRoleDelete(personId, roleToDeleteDTO.getRoleName()));
    }

}