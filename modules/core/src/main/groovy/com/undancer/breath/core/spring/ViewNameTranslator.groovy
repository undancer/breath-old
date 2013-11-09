package com.undancer.breath.core.spring

import com.undancer.breath.core.ViewNotFoundException
import com.undancer.breath.core.util.BeanUtils
import com.undancer.breath.core.util.ResourceUtils
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator

import javax.inject.Named
import javax.servlet.http.HttpServletRequest

import static com.undancer.breath.core.util.RequestUtils.contextRelative
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

    private final static String INDEX = "/index"
    String[] prefixes = ['/', 'WEB-INF/pages', 'META-INF/pages']

    String findViewName(String path, boolean greedy) {

        [path, path + INDEX].each { name ->
            prefixes.each { prefix ->
                URL uri = ResourceUtils.getClassPathResource(prefix.replaceAll(/^\//, '') + name)
                println "findViewName -> $uri"
                if (uri) {
                    return uri
                }
            }
        }

        if (greedy && path.lastIndexOf('/') != -1) {
            return findViewName(path.substring(0, path.lastIndexOf('/')), greedy)
        }

        return null
    }

    String getViewName(HttpServletRequest request) {
        //TODO:

        String uri = stripFilenameExtension(contextRelative(request.requestURI.replaceAll(/\/+/, '/'), false)).replaceFirst(/\/$/, '')

        println "uri - $uri"
        BeanUtils.getBeanOfType(ViewResolverConfiguration)

        println("request : $request")

        String viewName = findViewName(uri, false)

        if (viewName) {
            return viewName
        }

        throw new ViewNotFoundException()
    }
}
