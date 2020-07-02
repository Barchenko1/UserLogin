package com.example.demo.rest;

import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleRest {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createRole(@RequestBody Role role) {
        roleService.createRole(role);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Role> createRole() {
        return roleService.findAllRole();
    }
}
