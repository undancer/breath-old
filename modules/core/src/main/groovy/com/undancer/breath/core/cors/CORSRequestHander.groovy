package com.undancer.breath.core.cors

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by undancer on 14-1-17.
 */
class CORSRequestHander {

    public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin"

    static void handle(final HttpServletRequest request, final HttpServletResponse response) {
        response.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, '*')
    }

}
