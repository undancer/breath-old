package com.undancer.breath.samples.user;

import com.undancer.breath.samples.user.commands.CreateUser;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.stereotype.Component;

/**
 * Created by undancer on 14-1-6.
 */
@Component
public class LoginEventLis {
    @EventHandler
    public void on(CreateUser event) {
        System.out.println(Thread.currentThread());
    }
}
