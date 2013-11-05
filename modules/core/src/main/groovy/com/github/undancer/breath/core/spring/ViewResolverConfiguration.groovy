package com.github.undancer.breath.core.spring

import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver

/**
 * Created with IntelliJ IDEA.
 * User: undancer
 * Date: 13-10-28
 * Time: 下午1:39
 * To change this template use File | Settings | File Templates.
 */
class ViewResolverConfiguration extends ContentNegotiatingViewResolver {

    List<ViewResolver> viewResolvers

    void setViewResolvers(List<ViewResolver> viewResolvers) {
        this.viewResolvers = viewResolvers
        super.setViewResolvers(viewResolvers)
    }

}
