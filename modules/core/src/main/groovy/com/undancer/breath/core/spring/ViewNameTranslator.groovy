package com.undancer.breath.core.spring

import groovy.util.logging.Slf4j
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator

import javax.inject.Named
import javax.servlet.http.HttpServletRequest

import static com.undancer.breath.core.util.RequestUtils.contextRelative
import static com.undancer.breath.core.util.ResourceUtils.getClassPathResource
import static org.springframework.util.StringUtils.stripFilenameExtension

/**
 * Created by undancer on 13-12-30.
 */
@Slf4j
@Named('viewNameTranslator')
class ViewNameTranslator extends DefaultRequestToViewNameTranslator {

    private final static String INDEX = '/index'
    String[] prefixes = ['/', 'WEB-INF/pages', 'META-INF/pages']

    /**
     *
     * @param path
     * @param greedy
     * @return
     */
    String findViewName(String path, boolean greedy) {

        for (name in [path, path + INDEX]) {
            for (prefix in prefixes) {
                URL uri = getClassPathResource(prefix.replaceAll(/^\//, '') + name + '.html')
                if (uri) {
                    return prefix + name + ".html"
                }
            }
        }

        if (greedy && path.lastIndexOf('/') != -1) {
            return findViewName(path.substring(0, path.lastIndexOf('/')), greedy)
        }

        return null
    }

    /**
     *
     * @param request
     * @return
     */
    String getViewName(HttpServletRequest request) {
        //TODO:
        String uri = stripFilenameExtension(contextRelative(request.requestURI.replaceAll(/\/+/, '/'), false)).replaceFirst(/\/$/, '')

//        println "uri - $uri"
//        BeanUtils.getBeanOfType(ViewResolverConfiguration)

        String viewName = findViewName(uri, false)

        println("viewName - $viewName")

//        if (viewName) {
//            return viewName
//        }
        return super.getViewName(request)
//        throw new ViewNotFoundException()

    }

}
