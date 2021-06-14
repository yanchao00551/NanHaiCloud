package com.nanhai.core.persistence.beans;



import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 系统用户
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "nh_sys_user")
public class NhSysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@Id
	@GeneratedValue(generator = "JDBC")
	private Long userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 盐
	 */
	private String salt;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;
	
	/**
	 * 角色ID列表
	 */
	@Transient
	private List<Long> roleIdList;

	/**
	 * 权限列表
	 */
	@Transient
	private Set<String> userPermissions;
	
	/**
	 * 创建者ID
	 */
	private Long createUserId;

	private Long organId;

	@Transient
	private String organCode;

	@Transient
	private String administrativeHigh;

	@Transient
	private List<String> parentCode;

	@Transient
	private Long organParent;


	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	private Date createTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	private Date updateTime;


	/**
	 * 头像列表
	 * @author 悟空
	 * @description //TODO
	 * @date 22:40 2021/6/4
	 * @param null
	 * @return null
	 */
	@Transient
	private JSONArray userHeadImgs;


	/**
	 * 用户头像
	 * @author 悟空
	 * @description //TODO
	 * @date 17:03 2021/6/4
	 * @param null
	 * @return null
	 */
	@Transient
	private String userHead;


	@Transient
	private Integer userLevel;
	@Transient
	private String userLoginName;
	@Transient
	private String userAdministrativeCode;



	@Transient
	private String administrativeName;

	@Transient
	private String organName;


	private String realName;


	@Transient
	private String registerCard;
	@Transient
	private String registerTele;

	@Transient
	private List<Long> roleIds;
	@Transient
	private List<NhSysRole> roles;

	@Transient
	private String userIdenty;




}
