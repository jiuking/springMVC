package com.hjc.springMVC.service;

import com.hjc.springMVC.persistence.entity.SysResource;

import java.util.List;
import java.util.Set;

/**
 * Created by Bravowhale on 2017/1/5.
 */
public interface ResourceService {
    public int saveResource(SysResource resource);
    public int updateResource(SysResource resource);
    public void deleteResource(Long resourceId);

    SysResource findOne(Long resourceId);
    List<SysResource> findAll();

    /**
     * 得到资源对应的权限字符串
     * @param resourceIds
     * @return
     */
    Set<String> findPermissions(Set<Long> resourceIds);

    /**
     * 根据用户权限得到菜单
     */
    List<SysResource> findMenus(Set<String> permissions);
}
