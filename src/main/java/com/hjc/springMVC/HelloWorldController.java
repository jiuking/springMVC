package com.hjc.springMVC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bravowhale on 2017/1/3.
 */
@Controller
public class HelloWorldController {
    final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    @RequestMapping("/helloworld")
    public String hello(){
        logger.info("Hello logback info");
        logger.error("debug");
        System.out.println("Hello World!");
        return "success";
    }
}
