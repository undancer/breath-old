package com.github.undancer.breath.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: undancer
 * Date: 13-10-26
 * Time: 下午4:16
 * To change this template use File | Settings | File Templates.
 */
@Named
public class BeanUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtils.applicationContext = applicationContext;
    }
}
