package com.hjc.springMVC.service;

import com.hjc.springMVC.persistence.entity.SysUser;

import java.util.Set;

/**
 * Created by Bravowhale on 2017/1/4.
 */
public interface UserService {
    int saveUser(SysUser user);
    Set findRoles(String username);
    Set findPermissions(String username);
    SysUser findByUsername(String username);
}
