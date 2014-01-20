package com.undancer.breath.core.filter

import com.undancer.breath.core.util.RequestUtils
import groovy.transform.PackageScope
import groovy.util.logging.Slf4j
import org.springframework.web.filter.OncePerRequestFilter

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by undancer on 14-1-20.
 */
@Slf4j
class JsonpRequestFilter extends OncePerRequestFilter {

    @PackageScope
    void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        def callback = RequestUtils.getParameter('callback')

        if (callback && !callback.empty) {
            if (log.debugEnabled) {
                log.debug("Wrapping response with JSONP callback '{}'", callback)
            }
            OutputStream out = response.outputStream

            def wrapper = [response] as GenericResponseWrapper

            filterChain.doFilter(request, wrapper)

            ByteArrayOutputStream outputStream = [] as ByteArrayOutputStream
            outputStream.write("${callback}(".bytes)
            outputStream.write(wrapper.data)
            outputStream.write(");".bytes)
            byte[] jsonpResponse = outputStream.toByteArray()

            wrapper.contentType = 'application/json;charset=UTF-8'
            wrapper.contentLength = jsonpResponse.length

            out.write(jsonpResponse)
            out.close()
        } else {
            filterChain.doFilter(request, response)
        }
    }
}
