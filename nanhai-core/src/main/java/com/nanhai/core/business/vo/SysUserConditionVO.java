package com.nanhai.core.business.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.business.entity.AdministrativeArea;
import com.nanhai.core.business.entity.SysUser;
import com.nanhai.core.business.entity.Users;
import com.nanhai.core.framework.object.BaseConditionVO;
import com.nanhai.core.persistence.beans.NhSysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @PackageName:com.nanhai.core.business.vo
 * @ClassName:SysUserVO
 * @Description:
 * @author: 悟空
 * @date: 2021/5/19 18:00
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserConditionVO extends BaseConditionVO {

    private SysUser sysUser;
    private AdministrativeArea administrativeArea;
    private Users users;

    private String organCode;
    private String organId;
    private String administrativeCode;
    private String administrativeLevel;
    private String password;
    private String registerTele;
    private String registerCard;
    private Long userId;
    private Integer status;
    private List<Long> ids;

    public void setCreateUserId(Long createUserId) {
        getSysUser().setCreateUserId(createUserId);
    }

    public Long getCreateUserId() {
        return getSysUser().getCreateUserId();
    }

    public SysUserConditionVO(){
        this.sysUser = new SysUser();
        this.administrativeArea = new AdministrativeArea();
        this.users = new Users();
    }

    public String getRealName() {
        return getSysUser().getRealName();
    }

    public void setRealName(String realName) {
        getSysUser().setRealName(realName);
    }


    public String getUsername() {
        return getSysUser().getUsername();
    }

    public Integer getUserLevel() {
        return getSysUser().getUserLevel();
    }

    public String getPassword() {
        return getSysUser().getPassword();
    }

    public void setUserLevel(Integer userLevel) {
        getSysUser().setUserLevel(userLevel);
    }


    public void setUsername(String username) {
        getSysUser().setUsername(username);
    }

    public void setPassword(String password) {
        getSysUser().setPassword(password);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonIgnore
    public NhSysUser getNhSysUser() {
        return getSysUser().getNhSysUser();
    }
}
