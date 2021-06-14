package com.nanhai.modules.sys.service.impl;


import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SysRoleMenu;
import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.core.business.vo.SysRoleMenuConditionVO;
import com.nanhai.core.persistence.beans.NhSysRoleMenu;
import com.nanhai.modules.sys.mapper.NhSysRoleMenuMapper;
import com.nanhai.modules.sys.service.NhSysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色与菜单对应关系
 *
 */
@Service
public class NhSysRoleMenuServiceImpl implements NhSysRoleMenuService {

	@Autowired
	private NhSysRoleMenuMapper sysRoleMenuMapper;

	@Override
	public PageInfo<SysRoleMenu> findPageBreakByCondition(SysRoleMenuConditionVO vo) {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
		//TODO: 先删除角色与菜单关系
		sysRoleMenuMapper.deleteBatch(new Long[]{roleId});

		if(menuIdList.size() == 0){
			return;
		}

		//保存角色与菜单关系
		List<NhSysRoleMenu> list = new ArrayList<>(menuIdList.size());
		for(Long menuId: menuIdList){
			NhSysRoleMenu sysRoleMenu = new NhSysRoleMenu();
			sysRoleMenu.setMenuId(menuId);
			sysRoleMenu.setRoleId(roleId);
			sysRoleMenuMapper.insertSelective(sysRoleMenu);
		}
	}

	@Override
	public List<Long> queryMenuIdList(Long roleId) {
		return sysRoleMenuMapper.queryMenuIdList(roleId);
	}

	@Override
	public int deleteBatch(Long[] roleIds) {
		return sysRoleMenuMapper.deleteBatch(roleIds);
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
