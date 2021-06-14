package com.nanhai.core.persistence.beans;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.management.relation.RoleStatus;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "nh_sys_role")
public class NhSysRole implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
	@Id
	@GeneratedValue(generator = "JDBC")
	private Long roleId;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 角色编码
	 * @author 悟空
	 * @description //TODO
	 * @date 19:23 2021/5/19
	 * @param null
	 * @return null
	 */
	private String roleCode;
	
	/**
	 * 创建者ID
	 */
	private Long createUserId;

	private String createPerson;

	private Integer roleStatus;

	private String roleMemo;

	@Transient
	private List<Long> menuIdList;
	
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	private Date createTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	private Date updateTime;

	
}
