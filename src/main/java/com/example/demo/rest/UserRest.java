package com.example.demo.rest;

import com.example.demo.dto.UserRoleDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRest {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createUser(@RequestBody UserRoleDto userRoleDto) {
        userService.createUser(userRoleDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserRoleDto userRoleDto) {
        userService.updateUser(userRoleDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody UserRoleDto userRoleDto) {
        userService.deleteUser(userRoleDto);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<UserRoleDto> findAllUser() {
        return userService.findAllUser();
    }

}
