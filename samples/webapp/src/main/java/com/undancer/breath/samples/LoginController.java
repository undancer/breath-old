package com.undancer.breath.samples;

import com.undancer.breath.samples.user.commands.CreateUser;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

/**
 * Created by undancer on 14-1-6.
 */
@Controller
public class LoginController {

    @Inject
    CommandGateway gateway;

    @RequestMapping("/l/login")
    public void login(String username, String password) {
        System.out.println(Thread.currentThread());
        gateway.send(new CreateUser(username));
//        gateway.send(new Login(username, password));
    }
}
