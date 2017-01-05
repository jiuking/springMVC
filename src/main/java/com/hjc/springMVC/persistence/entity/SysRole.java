package com.hjc.springMVC.persistence.entity;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SysRole {
    private Long id;

    private String role;

    private String description;

    private List<Long> resourceIdsList;

    private String resourceIds;

    private Boolean available = Boolean.TRUE;

    public SysRole() {
    }

    public SysRole(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceIds() {
        if(CollectionUtils.isEmpty(resourceIdsList)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(Long resourceId : resourceIdsList) {
            s.append(resourceId);
            s.append(",");
        }
        return s.toString();
    }

    public void setResourceIds(String resourceIds) {
        if(StringUtils.isEmpty(resourceIds)) {
            return;
        }
        String[] resourceIdStrs = resourceIds.split(",");
        for(String resourceIdStr : resourceIdStrs) {
            if(StringUtils.isEmpty(resourceIdStr)) {
                continue;
            }
            getResourceIdsList().add(Long.valueOf(resourceIdStr));
        }
    }

    public List<Long> getResourceIdsList(){
        if(resourceIdsList == null){
            resourceIdsList = new ArrayList<Long>();
        }
        return resourceIdsList;
    }

    public void setResourceIdsList(List<Long> resourceIdsList){
        this.resourceIdsList = resourceIdsList;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}