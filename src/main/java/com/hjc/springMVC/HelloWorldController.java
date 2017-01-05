package com.hjc.springMVC;

import com.hjc.springMVC.persistence.dao.SysUserMapper;
import com.hjc.springMVC.persistence.entity.SysUser;
import com.hjc.springMVC.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bravowhale on 2017/1/3.
 */
@Controller
public class HelloWorldController {
    final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String hello(){
        SysUser user = new SysUser();
        user.setUsername("张三");
        user.setSalt("asdf123");
        logger.debug(user.getUsername());
        logger.info("Hello logback info");
        logger.error("debug");
        System.out.println("Hello World!");
        return "success";
    }
}
