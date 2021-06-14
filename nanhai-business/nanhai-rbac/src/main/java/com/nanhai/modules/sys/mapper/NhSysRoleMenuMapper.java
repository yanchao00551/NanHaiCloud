package com.nanhai.modules.sys.mapper;

import com.nanhai.core.persistence.beans.NhSysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * 角色与菜单对应关系
 */
@Mapper
@Repository
public interface NhSysRoleMenuMapper extends BaseMapper<NhSysRoleMenu> {
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
}
