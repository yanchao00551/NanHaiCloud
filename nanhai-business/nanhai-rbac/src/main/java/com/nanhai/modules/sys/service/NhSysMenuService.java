
package com.nanhai.modules.sys.service;


import com.nanhai.core.business.entity.SysMenu;
import com.nanhai.core.business.entity.SysRoleMenu;
import com.nanhai.core.framework.object.AbstractService;

import java.util.List;


/**
 * 菜单管理
 *
 */
public interface NhSysMenuService extends AbstractService<SysRoleMenu,Long> {

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 * @param menuIdList  用户菜单ID
	 */
	List<SysMenu> queryListParentId(Long parentId, List<Long> menuIdList);

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenu>queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenu> queryNotButtonList();
	
	/**
	 * 获取用户菜单列表
	 */
	List<SysMenu> getUserMenuList(Long userId);

	/**
	 * 获取所有菜单
	 * @author 悟空
	 * @description //TODO
	 * @date 9:52 2021/5/23
	 * @param o
	 * @return java.util.List<com.nanhai.core.business.entity.SysMenu>
	 */
	List<SysMenu> selectList(Object o);
}
