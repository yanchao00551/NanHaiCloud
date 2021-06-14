package com.nanhai.modules.sys.mapper;

import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.core.persistence.beans.NhSysRole;
import com.nanhai.core.plugin.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色管理
 */
@Mapper
@Repository
public interface NhSysRoleMapper extends BaseMapper<NhSysRole> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);

    List<NhSysRole> findPageBreakByCondition(SysRoleConditionVO vo);

    /**
	 * 获取角色详情
	 * @author 悟空
	 * @description //TODO
	 * @date 21:31 2021/5/19
	 * @param id
	 * @return java.util.List<com.nanhai.core.persistence.beans.NhSysRole>
	 */
	NhSysRole get(@Param(value = "id") Long id);
}
