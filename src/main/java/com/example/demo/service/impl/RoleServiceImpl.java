package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.reposetory.RoleDao;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void createRole(Role role) {
        roleDao.save(role);
    }

    @Override
    public void updateRole(Role role) {
        Optional<Role> newRole = roleDao.findById(role.getIdRole());
        roleDao.saveAndFlush(newRole.get());
    }

    @Override
    public void deleteRole(Role role) {
        roleDao.delete(role);
    }

    @Override
    public List<Role> findAllRole() {
        return roleDao.findAll();
    }

    @Override
    public Optional<Role> findRoleById(Long id) {
        return roleDao.findById(id);
    }
}
