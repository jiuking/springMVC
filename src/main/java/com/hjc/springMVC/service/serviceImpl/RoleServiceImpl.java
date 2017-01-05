package com.hjc.springMVC.service.serviceImpl;

import com.hjc.springMVC.persistence.dao.SysResourceMapper;
import com.hjc.springMVC.persistence.dao.SysRoleMapper;
import com.hjc.springMVC.persistence.entity.SysRole;
import com.hjc.springMVC.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Bravowhale on 2017/1/5.
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysResourceMapper resourceMapper;

    public int saveRole(SysRole role) {
        return roleMapper.insertSelective(role);
    }

    public int updateRole(SysRole role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    public void deleteRole(Long roleId) {
        roleMapper.deleteByPrimaryKey(roleId);
    }

    public SysRole findOne(Long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    public List<SysRole> findAll() {
        return roleMapper.findAll();
    }

    public Set<String> findRoles(Long... rolesIds) {
        Set<String> roles = new HashSet<String>();
        for (Long roleId : rolesIds){
            SysRole role = findOne(roleId);
            if(role != null){
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();
        for (Long roleId : roleIds) {
            SysRole role = findOne(roleId);
            if(null != role){
                resourceIds.addAll(role.getResourceIdsList());
            }
        }
        return resourceMapper.findPermissions(resourceIds);
    }
}
