package com.undancer.breath.core.spring

import groovy.util.logging.Slf4j
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter

import javax.inject.Named
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by undancer on 14-2-25.
 */

@Slf4j
@Named('timerHandlerInterceptor')
class TimerHandlerInterceptor extends HandlerInterceptorAdapter {

    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (log.debugEnabled) {
            response.setHeader('pre', "${System.currentTimeMillis()}")
        }
        return true
    }

    void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        if (log.debugEnabled) {
            response.setHeader('post', "${System.currentTimeMillis()}")
        }
    }

//    void afterCompletion(
//            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//            throws Exception {
//        println "TimerHandlerInterceptor - afterCompletion - $request.requestURL"
//    }
//
//    void afterConcurrentHandlingStarted(
//            HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        println "TimerHandlerInterceptor - afterConcurrentHandlingStarted - $request.requestURL"
//    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis()
        def date = [time] as Date
        [time, date, date.time, (['Tue Feb 25 18:32:17 CST 2014'] as Date), (['Tue Feb 25 18:32:17 CST 2014'] as Date).time].each {
            println it
        }
//        println(['Tue Feb 25 18:32:17 CST 2014'] as Date)
    }
}
