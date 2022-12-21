package com.ira.springexercise.repositories;

import com.ira.springexercise.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    boolean existsByName_LastNameAndName_FirstName(String name_lastName, String name_firstName);

}