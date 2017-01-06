package com.hjc.springMVC.service.serviceImpl;

import com.hjc.springMVC.persistence.dao.SysOrganizationMapper;
import com.hjc.springMVC.persistence.entity.SysOrganization;
import com.hjc.springMVC.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bravowhale on 2017/1/5.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    private SysOrganizationMapper organizationMapper;

    public int saveOrganization(SysOrganization organization) {
        return organizationMapper.insertSelective(organization);
    }

    public int updateOrganization(SysOrganization organization) {
        return organizationMapper.updateByPrimaryKeySelective(organization);
    }

    public void deleteOrganization(Long organizationId) {
        organizationMapper.deleteByPrimaryKey(organizationId);
    }

    public SysOrganization findOne(Long organizationId) {
        return organizationMapper.selectByPrimaryKey(organizationId);
    }

    public List<SysOrganization> findAll() {
        return organizationMapper.findAll();
    }

    public Object findAllWithExclude(SysOrganization organization) {
        return organizationMapper.findAllWithExclude(organization);
    }

    /**
     * @deprecated  暂时未实现
     * @param source
     * @param target
     */
    public void move(SysOrganization source, SysOrganization target) {
        SysOrganization organization = new SysOrganization();
        organization.setId(source.getId());
        organization.setParentId(target.getParentId());
        organization.setParentIds(target.getParentIds());
        organizationMapper.updateByPrimaryKeySelective(organization);
        organizationMapper.updateMoveSourceDescendantsSql(target.makeSelfAsParentIds(), source.makeSelfAsParentIds(), source.makeSelfAsParentIds());
    }
}
