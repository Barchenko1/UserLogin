package com.example.demo.rest;

import com.example.demo.dto.UserRoleDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
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

    @RequestMapping(value = "/delete/{login}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("login") String login) {
        userService.deleteUserByLogin(login);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<UserRoleDto> findAllUser() {
        return userService.findAllUser();
    }

}
