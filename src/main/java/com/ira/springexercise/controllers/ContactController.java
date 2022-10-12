package com.ira.springexercise.controllers;

import com.ira.springexercise.Mapper;
import com.ira.springexercise.dto.ContactDTO;
import com.ira.springexercise.models.contact.ContactAbstract;
import com.ira.springexercise.services.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/contact")
public class ContactController {

    final ContactService contactService;
    final Mapper mapper;

    public ContactController(ContactService contactService, Mapper mapper) {
        this.contactService = contactService;
        this.mapper = mapper;
    }

    @PutMapping(value = "/add/{personId}")
    public Map<String, String> contactAdd(@PathVariable Integer personId, @RequestBody ContactDTO contactDTO) {
        ContactAbstract newContact = mapper.toContact(contactDTO);
        if (newContact == null) return Collections.singletonMap("result", "Wrong Type");
        return Collections.singletonMap("result", contactService.contactAdd(personId, newContact));
    }

    @PutMapping(value = "/update/{personId}/{contactId}")
    public Map<String, String> contactUpdate(@PathVariable Integer personId,
                                             @PathVariable Integer contactId,
                                             @RequestBody ContactDTO contactDTO) {
        ContactAbstract newContact = mapper.toContact(contactDTO);
        if (newContact == null) return Collections.singletonMap("result", "Wrong Type");
        return Collections.singletonMap("result", contactService.contactUpdate(personId, contactId, newContact));
    }

    @DeleteMapping(value = "/delete/{personId}/{contactId}")
    public Map<String, String> contactDelete(@PathVariable Integer personId,
                                             @PathVariable Integer contactId) {
        return Collections.singletonMap("result", contactService.contactDelete(personId, contactId));
    }

}