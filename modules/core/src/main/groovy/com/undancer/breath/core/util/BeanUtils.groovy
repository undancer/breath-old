package com.undancer.breath.core.util

import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory

import javax.inject.Named
import java.lang.annotation.Annotation

/**
 * Created with IntelliJ IDEA.
 * User: undancer
 * Date: 13-10-26
 * Time: 下午4:16
 * To change this template use File | Settings | File Templates.
 */
@Named
class BeanUtils implements BeanFactoryPostProcessor {

    private static ConfigurableListableBeanFactory beanFactory

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        BeanUtils.beanFactory = beanFactory
    }

    static <T> T getBeanOfType(Class<T> type) {
        getBeanOfType(beanFactory, type)
    }

    static <T> T getBeanOfType(ConfigurableListableBeanFactory beanFactory, Class<T> type) {
        Map<String, T> beans = beanFactory.getBeansOfType(type)
        def values = beans.values()
        values.size() != 0 ? values.sort().first() : null
    }

    static <T> Map<String, T> getBeansOfType(Class<T> type) {
        return beanFactory.getBeansOfType(type)
    }

    static String[] getBeanNamesForType(Class<?> type) {
        beanFactory.getBeanNamesForType(type)
    }

    static Object getBean(String name) {
        beanFactory.getBean(name)
    }

    static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) {
        beanFactory.getBeansWithAnnotation(annotationType)
    }

}
