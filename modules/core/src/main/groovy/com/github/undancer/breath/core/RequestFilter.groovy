package com.github.undancer.breath.core

import groovy.util.logging.Slf4j
import org.springframework.core.NamedThreadLocal
import org.springframework.web.filter.OncePerRequestFilter

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created with IntelliJ IDEA.
 * User: undancer
 * Date: 13-10-28
 * Time: 下午1:46
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
class RequestFilter extends OncePerRequestFilter {

    private static final ThreadLocal<HttpServletRequest> requestHolder = new NamedThreadLocal<HttpServletRequest>('request')

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        requestHolder.set(request)

        filterChain.doFilter(request, response)

        requestHolder.set(null)
    }

    static HttpServletRequest getRequest() {
        requestHolder.get()
    }
}
