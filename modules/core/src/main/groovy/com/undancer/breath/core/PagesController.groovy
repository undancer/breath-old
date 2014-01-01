package com.undancer.breath.core

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created with IntelliJ IDEA.
 * User: undancer
 * Date: 13-10-28
 * Time: 上午11:12
 * To change this template use File | Settings | File Templates.
 */
@Controller
class PagesController {

    @RequestMapping('/**/*')
    void pages() {
        println "pages"
    }
}
