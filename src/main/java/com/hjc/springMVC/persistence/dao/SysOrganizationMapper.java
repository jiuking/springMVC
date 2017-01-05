package com.hjc.springMVC.persistence.dao;


import com.hjc.springMVC.persistence.entity.SysOrganization;

import java.util.List;

public interface SysOrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysOrganization record);

    int insertSelective(SysOrganization record);

    SysOrganization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysOrganization record);

    int updateByPrimaryKey(SysOrganization record);

    List<SysOrganization> findAll();

    List<SysOrganization> findAllWithExclude(SysOrganization excludeOrganization);
}