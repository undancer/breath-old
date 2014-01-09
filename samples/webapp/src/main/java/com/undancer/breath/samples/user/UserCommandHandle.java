package com.undancer.breath.samples.user;

import com.undancer.breath.samples.user.commands.CreateUser;
import com.undancer.breath.samples.user.commands.Login;
import com.undancer.breath.samples.user.entity.User;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.repository.Repository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by undancer on 14-1-6.
 */
@Component
public class UserCommandHandle {

    @Resource
    Repository<User> userRepository;

    EventBus eventBus;

    @CommandHandler
    public void handle(CreateUser user) {
        System.out.println(Thread.currentThread());
        userRepository.add(new User(user.getUsername()));
    }

    @CommandHandler
    public void handle(Login login) {
        User user = userRepository.load(login.getUsername());
        System.out.println(user);
    }
}
