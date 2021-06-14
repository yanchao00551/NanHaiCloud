package com.nanhai.securityoauth.sys.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ValidateForm {
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



	/**
	 * 自定义密码
	 */
	private String password;


	/**
	 * 状态 1 修改密码   2 修改手机号码
	 */
	@NotNull(message = "type不能为空")
	private Integer type;


}
