package com.undancer.breath.core.resource

import groovy.util.logging.Slf4j
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory

import javax.inject.Named

/**
 * Created by undancer on 14-1-4.
 */
@Slf4j
@Named
class ResourceOrderProcessor implements BeanFactoryPostProcessor {

    Map<Object, Integer> resources

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        println "ResourceOrderProcessor - postProcessBeanFactory"

        AbstractResource resource = null
        int count = 0
        resources.each { key, order ->
            println "key - $key | order - $order | count - $count"
            if (key instanceof AbstractResource) {
                resource = key as AbstractResource
            } else if (key instanceof String) {
                resource = beanFactory.getBean(key as String, AbstractResource)
            }
            resource.order = order ?: count
            count++
        }
    }
}
