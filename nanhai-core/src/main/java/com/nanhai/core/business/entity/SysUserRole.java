package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhSysRole;
import com.nanhai.core.persistence.beans.NhSysUserRole;

import java.util.Date;
import java.util.List;

/**
 * @PackageName:com.nanhai.core.business.entity
 * @ClassName:SysUserRole
 * @Description:
 * @author: 悟空
 * @date: 2021/5/19 17:52
 * @email: 10947@163.com
 */
public class SysUserRole {
    private NhSysUserRole nhSysUserRole;

    public SysUserRole(){
        this.nhSysUserRole = new NhSysUserRole();
    }

    @JsonIgnore
    public NhSysUserRole getNhSysUserRole() {
        return nhSysUserRole;
    }

    public Long getUserId() {
        return nhSysUserRole.getUserId();
    }

    public Long getRoleId() {
        return nhSysUserRole.getRoleId();
    }

    public void setUserId(Long userId) {
        nhSysUserRole.setUserId(userId);
    }

    public void setRoleId(Long roleId) {
        nhSysUserRole.setRoleId(roleId);
    }
}
