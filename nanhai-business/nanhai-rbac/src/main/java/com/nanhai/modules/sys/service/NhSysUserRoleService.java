package com.nanhai.modules.sys.service;


import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SysUserRole;
import com.nanhai.core.framework.object.AbstractService;

import java.util.List;


/**
 * 用户与角色对应关系
 *
 */
public interface NhSysUserRoleService extends AbstractService<SysUserRole,Long> {

	/**
	 * 分页查询
	 *
	 * @param vo
	 * @return
	 */
	PageInfo<SysUserRole> findPageBreakByCondition(SysUserRole vo);


	void saveOrUpdate(Long userId, List<Long> roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
}
