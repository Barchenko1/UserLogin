package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.reposetory.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl {

    @Autowired
    private RoleDao roleDao;

    void createRole(Role role) {
        roleDao.save(role);
    }
}
