package com.github.undancer.breath.core.spring

import com.github.undancer.breath.core.util.BeanUtils
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator

import javax.inject.Named
import javax.servlet.http.HttpServletRequest

import static com.github.undancer.breath.core.util.RequestUtils.contextRelative
import static org.springframework.util.StringUtils.stripFilenameExtension

/**
 * Created with IntelliJ IDEA.
 * User: undancer
 * Date: 13-10-26
 * Time: 下午12:23
 * To change this template use File | Settings | File Templates.
 */
@Named('viewNameTranslator')
public class ViewNameTranslator extends DefaultRequestToViewNameTranslator {

    String getViewName(HttpServletRequest request) {
        //TODO:

        String uri = stripFilenameExtension(contextRelative(request.requestURI.replaceAll(/\/+/, '/'), false)).replaceFirst(/\/$/, '')

        println "uri - $uri"
        BeanUtils.getBeanOfType(ViewResolverConfiguration)
        println("request : $request")
        return super.getViewName(request)
    }
}
