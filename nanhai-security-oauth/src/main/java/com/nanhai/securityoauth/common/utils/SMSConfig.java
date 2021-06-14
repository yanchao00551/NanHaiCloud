package com.nanhai.securityoauth.common.utils;

import java.util.HashMap;
import java.util.Map;

public class SMSConfig {
	//短信接口URL
	public final static String SMS_URL = "http://v.juhe.cn/sms/send";
	//默认编码格式
	public static final String DEF_CHATSET = "UTF-8";
	//连接超时时间
	public static final int DEF_CONN_TIMEOUT = 30000;
	//读取超时时间
	public static final int DEF_READ_TIMEOUT = 30000;
	
//	private static Map<ID_GROUP,String> map = new HashMap<ID_GROUP,String>();
	
	public static Map<String, String> SMS_CODE_TPL = new HashMap<String, String>();
	
	//验证码
	public final static String KEY_CODE = "#code#";
	//用户昵称
	public final static String KEY_NICKNAME = "#nickName#";
	//用户联系电话
	public final static String KEY_MOBILE = "#mobile#";
	//商品详情
	public final static String KEY_GOODS_DETAIL = "#goodsDetail#";
	//用户支付订单时间
	public final static String KEY_DATETIME = "#dateTime#";
	//订单号
	public final static String KEY_ORDERNO = "#orderNo#";
	//有效期
	public final static String KEY_MINUTE = "#m#";
	//验证码模板ID
	public final static String TPL_CODE = "112363";
	//订单模板ID
	public final static String TPL_ORDER = "113499";
	//短信服务appkey
	public final static String APP_KEY = "0bec857bc42fff074980f5dc619f8aba";
	
	public final static int SEND_INTERVALS = 50; //短信发送间隔（s）
	
	public final static int MAX_TIMES = 5; //短信当天发送最大数量
	
//	static {
//		map.put(ID_GROUP.OUTER_TPL, "1");
//		map.put(ID_GROUP.INNER_TPL, "2");
//		
//		SMS_CODE_TPL.put(KEY_CODE, "");
//		SMS_CODE_TPL.put(KEY_NICKNAME, "");
//		SMS_CODE_TPL.put(KEY_MOBILE, "");
//		SMS_CODE_TPL.put(KEY_DATETIME, "");
//		SMS_CODE_TPL.put(KEY_ORDERNO, "");
//	}
//	
//	public enum TPL_GROUP{
//		VERIFICATION_CODE,//验证码短信
//		ORDER_REMIND;
//	}
//	
//	public enum ID_GROUP{
//		OUTER_TPL,
//		INNER_TPL;
//	}
	
//	public static Object getCodeClone() throws IOException, OptionalDataException, ClassNotFoundException {
//		// 将对象写到流里
//		ByteArrayOutputStream bo = new ByteArrayOutputStream();
//		ObjectOutputStream oo = new ObjectOutputStream(bo);
//		oo.writeObject(SMS_CODE_TPL);
//		// 从流里读出来
//		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
//		ObjectInputStream oi = new ObjectInputStream(bi);
//		return (oi.readObject());
//	}
}
