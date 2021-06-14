package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhSysRole;
import lombok.ToString;
import lombok.experimental.Delegate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @PackageName:com.nanhai.core.business.entity
 * @ClassName:SysRole
 * @Description:
 * @author: 悟空
 * @date: 2021/5/19 17:45
 * @email: 10947@163.com
 */
@ToString
public class SysRole {
    private NhSysRole nhSysRole;

    public Integer getRoleStatus() {
        return nhSysRole.getRoleStatus();
    }

    public void setRoleStatus(Integer roleStatus) {
        nhSysRole.setRoleStatus(roleStatus);
    }

    public String getRoleMemo() {
        return nhSysRole.getRoleMemo();
    }

    public void setRoleMemo(String roleMemo) {
        nhSysRole.setRoleMemo(roleMemo);
    }

    public SysRole(NhSysRole nhSysRole){
        this.nhSysRole = nhSysRole;
    }

    public SysRole(){
        this.nhSysRole = new NhSysRole();
    }
    @JsonIgnore
    public NhSysRole getNhSysRole() {
        return nhSysRole;
    }


    public Long getRoleId() {
        return nhSysRole.getRoleId();
    }

    public Long getCreateUserId() {
        return nhSysRole.getCreateUserId();
    }

    public String getRoleName() {
        return nhSysRole.getRoleName();
    }

    public void setRoleCode(String roleCode) {
        nhSysRole.setRoleCode(roleCode);
    }

    public void setRemark(String remark) {
        nhSysRole.setRemark(remark);
    }

    public void setMenuIdList(List<Long> menuIdList) {
        nhSysRole.setMenuIdList(menuIdList);
    }

    public String getRemark() {
        return nhSysRole.getRemark();
    }

    public String getRoleCode() {
        return nhSysRole.getRoleCode();
    }

    public void setCreateUserId(Long createUserId) {
        nhSysRole.setCreateUserId(createUserId);
    }

    public void setCreatePerson(String createPerson) {
        nhSysRole.setCreatePerson(createPerson);
    }

    public String getCreatePerson() {
        return nhSysRole.getCreatePerson();
    }

    public List<Long> getMenuIdList() {
        return nhSysRole.getMenuIdList();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhSysRole.setCreateTime(createTime);
    }

    public Date getCreateTime() {
        return nhSysRole.getCreateTime();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhSysRole.setUpdateTime(updateTime);
    }

    public Date getUpdateTime() {
        return nhSysRole.getUpdateTime();
    }

    public void setRoleId(Long roleId) {
        nhSysRole.setRoleId(roleId);
    }

    public void setRoleName(String roleName) {
        nhSysRole.setRoleName(roleName);
    }
}
