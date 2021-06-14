package com.nanhai.core.persistence.beans;



import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 角色与菜单对应关系
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhSysRoleMenu extends AbstractDO {
	private static final long serialVersionUID = 1L;


	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 菜单ID
	 */
	private Long menuId;

	
}
