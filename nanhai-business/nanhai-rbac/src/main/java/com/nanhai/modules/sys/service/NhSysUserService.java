package com.nanhai.modules.sys.service;




import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SysUser;
import com.nanhai.core.business.vo.SysUserConditionVO;
import com.nanhai.core.framework.object.AbstractService;
import com.nanhai.core.persistence.beans.NhSysUser;

import java.util.List;


/**
 * 系统用户
 *
 */
public interface NhSysUserService extends AbstractService<SysUser,Long> {

	/**
	 * 分页查询
	 *
	 * @param vo
	 * @return
	 */
	PageInfo<SysUser> findPageBreakByCondition(SysUserConditionVO vo);

	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);

	/**
	 * 根据用户名，查询系统用户
	 */
	NhSysUser queryByUserName(String username);


	/**
	 * 修改密码
	 * @param userId       用户ID
	 * @param password     原密码
	 * @param newPassword  新密码
	 */
	Integer updatePassword(Long userId, String password, String newPassword);

	/**
	 * 注册用户-根据行政区划绑定角色
	 * @author 悟空
	 * @description //TODO
	 * @date 19:38 2021/5/20
	 * @param vo
	 * @return com.nanhai.core.business.vo.SysRoleConditionVO
	 */
    Boolean register(SysUserConditionVO vo);

	Boolean updateUserInfo(SysUserConditionVO vo);

	/**
	 * 批量删除用户
	 * @author 悟空
	 * @description //TODO
	 * @date 13:56 2021/5/28
	 * @param userIds
	 */
    void deleteBatch(Long[] userIds);


    void auditBatch(Long[] userIds);


    /**
	 * 修改用户头像
	 * @author 悟空
	 * @description //TODO
	 * @date 16:37 2021/6/3
	 * @param headImg
	 * @param userId
	 */
	void updateHead(String[] headImg, Long userId);

	/**
	 * 获取用户详情
	 * @author 悟空
	 * @description //TODO
	 * @date 16:37 2021/6/4
	 * @param userId
	 * @return com.nanhai.core.business.entity.SysUser
	 */
    SysUser getUserDetail(Long userId);
}
