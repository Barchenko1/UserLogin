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

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    EntityManagerFactory emf;

    @Autowired
    private BaseBuilder<User, UserRoleDto, Role> userBuilder;

    @Override
    public void createUser(UserRoleDto userRoleDto) {
        Optional<Role> role = roleDao.findByRoleName(userRoleDto.getRole_name().name());
        User user = userBuilder.build(userRoleDto, role.get());
        userDao.save(user);
    }

    @Override
    public void updateUser(UserRoleDto userRoleDto) {
        Optional<Role> role = roleDao.findByRoleName(userRoleDto.getRole_name().name());
        Optional<User> user = userDao.findUserByLogin(userRoleDto.getLogin());
        User updateUser = userBuilder.build(userRoleDto, role.get());
        updateUser.setIdUser(user.get().getIdUser());
        updateUser.setLogin(user.get().getLogin());
        userDao.saveAndFlush(updateUser);
    }

    @Override
    public void deleteUser(UserRoleDto userRoleDto) {
        Optional<User> user = userDao.findUserByLogin(userRoleDto.getLogin());
        userDao.delete(user.get());
    }

    @Override
    public List<UserRoleDto> findAllUser() {
        List<UserRoleDto> userRoleDtoList = userDao.findAllUserRoleDto();
        return userRoleDtoList;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userDao.findById(id);
    }
}
