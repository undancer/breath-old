package com.undancer.breath.core.spring

import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator

import javax.inject.Named
import javax.servlet.http.HttpServletRequest

/**
 * Created by undancer on 13-12-30.
 */
@Named('viewNameTranslator')
class ViewNameTranslator extends DefaultRequestToViewNameTranslator {

    String getViewName(HttpServletRequest request) {
        //TODO:
        return super.getViewName(request)
    }

}
