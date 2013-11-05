//package com.github.undancer.breath.json;
//
//import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
//import org.glassfish.jersey.CommonProperties;
//
//import javax.ws.rs.core.Feature;
//import javax.ws.rs.core.FeatureContext;
//import javax.ws.rs.ext.MessageBodyReader;
//import javax.ws.rs.ext.MessageBodyWriter;
//
///**
// * Created with IntelliJ IDEA.
// * User: undancer
// * Date: 13-10-27
// * Time: 下午10:35
// * To change this template use File | Settings | File Templates.
// */
//public class JacksonFeature implements Feature {
//
//    @Override
//    public boolean configure(final FeatureContext context) {
//        final String disableMoxy = CommonProperties.MOXY_JSON_FEATURE_DISABLE + '.'
//                + context.getConfiguration().getRuntimeType().name().toLowerCase();
//        context.property(disableMoxy, true);
//
//        context.register(JacksonJaxbJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class);
//        return true;
//    }
//}
