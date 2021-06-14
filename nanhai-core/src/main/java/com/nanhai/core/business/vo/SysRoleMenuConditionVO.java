package com.nanhai.core.business.vo;

import com.nanhai.core.business.entity.SysRoleMenu;
import com.nanhai.core.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @PackageName:com.nanhai.core.business.vo
 * @ClassName:SysRoleMenuVO
 * @Description:
 * @author: 悟空
 * @date: 2021/5/19 17:55
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleMenuConditionVO extends BaseConditionVO {
    private SysRoleMenu sysRoleMenu;
    private List<Long> ids;
}
