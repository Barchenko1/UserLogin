package com.example.demo.service.impl;

import com.example.demo.builders.BaseBuilder;
import com.example.demo.dto.UserRoleDto;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.reposetory.RoleDao;
import com.example.demo.reposetory.UserDao;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BaseBuilder<User, UserRoleDto, Role> userBuilder;

    @Override
    public void createUser(UserRoleDto userRoleDto) {
        Optional<Role> role = roleDao.findByRoleName(userRoleDto.getRoleName().name());
        User user = userBuilder.build(userRoleDto, role.get());
        userDao.save(user);
    }

    @Override
    public void updateUser(User user) {
        Optional<User> newUser = userDao.findById(user.getIdUser());
        userDao.saveAndFlush(newUser.get());
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userDao.findById(id);
    }
}
