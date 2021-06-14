package com.nanhai.securityoauth.sys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@SuppressWarnings(value= {})
public class SendMsgForm {
	/**
	 * 手机号
	 */
    @NotNull(message="手机号不能为空")
	private String mobile;
	
	private String imgCode;

	/**
	 * 1 普通短信发送  2 需账号验证后短信发送
	 * @author 悟空
	 * @description //TODO
	 * @date 12:32 2021/6/3
	 * @param null
	 * @return null
	 */
	private String sendType;
	
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	
}
