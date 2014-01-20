package com.undancer.breath.core

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by undancer on 14-1-1.
 */
@RestController
@RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE)
class PingController {

    @RequestMapping('/ping')
    def ping() {
        'pong'
    }
}
