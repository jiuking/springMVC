package com.hjc.springMVC.service;

import com.hjc.springMVC.persistence.entity.SysOrganization;

import java.util.List;

/**
 * Created by Bravowhale on 2017/1/5.
 */
public interface OrganizationService {
    public int saveOrganization(SysOrganization organization);
    public int updateOrganization(SysOrganization organization);
    public void deleteOrganization(Long organizationId);

    SysOrganization findOne(Long organizationId);
    List<SysOrganization> findAll();
    Object findAllWithExclude(Long id,String makeSelfAsParentIds);
    void move(SysOrganization source,SysOrganization target);
}
