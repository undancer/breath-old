package com.undancer.breath.core.spring

import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter

/**
 * Created by undancer on 13-12-27.
 */
class HttpMessageConverterBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        def messageConverters = beanFactory.getBeansOfType(HttpMessageConverter).values()
        beanFactory.getBeansOfType(RequestMappingHandlerAdapter)?.each { _, adapter ->
            if (adapter.messageConverters) {
                messageConverters.each { messageConverter ->
                    adapter.messageConverters << messageConverter
                }
            }
        }
    }

}
