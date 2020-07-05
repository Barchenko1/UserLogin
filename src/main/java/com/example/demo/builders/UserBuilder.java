package com.example.demo.builders;

import com.example.demo.dto.UserRoleDto;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserBuilder implements BaseBuilder<User, UserRoleDto, Role>{

    @Override
    public User build(UserRoleDto userRoleDto, Role role) {
        User user = new User();
        user.setLogin(userRoleDto.getLogin());
        user.setPassword(userRoleDto.getPassword());
        user.setF_name(userRoleDto.getF_name());
        user.setL_name(userRoleDto.getL_name());
        user.setAge(userRoleDto.getAge());
        user.setEmail(userRoleDto.getEmail());
        user.setPhone(userRoleDto.getPhone());
        user.setBirthday(userRoleDto.getBirthday());
        user.setIdRole(role);

        return user;
    }

}
