package com.example.demo.service;

import com.example.demo.dto.UserRoleDto;
import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(UserRoleDto userRoleDto);

    void updateUser(UserRoleDto userRoleDto);

    void deleteUser(UserRoleDto userRoleDto);

    List<UserRoleDto> findAllUser();

    Optional<User> findUserById(Long id);

}
