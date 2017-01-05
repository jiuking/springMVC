package com.hjc.springMVC.service.serviceImpl;

import com.hjc.springMVC.common.PasswordHelper;
import com.hjc.springMVC.persistence.dao.SysRoleMapper;
import com.hjc.springMVC.persistence.dao.SysUserMapper;
import com.hjc.springMVC.persistence.entity.SysUser;
import com.hjc.springMVC.service.RoleService;
import com.hjc.springMVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by Bravowhale on 2017/1/4.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private PasswordHelper passwordHelper;

    @Autowired
    private RoleService roleService;

    @Transactional
    public int saveUser(SysUser user){
        passwordHelper.encryptPassword(user);
        int result = userMapper.insert(user);
        return result;
    }

    public int updateUser(SysUser user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public void deleteUser(Long userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    public void changePassword(Long userId, String newPassword) {
        SysUser user = userMapper.selectByPrimaryKey(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userMapper.updateByPrimaryKeySelective(user);
    }

    public SysUser findOne(Long userId) {
        return userMapper.findOne(userId);
    }

    public List<SysUser> findAll() {
        return userMapper.findAll();
    }

    public SysUser findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public Set<String> findRoles(String username) {
        SysUser user = findByUsername(username);
        if(null == user){
            return Collections.EMPTY_SET;
        }
        return roleService.findRoles(user.getRoleIdsList().toArray(new Long[0]));
    }

    public Set<String> findPermissions(String username) {
        SysUser user = findByUsername(username);
        if(null == user){
            return Collections.EMPTY_SET;
        }
        return roleService.findPermissions(user.getRoleIdsList().toArray(new Long[0]));
    }

}
