package com.nanhai.modules.sys.mapper;

import com.nanhai.core.persistence.beans.NhSysUserRole;
import com.nanhai.core.plugin.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户与角色对应关系
 */
@Mapper
@Repository
public interface NhSysUserRoleMapper extends BaseMapper<NhSysUserRole> {
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);


	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);


    List<NhSysUserRole> selectInUserId(@Param("ids") List<Long> ids);



}
