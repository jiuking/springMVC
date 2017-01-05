package com.hjc.springMVC.persistence.dao;

import com.hjc.springMVC.persistence.entity.SysUser;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser findOne(Long userId);

    List<SysUser> findAll();

    SysUser findByUsername(String username);
}