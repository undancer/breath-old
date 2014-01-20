package com.undancer.breath.core.cors

import org.springframework.web.filter.OncePerRequestFilter

import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by undancer on 14-1-17.
 */
class CORSFilter extends OncePerRequestFilter {

    void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

        CORSRequestHander.handle(request, response)

        filterChain.doFilter(request, response)

    }
}
