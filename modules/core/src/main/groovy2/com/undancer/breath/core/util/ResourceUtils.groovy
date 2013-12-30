package com.undancer.breath.core.util

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
        if (!list.isEmpty()) {
            return list.first()
        }
        return null
    }

    static List<URL> getClassPathResources(String name) {
        getClassPathResources(name, true)
    }

    static List<URL> getClassPathResources(String name, boolean isJar) {

        List<URL> list = []
        try {
            Enumeration<URL> resources = RequestUtils.class.classLoader.getResources(name)
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement()
                if (isJar || isJar == org.springframework.util.ResourceUtils.isJarURL(resource)) {
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
