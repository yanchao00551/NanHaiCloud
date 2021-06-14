package com.nanhai.securityoauth.sys.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ValidateMsgForm {
	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
	@NotNull(message="手机号不能为空")
	private String mobile;
	/**
	 * 验证码
	 */
	@ApiModelProperty(value = "验证码")
	@NotNull(message="验证码不能为空")
	private String msgNum;
	/**
	 * 时间戳
	 */
	@ApiModelProperty(value = "时间戳")
    @NotNull(message="时间戳不能为空")
	private String tamp;
	/**
	 * hash
	 */
	@ApiModelProperty(value = "hash")
    @NotNull(message="hash不能为空")
	private String hash;


	@NotNull(message = "姓名不能为空")
	private String realName;


	@NotNull(message = "申请辖区不能为空")
	private String userAdministrativeCode;

	private String email;


	@NotNull(message = "身份证号码")
	private String registerCard;

	/**
	 * 自定义密码
	 */
	private String password;


	/**
	 * 状态 0 注册  1 修改密码
	 */
	@NotNull(message = "type不能为空")
	private Integer type;

	/**
	 * 申请理由
	 */

	private String registerMemo;

}
