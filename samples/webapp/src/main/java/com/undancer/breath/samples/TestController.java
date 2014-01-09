package com.undancer.breath.samples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by undancer on 14-1-2.
 */
@Controller
public class TestController {

    @RequestMapping("/i")
    public void handle(NativeWebRequest request) {
        for (Iterator<String> iterator = request.getParameterNames(); iterator.hasNext(); ) {
            String name = iterator.next();

            SimpleMappingExceptionResolver s;
            System.out.println("param[ " + name + " ] -> " + Arrays.asList(request.getParameterValues(name)));
        }
    }
}
