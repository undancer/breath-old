package com.undancer.breath.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.config.AbstractFactoryBean

/**
 * Created by undancer on 13-12-27.
 */
class ObjectMapperFactoryBean extends AbstractFactoryBean<ObjectMapper> {

    Class<?> getObjectType() {
        ObjectMapper
    }

    protected ObjectMapper createInstance() throws Exception {
        def objectMapper = [] as ObjectMapper
//        objectMapper.registerModule()
        objectMapper
    }
}
