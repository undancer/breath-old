package com.undancer.breath.samples;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created by undancer on 14-1-7.
 */
@Controller
@RequestMapping("/beans")
public class BeanController {

    @Inject
    ApplicationContext applicationContext;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity beans() {
        ObjectNode payload = JsonNodeFactory.instance.objectNode();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (int index = 0; index < beanDefinitionNames.length; index++) {
            String beanDefinitionName = beanDefinitionNames[index];
            payload.put("" + index, beanDefinitionName);
        }

        return new ResponseEntity(payload, HttpStatus.OK);
    }
}
