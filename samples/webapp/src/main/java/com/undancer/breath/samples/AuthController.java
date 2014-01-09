package com.undancer.breath.samples;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by undancer on 14-1-3.
 */
@Controller
@RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE)
public class AuthController {

    @Inject
    AuthService authService;

    @RequestMapping("/oauth/token")
    @ResponseBody
    public String token() {

        authService.token();
        return "token";
    }
}
