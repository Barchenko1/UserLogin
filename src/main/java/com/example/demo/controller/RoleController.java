package com.example.demo.controller;

import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;


}
