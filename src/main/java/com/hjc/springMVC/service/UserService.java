package com.hjc.springMVC.service;

import com.hjc.springMVC.persistence.entity.SysUser;

import java.util.List;
import java.util.Set;

/**
 * Created by Bravowhale on 2017/1/4.
 */
public interface UserService {
    public int saveUser(SysUser user);
    public int updateUser(SysUser user);
    public void deleteUser(Long userId);
    public void changePassword(Long userId,String newPassword);
    SysUser findOne(Long userId);
    List<SysUser> findAll();
    Set findRoles(String username);
    Set findPermissions(String username);
    SysUser findByUsername(String username);
}
