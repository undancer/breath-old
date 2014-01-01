package com.undancer.breath.core.util

import static org.springframework.util.ResourceUtils.isJarURL

/**
 * Created by undancer on 13-11-9.
 */
class ResourceUtils {

    private static final String PREFIX = "/breath-"

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
            o1.path.indexOf(PREFIX)<=>o2.path.indexOf(PREFIX)
        }

        list
    }
}
