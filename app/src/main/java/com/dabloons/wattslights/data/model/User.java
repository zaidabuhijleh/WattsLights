package com.dabloons.wattslights.data.model;

import java.util.UUID;

public class User {
    private String email;
    private String password;
    private String UUID;

    public User(String email, String password, String uid) {
        this.email = email;
        this.password = password;
        this.UUID = uid;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}