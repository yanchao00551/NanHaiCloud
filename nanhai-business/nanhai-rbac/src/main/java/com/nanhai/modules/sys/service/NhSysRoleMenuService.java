package com.nanhai.modules.sys.service;


import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SysRoleMenu;
import com.nanhai.core.business.vo.SysRoleMenuConditionVO;
import com.nanhai.core.framework.object.AbstractService;

import java.util.List;


/**
 * 角色与菜单对应关系
 *
 */
public interface NhSysRoleMenuService extends AbstractService<SysRoleMenu,Long> {

	/**
	 * 分页查询
	 *
	 * @param vo
	 * @return
	 */
	PageInfo<SysRoleMenu> findPageBreakByCondition(SysRoleMenuConditionVO vo);



	void saveOrUpdate(Long roleId, List<Long> menuIdList);
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
	
}
