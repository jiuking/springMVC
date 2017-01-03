package com.hjc.springMVC;

import com.hjc.springMVC.persistence.dao.SysUserMapper;
import com.hjc.springMVC.persistence.entity.SysUser;
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
    private SysUserMapper sysUserMapper;

    @RequestMapping("/helloworld")
    public String hello(){
        SysUser user = sysUserMapper.selectByPrimaryKey(1L);
        logger.debug(user.getUsername());
        logger.info("Hello logback info");
        logger.error("debug");
        System.out.println("Hello World!");
        return "success";
    }
}
