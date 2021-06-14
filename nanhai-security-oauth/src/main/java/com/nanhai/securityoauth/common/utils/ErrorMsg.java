package com.nanhai.securityoauth.common.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 枚举统一错误返回格式
 * 
 * @author yanchao
 */

// 定义返回值字母格式 基础1000-1999， 用户：2000-2999 商品：3000-3999， 订单：4000-4999 活动：5000-5999 通知:6000-6999

public enum ErrorMsg {
	
	SUCCESS("操作成功",1),
	ADD_FAIL("添加失败",-1000),
	UPDATA_FAIL("修改失败",-1001),
	DELETE_FAIL("删除失败",-1002),
	SYSTEM_DELETE_FAIL("当前分类下存在子分类，不能删除!",-1003),
	NO_AITHORITY("当前用户无权限",-1005),
	UPLOAD_FILE_MAX_FAIL("上传文件大小超出限制!",-1006),
	UPLOAD_FILE_TYPE_FAIL("文件不是图片类型",-1007),
	UPLOAD_FILE_SIZE_0("文件大小为0",-1008),
	UPLOAD_FILEPATH_NULL("文件路径不能为空",-1009),
	
	LOGIN_FAIL("登录失败",-2000),
	USER_ERROR("账号或者密码错误",-2001),
	USER_LOCK("用户被锁定",-2002),
	USER_NBUND("用户未绑定",-2003),
	USER_REPEAT("当前用户已存在",-2004),
	PASSWORD_ERROR("用户密码错误",-2005),
	USER_WORDS_ERROR("用户名只能是数字或者英文字母",-2006),
	USER_ADDRESS_DELETE_ERROR("当前用户默认地址不能删除",-2007),
	USER_GROUP_ISUSE("当前用户组已被使用，不能删除",-2008),
	NO_LOGIN("当前用户未登录",-2009),
	USER_HEAD_GET("用户已领用过",-2010),
	NO_COUPON("来迟了，已领完",-2011),
	USER_MOBILE_REPEAT("用户手机重复",-2012),
	USER_EMAIL_REPEAT("用户邮箱重复",-2013),
	USER_GROUP_REPEAT("用户组名称重复",-2014),
	USER_WITHDRAW_NO_USE("会员提现功能未启用",-2015),
	USER_WITHDRAW_BEISHU("提现倍数不符合",-2016),
	USER_WITHDRAW_MIN("申请提现小于最低提现",-2017),
	MEMBER_LEVEL_DELETE("该等级正在使用中,不可删除",-2018),
	FULL_MAX_FETCH("领取已达到上限",-2019),
	REGISTER_CONFIG_OFF("抱歉,商城暂未开启用户注册！",-2051),
	REGISTER_MOBILE_CONFIG_OFF("抱歉,商城暂未开启用户手机注册！",-2052),
	REGISTER_EMAIL_CONFIG_OFF("抱歉,商城暂未开启用户邮箱注册！",-2053),
	REGISTER_PLAIN_CONFIG_OFF("抱歉,商城暂未开启用户普通注册！",-2054),
	REGISTER_USERNAME_ERROR("你所填的账号不符合注册规则！",-2055),
	REGISTER_PASSWORD_ERROR("你所填的密码不符合注册规则！",-2056),
	REGISTER_VALIDATENUM_ERROR("你所填的验证码错误",-2057),
	REGISTER_VALIDATENUM_OUT_TIME("你所填的验证码已过期",-2058),
	NOTFOUND_UID("没有找到UID",-2058),
	NOT_PROMOTER_USER("推荐人不存在",-2059),
	
	GOODS_NOT_FOUND("商品不存在",3001),
	
	ORDER_DELIVERY_ERROR("存在未发货订单",-4002),
	LOW_STOCKS("库存不足",-4003),
	LOW_POINT("用户积分不足",-4004),
	LOW_COIN("用户购物币不足",-4011),
	CLOSE_POINT("店铺积分功能未开启",-4010),
	ORDER_PAY("订单已支付",-4005),
	LOW_BALANCE("用户余额不足",-4006),
	ORDER_CREATE_LOW_POINT("当前用户积分不足",-4007),
	ORDER_CREATE_LOW_PLATFORM_MONEY("当前用户余额不足",-4008),
	ORDER_CREATE_LOW_USER_MONEY("当前用户店铺余额不足",-4009),
	ORDER_CASH_DELIVERY("当前地址不支持货到付款",-4014),
	NULL_EXPRESS_FEE("当前收货地址暂不支持配送！",-4012),
	NULL_EXPRESS("无货",-4013),
	NO_OPEN_POINT_PAY("积分兑换未开启",-4016),
	
	
	ACTIVE_REPRET("在同一时间段内存在相同商品的活动！",-5001),
	GOODS_HAVE_BEEN_GIFT("该商品已经是赠品了！",-5002),

	SMS_SENDERROR("短信发送失败",-6001),
	SMS_CONFIG_THREE_ISUSE("第三方短信配置未开启",-6002),
	SMS_TEMPLATE_CODE_ISENABLE("短信事件模板未启用",-6003);
	

	
	
	private String name;

	private int code;

	private ErrorMsg(String name,  int code) {
		this.name = name;
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	/**
	 * 根据code获取name
	 * @param code
	 * @return
	 */
	public static String queryCodeByName(int code) {
		for(ErrorMsg c:ErrorMsg.values()) {
			if(c.getCode() == code) {
				return c.name;
			}
		}
		return null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public static String getException(Exception e) {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			// 将出错的栈信息输出到printWriter中
			e.printStackTrace(pw);
			pw.flush();
			sw.flush();
		} finally {
			if (sw != null) {
				try {
					sw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (pw != null) {
				pw.close();
			}
		}
		
		return sw.toString();
	}

}