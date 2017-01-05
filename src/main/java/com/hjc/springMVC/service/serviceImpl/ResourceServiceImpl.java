package com.hjc.springMVC.service.serviceImpl;

import com.hjc.springMVC.persistence.dao.SysResourceMapper;
import com.hjc.springMVC.persistence.entity.SysResource;
import com.hjc.springMVC.service.ResourceService;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Bravowhale on 2017/1/5.
 */
@Service
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private SysResourceMapper resourceMapper;

    public int saveResource(SysResource resource) {
        return resourceMapper.insertSelective(resource);
    }

    public int updateResource(SysResource resource) {
        return resourceMapper.updateByPrimaryKeySelective(resource);
    }

    public void deleteResource(Long resourceId) {
        resourceMapper.deleteByPrimaryKey(resourceId);
    }

    public SysResource findOne(Long resourceId) {
        return resourceMapper.selectByPrimaryKey(resourceId);
    }

    public List<SysResource> findAll() {
        return resourceMapper.findAll();
    }

    public Set<String> findPermissions(Set<Long> resourceIds) {
        Set<String> permissions = new HashSet<String>();
        for (Long resourceId : resourceIds) {
            SysResource resource = findOne(resourceId);
            if(null != resource && !StringUtils.isEmpty(resource.getPermission())){
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }

    public List<SysResource> findMenus(Set<String> permissions) {
        List<SysResource> allResources = findAll();
        List<SysResource> menus = new ArrayList<SysResource>();
        for (SysResource resource : allResources) {
            if(resource.isRootNode()){
                continue;
            }
            if(resource.getType() != SysResource.ResourceType.menu){
                continue;
            }
            if(!hasPermission(permissions , resource)){
                continue;
            }
            menus.add(resource);
        }
        return menus;
    }
    private boolean hasPermission(Set<String> permissions,SysResource resource){
        if(StringUtils.isEmpty(resource.getPermission())){
            return true;
        }
        for(String permission : permissions){
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)){
                return true;
            }
        }
        return false;
    }
}
