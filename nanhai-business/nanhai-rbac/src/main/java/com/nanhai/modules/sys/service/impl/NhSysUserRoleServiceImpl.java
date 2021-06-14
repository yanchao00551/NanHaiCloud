package com.nanhai.modules.sys.service.impl;



import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SysUserRole;
import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.modules.sys.mapper.NhSysUserRoleMapper;
import com.nanhai.modules.sys.service.NhSysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户与角色对应关系
 *
 */
@Service
public class NhSysUserRoleServiceImpl implements NhSysUserRoleService {

	@Autowired
	private NhSysUserRoleMapper sysUserRoleMapper;

	@Override
	public PageInfo<SysUserRole> findPageBreakByCondition(SysUserRole vo) {
		return null;
	}

	@Override
	public void saveOrUpdate(Long userId, List<Long> roleIdList) {

	}

	@Override
	public List<Long> queryRoleIdList(Long userId) {
		return null;
	}

	@Override
	public int deleteBatch(Long[] roleIds) {
		return sysUserRoleMapper.deleteBatch(roleIds);
	}

	@Override
	public SysUserRole insert(SysUserRole entity) {
		return null;
	}

	@Override
	public boolean removeByPrimaryKey(Long primaryKey) {
		return false;
	}

	@Override
	public boolean updateSelective(SysUserRole entity) {
		return false;
	}


	@Override
	public SysUserRole getByPrimaryKey(Long primaryKey) {
		return null;
	}
}
