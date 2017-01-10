package com.hjc.springMVC.web.contoller;

import com.hjc.springMVC.persistence.entity.SysResource;
import com.hjc.springMVC.persistence.entity.SysUser;
import com.hjc.springMVC.service.ResourceService;
import com.hjc.springMVC.service.UserService;
import com.hjc.springMVC.web.bind.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

/**
 * Created by Bravowhale on 2017/1/9.
 */
@Controller
public class IndexController {
    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;

    final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
        public String index(@CurrentUser SysUser loginUser, Model model){
        Set<String> permissions = userService.findPermissions(loginUser.getUsername());
        List<SysResource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus",menus);
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
