package com.undancer.breath.core

import com.google.common.base.Stopwatch
import groovy.transform.PackageScope
import groovy.util.logging.Slf4j
import org.springframework.core.NamedThreadLocal
import org.springframework.web.filter.OncePerRequestFilter

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.util.concurrent.TimeUnit

/**
 * Created with IntelliJ IDEA.
 * User: undancer
 * Date: 13-10-28
 * Time: 下午1:46
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
class RequestFilter extends OncePerRequestFilter {

    private static final def requestHolder = ['request'] as NamedThreadLocal<HttpServletRequest>

    @PackageScope
    void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        def url, method, timer

        if (log.debugEnabled) {
            timer = Stopwatch.createStarted()
            method = request.method.toUpperCase()
            url = request.requestURL
            def query = request.queryString
            if (query) {
                url.append('?').append(query)
            }
        }

        requestHolder.set(request)

        if (request.characterEncoding == null) {
            request.characterEncoding = 'UTF-8'
        }
        if (response.characterEncoding == null) {
            response.characterEncoding = 'UTF-8'
        }

        filterChain.doFilter(request, response)

        requestHolder.set(null)

        if (log.debugEnabled) {
            if (timer) {
                if (timer.running) {
                    timer.stop()
                }
                def time = timer.elapsed(TimeUnit.MILLISECONDS)

                log.debug("[breath/core][$method] $url on $time ms.")
            }
        }

    }

    static HttpServletRequest getRequest() {
        requestHolder.get()
    }
}
