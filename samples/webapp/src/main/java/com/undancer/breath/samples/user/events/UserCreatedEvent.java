package com.undancer.breath.samples.user.events;

/**
 * Created by undancer on 14-1-6.
 */
public class UserCreatedEvent {

    private String username;

    public UserCreatedEvent(String username) {
        this.username = username;
    }
}
