package com.example.demo.controller;

import com.example.demo.dto.UserRoleDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.example.demo.constants.Constant.ADMIN_PAGE;
import static com.example.demo.constants.Constant.USER_PAGE;

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


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    protected ModelAndView userPageGet() {
        ModelAndView modelAndView = new ModelAndView();
        List<UserRoleDto> userRoleDto = userService.findAllUser();
        modelAndView.addObject("userRoleDto", userRoleDto);
        modelAndView.setViewName(USER_PAGE);
        return modelAndView;
    }
}
