package com.nanhai.modules.sys.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SysRole;
import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.core.persistence.beans.NhSysRole;
import com.nanhai.modules.sys.mapper.NhSysRoleMapper;
import com.nanhai.modules.sys.service.NhSysRoleMenuService;
import com.nanhai.modules.sys.service.NhSysRoleService;
import com.nanhai.modules.sys.service.NhSysUserRoleService;
import com.nanhai.modules.sys.service.NhSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 角色
 *
 */
@Service("sysRoleService")
public class NhSysRoleServiceImpl implements NhSysRoleService {
	@Autowired
	private NhSysRoleMenuService sysRoleMenuService;
	@Autowired
	private NhSysUserService sysUserService;
    @Autowired
    private NhSysUserRoleService sysUserRoleService;
    @Autowired
	private NhSysRoleMapper sysRoleMapper;

	@Override
	public PageInfo<SysRole> findPageBreakByCondition(SysRoleConditionVO vo) {
		PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());

		List<NhSysRole> list = sysRoleMapper.findPageBreakByCondition(vo);

		List<SysRole> boList  = new LinkedList<>();
		list.stream().forEach((item) -> {
			boList.add(new SysRole(item));
		});

		//指定返回的分页数据格式
		PageInfo bean = new PageInfo<NhSysRole>(list);
		bean.setList(boList);

		return bean;
	}

	@Override
	public List<Long> queryRoleIdList(Long createUserId) {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public SysRoleConditionVO save(SysRoleConditionVO vo) {
		SysRole obj = this.insert(vo.getSysRole());
		Long roleId = obj.getRoleId();
		vo.getSysRole().setRoleId(roleId);

		//TODO:检查权限是否越权暂时不做

		//TODO: 保存角色与权限关系
		sysRoleMenuService.saveOrUpdate(roleId,vo.getMenuIdList());
		return vo;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBatch(Long[] roleIds) {
		//删除角色
		Example example = new Example(NhSysRole.class);
		example.createCriteria().andIn("roleId", Arrays.asList(roleIds));
		sysRoleMapper.deleteByExample(example);

		//删除角色与菜单关联
		sysRoleMenuService.deleteBatch(roleIds);

		//删除角色与用户关联
		sysUserRoleService.deleteBatch(roleIds);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public SysRole insert(SysRole entity) {
		Assert.notNull(entity, "SysRole不可为空！");
		entity.setUpdateTime(new Date());
		entity.setCreateTime(new Date());
		sysRoleMapper.insertSelective(entity.getNhSysRole());
		return entity;
	}

	@Override
	public boolean removeByPrimaryKey(Long primaryKey) {
		return false;
	}

	@Override
	public boolean updateSelective(SysRole entity) {
		return false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateSelectiveRole(SysRoleConditionVO entity) {
		Assert.notNull(entity.getRoleId(), "roleId不可为空！");
		NhSysRole sysRole = entity.getNhSysRole();
		sysRole.setUpdateTime(new Date());
		sysRoleMapper.updateByPrimaryKeySelective(sysRole);

		//更新角色与菜单关系
		sysRoleMenuService.saveOrUpdate(entity.getRoleId(),entity.getMenuIdList());
	}



	@Override
	public SysRole getByPrimaryKey(Long primaryKey) {
		Assert.notNull(primaryKey, "PrimaryKey不可为空！");
		NhSysRole entity = sysRoleMapper.get(primaryKey);
		if (null == entity) {
			return null;
		}
		return new SysRole(entity);
	}
}
