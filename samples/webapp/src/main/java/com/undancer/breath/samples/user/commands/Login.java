package com.undancer.breath.samples.user.commands;

/**
 * Created by undancer on 14-1-6.
 */
public class Login {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
