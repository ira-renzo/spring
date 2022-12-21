package com.ira.springexercise;

import com.ira.springexercise.models.Address;
import com.ira.springexercise.models.Name;
import com.ira.springexercise.models.Person;
import com.ira.springexercise.models.Role;
import com.ira.springexercise.repositories.PersonRepository;
import com.ira.springexercise.repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Stream;

@Component
public class DBDataLoader implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(DBDataLoader.class);

    final RoleRepository roleRepository;
    final PersonRepository personRepository;

    public DBDataLoader(RoleRepository roleRepository, PersonRepository personRepository) {
        this.roleRepository = roleRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        Stream.of("admin", "dev", "qa", "ba").forEach(roleName -> saveEntity(new Role(roleName)));
        saveEntity(newPerson("Federer", "Roger"));
        saveEntity(newPerson("Nadal", "Rafael"));
        saveEntity(newPerson("Wawrinka", "Stan"));
        logger.info("Done");
    }

    private void saveEntity(Object entity) {
        try {
            if (entity instanceof Role) roleRepository.save((Role) entity);
            else if (entity instanceof Person) {
                Person person = (Person) entity;
                String lastName = person.getName().getLastName();
                String firstName = person.getName().getFirstName();
                if (!personRepository.existsByName_LastNameAndName_FirstName(lastName, firstName)) {
                    personRepository.save((Person) entity);
                }
            }
        } catch (Exception exception) {
            logger.warn(exception.getMessage());
        }
    }

    private Person newPerson(String lastName, String firstName) {
        return new Person(
                new Name(lastName, firstName),
                new Address("Street 1111", "Brgy. 888", "Unknown City", "2222"),
                new Date(),
                3.5F,
                new Date(),
                true
        );
    }

}