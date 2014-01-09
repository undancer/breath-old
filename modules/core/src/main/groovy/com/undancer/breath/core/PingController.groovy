package com.undancer.breath.core

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by undancer on 14-1-1.
 */
@Controller
@RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE)
class PingController {

    @RequestMapping('/ping')
    def ping() {
        return new ResponseEntity('pong', HttpStatus.OK)
    }
}
