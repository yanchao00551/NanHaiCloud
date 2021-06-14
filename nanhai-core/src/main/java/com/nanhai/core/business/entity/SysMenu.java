package com.nanhai.core.business.entity;

import com.nanhai.core.persistence.beans.NhSysMenu;
import com.nanhai.core.persistence.beans.NhSysRole;

import java.util.Date;
import java.util.List;

/**
 * @PackageName:com.nanhai.core.business.entity
 * @ClassName:SysMenu
 * @Description:
 * @author: 悟空
 * @date: 2021/5/23 9:37
 * @email: 10947@163.com
 */
public class SysMenu {
    private NhSysMenu nhSysMenu;

    public SysMenu(){
        this.nhSysMenu = new NhSysMenu();
    }

    public SysMenu(NhSysMenu nhSysMenu){
        this.nhSysMenu = nhSysMenu;
    }


    public Long getMenuId() {
        return nhSysMenu.getMenuId();
    }

    public Long getParentId() {
        return nhSysMenu.getParentId();
    }

    public String getParentName() {
        return nhSysMenu.getParentName();
    }

    public void setOrderNum(Integer orderNum) {
        nhSysMenu.setOrderNum(orderNum);
    }

    public void setOpen(Boolean open) {
        nhSysMenu.setOpen(open);
    }

    public void setParentName(String parentName) {
        nhSysMenu.setParentName(parentName);
    }

    public String getName() {
        return nhSysMenu.getName();
    }

    public void setUrl(String url) {
        nhSysMenu.setUrl(url);
    }

    public String getUrl() {
        return nhSysMenu.getUrl();
    }

    public void setMenuId(Long menuId) {
        nhSysMenu.setMenuId(menuId);
    }

    public void setPerms(String perms) {
        nhSysMenu.setPerms(perms);
    }

    public String getPerms() {
        return nhSysMenu.getPerms();
    }

    public void setList(List<?> list) {
        nhSysMenu.setList(list);
    }

    public Integer getType() {
        return nhSysMenu.getType();
    }

    public String getIcon() {
        return nhSysMenu.getIcon();
    }

    public Integer getOrderNum() {
        return nhSysMenu.getOrderNum();
    }

    public void setType(Integer type) {
        nhSysMenu.setType(type);
    }

    public Boolean getOpen() {
        return nhSysMenu.getOpen();
    }

    public void setName(String name) {
        nhSysMenu.setName(name);
    }

    public void setIcon(String icon) {
        nhSysMenu.setIcon(icon);
    }

    public List<?> getList() {
        return nhSysMenu.getList();
    }

    public void setParentId(Long parentId) {
        nhSysMenu.setParentId(parentId);
    }
}
