package com.undancer.breath.samples.user.entity;

import com.undancer.breath.samples.user.events.UserCreatedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

/**
 * Created by undancer on 14-1-6.
 */
public class User extends AbstractAnnotatedAggregateRoot<String> {

    @AggregateIdentifier
    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
        apply(new UserCreatedEvent(this.username));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @EventHandler
    public void on(UserCreatedEvent event) {
        System.out.println(Thread.currentThread());
        System.out.println("create - " + event);
    }

}
