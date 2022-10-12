package com.ira.springexercise.repositories;

import com.ira.springexercise.models.contact.ContactAbstract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<ContactAbstract, Integer> {
}