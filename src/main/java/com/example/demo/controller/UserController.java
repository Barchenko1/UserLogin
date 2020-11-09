package com.example.demo.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

import com.example.demo.dto.UserLoginDto;
import com.example.demo.dto.UserRoleDto;
import com.example.demo.model.RoleName;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import com.example.demo.utils.Fields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import static com.example.demo.constants.Constant.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

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

    @GetMapping(value = "/registration")
    public ModelAndView registrationGet() {
        return new ModelAndView("Registration");
    }

    @PostMapping("/registration")
    protected String registrartonPost(
            @Valid UserRoleDto user, BindingResult bindingResult, Model model,
            @RequestParam("passwordAgain") String passwordAgain,
            @RequestParam("g-recaptcha-response") String reqCaptcha) {

        if (!chkCaptcha(reqCaptcha)) {
            FieldError loginAlreadyUse = new FieldError("login",
                    "login", "Captcha is not success");
            bindingResult.addError(loginAlreadyUse);
        }


        if (!checkUser(user)) {
            FieldError loginAlreadyUse = new FieldError(
                    "login", "login",
                    "login is already taken");
            bindingResult.addError(loginAlreadyUse);
        }
        if (!passwordAgain.equals(user.getPassword())) {
            FieldError checkPassword = new FieldError("password",
                    "passwordAgain",
                    "Passwords are not the same");
            bindingResult.addError(checkPassword);
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("error",
                    bindingResult.getFieldError().getDefaultMessage());
            return "Registration";
        }

        try {
//            user.setIdRole(roleService.findRoleById(2L).get());
            user.setRole_name(RoleName.USER);
            userService.createUser(user);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getCause());
        }
        model.addAttribute("error",
                "Well come! Enter to your account");
        return "Login";
    }

    private boolean chkCaptcha(String responce) {

        final String url = "https://www.google.com/recaptcha/api/siteverify";
        final String secret = "6LdQXn8UAAAAAO9omoDSEllqSAc1Wv3J4cS26sXk";
        final String userAgent = "Mozilla/5.0";

        if (responce == null || "".equals(responce)) {
            return false;
        }

        try {
            URL obj = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", userAgent);
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            String postParams = "secret=" + secret + "&response="
                    + responce;
            conn.setDoOutput(true);

            OutputStream outStream = conn.getOutputStream();
            outStream.write(postParams.getBytes());

            outStream.flush();
            outStream.close();

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode=" + responseCode);

            InputStream is = conn.getInputStream();

            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();


            System.out.println("Response: " + jsonObject);

            boolean success = jsonObject.getBoolean("success");
            return success;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean checkUser(UserRoleDto user) {
        for (UserRoleDto u : userService.findAllUser()) {
            if (u.getLogin().equals(user.getLogin())) {
                return false;
            }
        }
        return true;
    }

    @RequestMapping(value = { "login", "/" }, method = RequestMethod.GET)
    protected ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Fields.LOGIN_PAGE);
        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/enter")
    public ModelAndView login(
            Principal principal, HttpSession session) {
        String login = principal.getName();
        User user = userService.findUserByLogin(login).get();
        session.setAttribute("firstName", user.getF_name());
        session.setAttribute("lastName", user.getL_name());
        if (user.getIdRole().getIdRole() == 2L) {
            return new ModelAndView("redirect:/" + Fields.USER_PAGE);
        }
        return new ModelAndView("redirect:/" + Fields.ADMIN_PAGE);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/" + Fields.LOGIN_PAGE;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error")
    public String errorPage() {
        return "redirect:/" + Fields.ERROR_PAGE;
    }
}
