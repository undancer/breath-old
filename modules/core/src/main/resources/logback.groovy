//
// Built on Wed Sep 25 04:53:42 CEST 2013 by logback-translator
// For more information on configuration files in Groovy
// please see http://logback.qos.ch/manual/groovy.html

// For assistance related to this tool or configuration files
// in general, please contact the logback user mailing list at
//    http://qos.ch/mailman/listinfo/logback-user

// For professional support please see
//   http://www.qos.ch/shop/products/professionalSupport

import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender

import static ch.qos.logback.classic.Level.*

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    }
}
logger("org.apache.commons.digester", INFO)
logger("org.apache.http", INFO)
logger("org.springframework.aop", INFO)
logger("org.springframework.core", INFO)
logger("org.springframework.beans", INFO)
logger("org.springframework.context", INFO)
logger("org.springframework.data", INFO)
logger("org.springframework.jndi", INFO)
logger("org.springframework.ui", INFO)
logger("org.springframework.web", INFO)
logger("org.springframework.cache", DEBUG)
logger("org.springframework.data", DEBUG)
//logger("org.hibernate.tool.hbm2ddl", OFF)
//logger("org.hibernate.ejb", INFO)
//logger("org.hibernate.cfg", INFO)
//logger("org.hibernate.type", INFO)
//logger("org.hibernate.id", INFO)
//logger("org.hibernate.internal", INFO)
//logger("org.hibernate.loader", INFO)
logger("druid", DEBUG)
logger("com.mongodb", DEBUG)
logger("net.sf.ehcache", TRACE)
logger("com.boxfishedu", DEBUG)
root(DEBUG, ["STDOUT"])
//root(TRACE, ["STDOUT"])