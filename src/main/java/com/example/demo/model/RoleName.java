package com.example.demo.model;

public enum RoleName {
    ADMIN, USER;

    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
