package com.nanhai.modules.sys.service.impl;

import com.nanhai.core.business.entity.SysMenu;
import com.nanhai.core.business.entity.SysRoleMenu;
import com.nanhai.core.persistence.beans.NhSysMenu;
import com.nanhai.modules.sys.mapper.NhSysMenuMapper;
import com.nanhai.modules.sys.service.NhSysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @PackageName:com.nanhai.modules.sys.service.impl
 * @ClassName:NhSysMenuService
 * @Description:
 * @author: 悟空
 * @date: 2021/5/23 9:49
 * @email: 10947@163.com
 */
@Service
public class NhSysMenuServiceImpl implements NhSysMenuService {

    @Autowired
    private NhSysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> queryListParentId(Long parentId, List<Long> menuIdList) {
        return null;
    }

    @Override
    public List<SysMenu> queryListParentId(Long parentId) {
        return null;
    }

    @Override
    public List<SysMenu> queryNotButtonList() {
        return null;
    }

    @Override
    public List<SysMenu> getUserMenuList(Long userId) {
        return null;
    }

    @Override
    public List<SysMenu> selectList(Object o) {
        List<NhSysMenu> menuList = sysMenuMapper.selectAll();
        for(NhSysMenu sysMenu: menuList){
            NhSysMenu parentSysMenu = sysMenuMapper.selectByPrimaryKey(sysMenu.getParentId());
            if(parentSysMenu != null){
                sysMenu.setParentName(parentSysMenu.getName());
            }
        }

        List<SysMenu> rspList = new LinkedList<>();
        menuList.stream().forEach((value) -> {
            rspList.add(new SysMenu(value));
        });

        return rspList;
    }

    @Override
    public SysRoleMenu insert(SysRoleMenu entity) {
        return null;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(SysRoleMenu entity) {
        return false;
    }

    @Override
    public SysRoleMenu getByPrimaryKey(Long primaryKey) {
        return null;
    }
}
