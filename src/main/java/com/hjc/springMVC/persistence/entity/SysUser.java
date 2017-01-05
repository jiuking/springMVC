package com.hjc.springMVC.persistence.entity;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SysUser {
    private Long id;

    private Long organizationId;

    private String username;

    private String password;

    private String salt;

    private String roleIds;

    private List<Long> roleIdsList;

    private Boolean locked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRoleIds() {
        if(CollectionUtils.isEmpty(roleIdsList)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(Long roleId : roleIdsList) {
            s.append(roleId);
            s.append(",");
        }
        return s.toString();
    }

    public void setRoleIds(String roleIds) {
        if(StringUtils.isEmpty(roleIds)) {
            return;
        }
        String[] roleIdStrs = roleIds.split(",");
        for(String roleIdStr : roleIdStrs) {
            if(StringUtils.isEmpty(roleIdStr)) {
                continue;
            }
            getRoleIdsList().add(Long.valueOf(roleIdStr));
        }
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getCredentialsSalt(){
        return getUsername() + getSalt();
    }

    public List<Long> getRoleIdsList() {
        if(roleIdsList == null){
            roleIdsList = new ArrayList<Long>();
        }
        return roleIdsList;
    }

    public void setRoleIdsList(List<Long> roleIdsList) {
        this.roleIdsList = roleIdsList;
    }
}