package com.ira.springexercise.services;

import com.ira.springexercise.models.Role;
import com.ira.springexercise.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoleService {

    final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public String roleAdd(String newRoleName) {
        if (roleRepository.existsByRoleNameEqualsIgnoreCase(newRoleName)) return "Role Already Exists";
        Role newRole = new Role(newRoleName);
        roleRepository.save(newRole);
        return String.format("Saved: [%d] %s", newRole.getId(), newRole.getRoleName());
    }

    public String roleUpdate(Integer id, String newRoleName) {
        try {
            Role toBeUpdatedRole = roleRepository.findById(id).orElseThrow();
            String oldRoleName = toBeUpdatedRole.getRoleName();
            toBeUpdatedRole.setRoleName(newRoleName);
            roleRepository.save(toBeUpdatedRole);
            return String.format("Updated: [%d] %s -> %s", id, oldRoleName, toBeUpdatedRole.getRoleName());
        } catch (NoSuchElementException exception) {
            return "ID Not Found";
        }
    }

    public String roleDelete(Integer id) {
        try {
            Role toBeDeletedRole = roleRepository.findById(id).orElseThrow();
            roleRepository.deleteById(id);
            return String.format("Deleted: [%d] %s", id, toBeDeletedRole.getRoleName());
        } catch (NoSuchElementException exception) {
            return "ID Not Found";
        }
    }

    public List<Role> roleList() {
        List<Role> allRoles = new ArrayList<>();
        roleRepository.findAll().forEach(allRoles::add);
        return allRoles;
    }
}