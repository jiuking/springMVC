package com.hjc.springMVC.service.serviceImpl;

import com.hjc.springMVC.persistence.dao.SysUserMapper;
import com.hjc.springMVC.persistence.entity.SysUser;
import com.hjc.springMVC.service.UserService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by Bravowhale on 2017/1/4.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    @Transactional
    public int saveUser(SysUser user){
        int result = sysUserMapper.insert(user);
        return result;
    }

    public Set findRoles(String username) {
        return null;
    }

    public Set findPermissions(String username) {
        return null;
    }

    public SysUser findByUsername(String username) {
        return null;
    }
}
