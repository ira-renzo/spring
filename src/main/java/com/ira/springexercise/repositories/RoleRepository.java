package com.ira.springexercise.repositories;

import com.ira.springexercise.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    boolean existsByRoleNameEqualsIgnoreCase(String roleName);

    Role findByRoleNameEqualsIgnoreCase(String roleName);

}