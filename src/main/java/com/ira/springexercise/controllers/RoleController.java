package com.ira.springexercise.controllers;

import com.ira.springexercise.dto.RoleDTO;
import com.ira.springexercise.models.Role;
import com.ira.springexercise.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping(value = "/add")
    public Map<String, String> roleAdd(@RequestBody RoleDTO roleDTO) {
        return Collections.singletonMap("result", roleService.roleAdd(roleDTO.getRoleName()));
    }

    @PutMapping("/update/{personId}")
    public Map<String, String> roleUpdate(@PathVariable Integer personId, @RequestBody RoleDTO roleDTO) {
        return Collections.singletonMap("result", roleService.roleUpdate(personId, roleDTO.getRoleName()));
    }

    @DeleteMapping("/delete/{personId}")
    public Map<String, String> roleDelete(@PathVariable Integer personId) {
        return Collections.singletonMap("result", roleService.roleDelete(personId));
    }

    @GetMapping("/list")
    public List<Role> roleList() {
        return roleService.roleList();
    }

}