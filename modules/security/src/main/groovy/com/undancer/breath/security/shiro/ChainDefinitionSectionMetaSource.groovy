package com.undancer.breath.security.shiro

import org.apache.shiro.config.Ini
import org.apache.shiro.util.CollectionUtils
import org.apache.shiro.web.config.IniFilterChainResolverFactory
import org.springframework.beans.factory.config.AbstractFactoryBean

/**
 * Created by undancer on 14-1-4.
 */
class ChainDefinitionSectionMetaSource extends AbstractFactoryBean<Ini.Section> {

    String resourcePath

//    String

    Class<?> getObjectType() {
        this.class
    }

    protected Ini.Section createInstance() throws Exception {
        def ini = [] as Ini
        ini.loadFromPath(resourcePath)
        //did they explicitly state a 'urls' section?  Not necessary, but just in case:
        def section = ini.getSection(IniFilterChainResolverFactory.URLS)
        if (CollectionUtils.isEmpty(section as Ini.Section)) {
            //no urls section.  Since this _is_ a urls chain definition property, just assume the
            //default section contains only the definitions:
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME)
        }
        println "section - $section"
        return section
    }
}
