package com.undancer.breath.core.util

import com.undancer.breath.core.resource.MessageResource
import org.springframework.context.NoSuchMessageException
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.core.OrderComparator

import static org.springframework.util.ResourceUtils.isJarURL

/**
 * Created by undancer on 13-11-9.
 */
class ResourceUtils {

    private static List<MessageResource> messages = null

    private static final String PREFIX = "/breath-"

    static String getMessage(String key) {
        getMessage(key, [] as Object[], LocaleContextHolder.locale)
    }

    static String getMessage(String key, Locale locale) {
        getMessage(key, [] as Object[], locale)
    }

    static String getMessage(String key, Object[] args) {
        getMessage(key, args, LocaleContextHolder.locale)
    }

    static String getMessage(String key, Object[] args, Locale locale) {
        if (messages == null) {
            messages = getResources(MessageResource)
        }

        if (messages) {
            return messages.findResult { bean ->
                try {
                    String message = bean.getMessage(key, args, locale)
                    if (message) {
                        return message
                    }
                } catch (NoSuchMessageException e) {
                }
            }
        }
    }

    static URL getClassPathResource(String name) {
        getClassPathResource(name, true)
    }

    static URL getClassPathResource(String name, boolean isJar) {
        List<URL> list = getClassPathResources(name, isJar)
        return !list.empty ? list.first() : null
    }

    static List<URL> getClassPathResources(String name) {
        getClassPathResources(name, true)
    }

    static List<URL> getClassPathResources(String name, boolean isJar) {

        List<URL> list = []
        try {
            Enumeration<URL> resources = RequestUtils.classLoader.getResources(name)

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement()
                if (isJar || isJar == isJarURL(resource)) {
                    list << resource
                }
            }
        } catch (Exception e) {

        }

        list.sort { o1, o2 ->
            o1.path.indexOf(PREFIX) <=> o2.path.indexOf(PREFIX)
        }

        list
    }

    static <T> List<T> getResources(Class<T> clazz) {
        List<T> resources = null
        String[] names = BeanUtils.getBeanNamesForType(clazz)
        if (names) {
            resources = [] as ArrayList<T>
            names.each { name ->
                T bean = BeanUtils.getBean(name) as T
                if (!bean in resources) {
                    resources << bean
                }
            }
            OrderComparator.sort(resources)
        }
        resources
    }
}
