package com.nanhai.modules.sys.service;


import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SysRole;
import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.core.framework.object.AbstractService;

import java.util.List;


/**
 * 角色
 *
 */
public interface NhSysRoleService extends AbstractService<SysRole,Long> {


	/**
	 * 分页查询
	 *
	 * @param vo
	 * @return
	 */
	PageInfo<SysRole> findPageBreakByCondition(SysRoleConditionVO vo);


	void updateSelectiveRole(SysRoleConditionVO entity);


	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);

	/**
	 * 新增角色
	 * @author 悟空
	 * @description //TODO
	 * @date 11:48 2021/5/20
	 * @param vo
	 * @return boolean
	 */
	SysRoleConditionVO save(SysRoleConditionVO vo);

	/**
	 * 批量删除角色
	 * @author 悟空
	 * @description //TODO
	 * @date 14:21 2021/5/28
	 * @param roleIds

	 */
    void deleteBatch(Long[] roleIds);
}
