package com.hjc.springMVC.persistence.dao;

import com.hjc.springMVC.persistence.entity.SysResource;

import java.util.List;
import java.util.Set;

public interface SysResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

    List<SysResource> findAll();

    Set<String> findPermissions(Set<Long> resourceIds);
}