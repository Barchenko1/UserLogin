package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);

    void updateRole(User user);

    void deleteRole(User user);

    List<User> findAllUser();

    Optional<User> findUserById(Long id);
}
