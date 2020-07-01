package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.model.User;
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

    @Override
    public void createUser(User user) {
        userDao.save(user);
    }

    @Override
    public void updateRole(User user) {
        Optional<User> newUser = userDao.findById(user.getIdUser());
        userDao.saveAndFlush(newUser.get());
    }

    @Override
    public void deleteRole(User user) {
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
