package com.ira.springexercise;

import com.ira.springexercise.models.Role;
import com.ira.springexercise.repositories.RoleRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DefaultRolesLoader implements ApplicationRunner {

    final RoleRepository roleRepository;

    public DefaultRolesLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        List<Role> defaultRoles = Stream.of("admin", "dev", "qa", "ba")
                .map(Role::new)
                .collect(Collectors.toList());
        roleRepository.saveAll(defaultRoles);
    }

}