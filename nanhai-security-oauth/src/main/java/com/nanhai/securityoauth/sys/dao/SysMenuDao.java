
package com.nanhai.securityoauth.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.nanhai.securityoauth.sys.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:33:01
 */
@Repository
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenuEntity> {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenuEntity> queryNotButtonList();

}
