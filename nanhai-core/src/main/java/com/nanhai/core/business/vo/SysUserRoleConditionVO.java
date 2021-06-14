package com.nanhai.core.business.vo;

import com.nanhai.core.business.entity.SysUserRole;
import com.nanhai.core.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @PackageName:com.nanhai.core.business.vo
 * @ClassName:SysUserRoleVO
 * @Description:
 * @author: 悟空
 * @date: 2021/5/19 18:00
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserRoleConditionVO extends BaseConditionVO {
    private SysUserRole sysUserRole;
    private Integer ids;


}
