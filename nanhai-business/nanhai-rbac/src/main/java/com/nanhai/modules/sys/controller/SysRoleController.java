package com.nanhai.modules.sys.controller;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SysRole;
import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.core.framework.object.AbstractController;
import com.nanhai.core.framework.object.SsoUser;
import com.nanhai.core.util.R;
import com.nanhai.modules.sys.service.NhSysRoleMenuService;
import com.nanhai.modules.sys.service.NhSysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理
 *
 */
@RestController
@RequestMapping("/sys/role")
@Slf4j
public class SysRoleController extends AbstractController {
	@Autowired
	private NhSysRoleService sysRoleService;
	@Autowired
	private NhSysRoleMenuService sysRoleMenuService;


	/**
	 * 角色列表
	 */
	@GetMapping(value = {"/list"})
	public R list(SysRoleConditionVO vo){
		PageInfo<SysRole> pageInfo = sysRoleService.findPageBreakByCondition(vo);
		return R.ok().put("data", pageInfo);
	}

	/**
	 * 获取角色详情
	 * @author 悟空
	 * @description //TODO
	 * @date 11:42 2021/5/20
	 * @param id
	 * @return com.nanhai.core.util.R
	 */
	@GetMapping(value = {"/get/{id}"})
	public R info(@PathVariable("id") Long id){
		SysRole sysRole = sysRoleService.getByPrimaryKey(id);
		log.info("sysRole:{}",sysRole);
		//TODO: 查询角色对应的菜单
		List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(sysRole.getRoleId());
		sysRole.setMenuIdList(menuIdList);
		return R.ok().put("data",sysRole);
	}



	/**
	 * 添加角色
	 * @author 悟空
	 * @description //TODO
	 * @date 11:45 2021/5/20
	 * @param vo
	 * @return com.nanhai.core.util.R
	 */
	@PostMapping(value = {"/save"})
	@Transactional(rollbackFor = Exception.class)
	public R save(SysRoleConditionVO vo,Authentication authentication){
		SsoUser user = parse(authentication);
		vo.setCreatePerson(user.getUsername());
		SysRoleConditionVO rsp = sysRoleService.save(vo);
		return R.ok().put("data",rsp);
	}

	/**
	 * 修改角色
	 * @author 悟空
	 * @description //TODO
	 * @date 11:45 2021/5/20
	 * @param vo
	 * @return com.nanhai.core.util.R
	 */
	@PostMapping(value = {"/update"})
	@Transactional(rollbackFor = Exception.class)
	public R update(SysRoleConditionVO vo){
		sysRoleService.updateSelectiveRole(vo);
		return R.ok();
	}

	@PostMapping(value = {"/delete"})
	public R delete(Long[] roleIds){
		sysRoleService.deleteBatch(roleIds);
		return R.ok();
	}



}
