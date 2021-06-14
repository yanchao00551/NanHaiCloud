package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhSysRoleMenu;
import lombok.experimental.Delegate;

import java.util.Date;

/**
 * @PackageName:com.nanhai.core.business.entity
 * @ClassName:SysRoleMenu
 * @Description:
 * @author: 悟空
 * @date: 2021/5/19 17:50
 * @email: 10947@163.com
 */
public class SysRoleMenu {
    private NhSysRoleMenu nhSysRoleMenu;
    public SysRoleMenu(){
        this.nhSysRoleMenu = new NhSysRoleMenu();
    }
    @JsonIgnore
    public NhSysRoleMenu getNhSysRoleMenu() {
        return nhSysRoleMenu;
    }

}
