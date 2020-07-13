package com.example.demo.dto;

import com.example.demo.model.RoleName;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserRoleDto {

    private String login;

    private String password;

    private String f_name;

    private String l_name;

    private int age;

    private String email;

    private String phone;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private RoleName role_name;

    public UserRoleDto() {
    }

    public UserRoleDto(String login, String password, String f_name, String l_name, int age, String email, String phone, Date birthday, RoleName role_name) {
        this.login = login;
        this.password = password;
        this.f_name = f_name;
        this.l_name = l_name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.role_name = role_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public RoleName getRole_name() {
        return role_name;
    }

    public void setRole_name(RoleName role_name) {
        this.role_name = role_name;
    }
}
