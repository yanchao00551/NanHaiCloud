package com.nanhai.core.business.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.business.entity.SysRole;
import com.nanhai.core.framework.object.BaseConditionVO;
import com.nanhai.core.persistence.beans.NhSysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Delegate;

import java.util.Date;
import java.util.List;

/**
 * @PackageName:com.nanhai.core.business.vo
 * @ClassName:SysRoleVO
 * @Description:
 * @author: 悟空
 * @date: 2021/5/19 17:43
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleConditionVO extends BaseConditionVO {

    private SysRole sysRole;

    private List<Long> ids;
    private Long id;


    public SysRoleConditionVO(){
        this.sysRole = new SysRole();
    }

    public Long getRoleId() {
        return getSysRole().getRoleId();
    }

    public String getRoleName() {
        return getSysRole().getRoleName();
    }

    public String getRemark() {
        return getSysRole().getRemark();
    }

    public String getRoleCode() {
        return getSysRole().getRoleCode();
    }

    public Long getCreateUserId() {
        return getSysRole().getCreateUserId();
    }

    public void setCreateUserId(Long createUserId) {
        getSysRole().setCreateUserId(createUserId);
    }

    public void setCreatePerson(String createPerson) {
        getSysRole().setCreatePerson(createPerson);
    }

    public void setCreateTime(Date createTime) {
        getSysRole().setCreateTime(createTime);
    }

    public String getCreatePerson() {
        return getSysRole().getCreatePerson();
    }

    public List<Long> getMenuIdList() {
        return getSysRole().getMenuIdList();
    }

    public void setRoleCode(String roleCode) {
        getSysRole().setRoleCode(roleCode);
    }

    public void setMenuIdList(List<Long> menuIdList) {
        getSysRole().setMenuIdList(menuIdList);
    }

    public Date getCreateTime() {
        return getSysRole().getCreateTime();
    }

    public Date getUpdateTime() {
        return getSysRole().getUpdateTime();
    }

    public void setRoleId(Long roleId) {
        getSysRole().setRoleId(roleId);
    }

    public void setUpdateTime(Date updateTime) {
        getSysRole().setUpdateTime(updateTime);
    }

    public void setRemark(String remark) {
        getSysRole().setRemark(remark);
    }

    public void setRoleName(String roleName) {
        getSysRole().setRoleName(roleName);
    }

    @JsonIgnore
    public NhSysRole getNhSysRole() {
        return getSysRole().getNhSysRole();
    }
}
