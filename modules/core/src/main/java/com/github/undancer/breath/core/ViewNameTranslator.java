package com.github.undancer.breath.core;

import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: undancer
 * Date: 13-10-26
 * Time: 下午12:23
 * To change this template use File | Settings | File Templates.
 */
@Named
public class ViewNameTranslator extends DefaultRequestToViewNameTranslator {

    public String getViewName(HttpServletRequest request) {
        //TODO:
        return null;
    }
}
