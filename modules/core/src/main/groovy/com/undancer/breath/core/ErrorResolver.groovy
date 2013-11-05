package com.undancer.breath.core

import groovy.util.logging.Slf4j
import org.springframework.validation.BindException
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView

import javax.inject.Named
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created with IntelliJ IDEA.
 * User: undancer
 * Date: 13-10-28
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
@Named
@Slf4j
class ErrorResolver implements HandlerExceptionResolver {

    ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        //TODO:
        if (e instanceof BindException) {
            e as BindException
            e.fieldErrors.each { fe ->
                Object[] args = fe.arguments
                String key = fe.bindingFailure ? fe.codes[2].replaceFirst(/typeMismatch/, 'conversion') : "validation.${fe.codes[2]}"
            }

            e.globalErrors.each { ge ->

            }
        }
        return null
    }
}
