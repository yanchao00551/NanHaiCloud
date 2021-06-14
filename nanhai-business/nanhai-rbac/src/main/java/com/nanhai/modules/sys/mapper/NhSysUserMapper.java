package com.nanhai.modules.sys.mapper;

import com.nanhai.core.business.vo.SysUserConditionVO;
import com.nanhai.core.persistence.beans.NhSysUser;
import com.nanhai.core.plugin.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统用户
 */
@Repository
@Mapper
public interface NhSysUserMapper extends BaseMapper<NhSysUser> {
	
	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);
	
	/**
	 * 根据用户名，查询系统用户
	 */
	NhSysUser queryByUserName(String username);

    List<NhSysUser> findPageBreakByCondition(SysUserConditionVO vo);


    /**
	 * 查看当前用户详情
	 * @author 悟空
	 * @description //TODO
	 * @date 16:42 2021/6/4
	 * @param userId
	 * @return com.nanhai.core.persistence.beans.NhSysUser
	 */
    NhSysUser selectUserDetail(@Param("userId") Long userId);
}
