package com.hjc.springMVC.web.shiro;

import com.hjc.springMVC.common.Constants;
import com.hjc.springMVC.service.UserService;
import com.hjc.springMVC.web.contoller.HelloWorldController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Bravowhale on 2017/1/4.
 */
public class SysUserFilter extends PathMatchingFilter{
    @Autowired
    private UserService userService;

    final Logger logger = LoggerFactory.getLogger(SysUserFilter.class);

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER, userService.findByUsername(username));
        logger.debug(userService.findByUsername(username).getUsername());
        return true;
    }
}
