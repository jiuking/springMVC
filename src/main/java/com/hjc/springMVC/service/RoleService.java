package com.hjc.springMVC.service;

import com.hjc.springMVC.persistence.entity.SysRole;

import java.util.List;
import java.util.Set;

/**
 * Created by Bravowhale on 2017/1/5.
 */
public interface RoleService {
    public int saveRole(SysRole role);
    public int updateRole(SysRole role);
    public void deleteRole(Long roleId);
    public SysRole findOne(Long roleId);
    public List<SysRole> findAll();

    /**
     * 根据角色编号得到角色标示符列表
     * @param rolesIds
     * @return
     */
    Set<String> findRoles(Long... rolesIds);

    /**
     * 根据角色编号得到权限字符串列表
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);
}
