package com.undancer.breath.core

import com.undancer.breath.core.util.ResourceUtils
import org.springframework.context.i18n.LocaleContextHolder

import javax.inject.Named
import javax.validation.MessageInterpolator

/**
 * Created by undancer on 14-1-4.
 */
@Named('validationMessageInterpolator')
class ValidationMessageInterpolator implements MessageInterpolator {

    String interpolate(String messageTemplate, MessageInterpolator.Context context) {
        interpolate(messageTemplate, context, LocaleContextHolder.locale)
    }

    String interpolate(String messageTemplate, MessageInterpolator.Context context, Locale locale) {
        ResourceUtils.getMessage(messageTemplate, locale)
    }
}
