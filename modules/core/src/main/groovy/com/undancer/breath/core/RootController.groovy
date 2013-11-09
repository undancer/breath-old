package com.undancer.breath.core

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by undancer on 13-11-9.
 */
@Controller
class RootController {
    @RequestMapping('/')
    void root() {}
}
