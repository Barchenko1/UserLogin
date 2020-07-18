package com.example.demo.controller;

import com.example.demo.dto.UserLoginDto;
import com.example.demo.dto.UserRoleDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import static com.example.demo.constants.Constant.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    protected ModelAndView adminPageGet() {
        ModelAndView modelAndView = new ModelAndView();
        List<UserRoleDto> userRoleDto = userService.findAllUser();
        modelAndView.addObject("userRoleDto", userRoleDto);
        modelAndView.setViewName(ADMIN_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    protected ModelAndView userPageGet(@ModelAttribute("userLoginDto") UserLoginDto userLoginDto) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> user = userService.findUserByLogin(userLoginDto.getLogin());
        modelAndView.addObject("user", user.get());
        modelAndView.setViewName(USER_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    protected ModelAndView createUserPageGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(CREATE_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    protected ModelAndView createUserPagePost(@ModelAttribute("userRoleDto") UserRoleDto userRoleDto) {
        userService.createUser(userRoleDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{login}", method = RequestMethod.GET)
    protected ModelAndView updateUserPageGet(@PathVariable("login") String login) {
        Optional<UserRoleDto> userRoleDto = userService.findUserRoleDtoByLogin(login);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userRoleDto", userRoleDto.get());
        modelAndView.setViewName(UPDATE_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    protected ModelAndView updateUserPagePost(@ModelAttribute("userRoleDto") UserRoleDto userRoleDto) {
        userService.updateUser(userRoleDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{login}", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@PathVariable("login") String login) {
        userService.deleteUserByLogin(login);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

}
