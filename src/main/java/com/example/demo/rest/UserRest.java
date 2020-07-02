package com.example.demo.rest;

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
    public void createRole(@RequestBody User user) {
        userService.createUser(user);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<User> createRole() {
        return userService.findAllUser();
    }

}
