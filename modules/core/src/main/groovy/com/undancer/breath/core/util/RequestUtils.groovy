package com.undancer.breath.core.util

import com.undancer.breath.core.RequestFilter
import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware

import javax.inject.Named
import javax.servlet.http.HttpServletRequest

/**
 * Created with IntelliJ IDEA.
 * User: undancer
 * Date: 13-10-28
 * Time: 下午1:44
 * To change this template use File | Settings | File Templates.
 */
@Named
class RequestUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext

    static HttpServletRequest getRequest() {
        RequestFilter.request
    }

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RequestUtils.applicationContext = applicationContext
    }

    static String contextRelative(String uri, boolean contextRelative) {
        if (uri && uri.startsWith('/')) {
            String contextPath = request.contextPath
            uri = uri.replaceFirst(/^$contextPath\/?/, '/')
            if (contextRelative) {
                uri = contextPath.concat(uri)
            }
        }
        uri
    }

    static String getHeader(String name) {
        request.getHeader(name)
    }

    static String getUserAgent() {
        getHeader('User-Agent')
    }

    static boolean isAjaxRequest() {
        'XMLHttpRequest'.equalsIgnoreCase(request.getHeader('x-requested-with'))
    }

    static boolean isGetRequest() {
        'GET'.equalsIgnoreCase(request.method)
    }

    static boolean isPostRequest() {
        'POST'.equalsIgnoreCase(request.method)
    }

}
