package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    void createRole(Role role);

    void updateRole(Role role);

    void deleteRole(Role role);

    List<Role> findAllRole();

    Optional<Role> findRoleById(Long id);

}
