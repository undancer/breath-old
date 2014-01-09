package com.undancer.breath.core.resource

import groovy.util.logging.Slf4j
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.core.Ordered

/**
 * Created by undancer on 14-1-4.
 */
@Slf4j
class MessageResource extends LocationResource {

    ReloadableResourceBundleMessageSource messageSource

    public MessageResource() {
        setOrder(Ordered.HIGHEST_PRECEDENCE)
        messageSource = [] as ReloadableResourceBundleMessageSource
    }

    String getMessage(String code, Object[] args, Locale locale) {
        messageSource.getMessage(code, args, locale)
    }

    void setLocations(String[] locations) {
        super.setLocations(locations)
        messageSource.clearCache()
        messageSource.basenames = locations
    }

    void setWildcardLocations(String[] locations) {

    }
}