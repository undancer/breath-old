package com.undancer.breath.samples;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Component;

/**
 * Created by undancer on 14-1-3.
 */
@Component
public class AuthService {

    @RequiresUser
    public void token() {

    }
}
