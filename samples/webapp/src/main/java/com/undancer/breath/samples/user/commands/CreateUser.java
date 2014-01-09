package com.undancer.breath.samples.user.commands;

/**
 * Created by undancer on 14-1-6.
 */
public class CreateUser {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CreateUser(String username) {
        this.username = username;
    }
}
