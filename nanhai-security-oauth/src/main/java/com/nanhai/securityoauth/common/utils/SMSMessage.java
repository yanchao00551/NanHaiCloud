package com.nanhai.securityoauth.common.utils;

import net.sf.json.JSONObject;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SMSMessage {
	
//	public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

	public static boolean mobileQuery(String mobile,String tplId, Map<String, String> tplMap) {
		boolean res = true;
		String result = null;
		try {
			Map<String, String> params = new HashMap<String, String>();// 请求参数
			params.put("mobile", mobile);// 接受短信的用户手机号码
			params.put("tpl_id", tplId);// 您申请的短信模板ID，根据实际情况修改
			params.put("tpl_value", generateTplValue(tplMap));// 您设置的模板变量，根据实际情况修改
			params.put("key", SMSConfig.APP_KEY);// 应用APPKEY(应用详细页查询)
			result = net(SMSConfig.SMS_URL, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				System.out.println(object.get("result"));
			} else {
				System.out.println(object.get("error_code") + ":" + object.get("reason"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}
	
	private static String generateTplValue(Map<String, String> tplMap)
			throws OptionalDataException, ClassNotFoundException, IOException {
		StringBuffer stringBuffer = new StringBuffer();
		Iterator<Entry<String, String>> iterator = tplMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> et = iterator.next();
			if(!StringUtils.isEmpty(stringBuffer.toString())) {
				stringBuffer.append("&");
			}
			stringBuffer.append(et.getKey() + "=" + et.getValue());
		}
		return URLEncoder.encode(stringBuffer.toString(), "UTF-8");
	}

	/**
	 *
	 * @param strUrl 请求地址
	 * @param params 请求参数
	 * @param method 请求方法
	 * @return 网络请求字符串
	 * @throws Exception
	 */
	public static String net(String strUrl, Map<String, String> params, String method) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			if (method == null || method.equals("GET")) {
				strUrl = strUrl + "?" + urlencode(params);
			}
			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			if (method == null || method.equals("GET")) {
				conn.setRequestMethod("GET");
			} else {
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}
//			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(SMSConfig.DEF_CONN_TIMEOUT);
			conn.setReadTimeout(SMSConfig.DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			if (params != null && method.equals("POST")) {
				try {
					DataOutputStream out = new DataOutputStream(conn.getOutputStream());
					out.writeBytes(urlencode(params));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, SMSConfig.DEF_CHATSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}

	// 将map型转为请求参数型
	public static String urlencode(Map<String, String> data) {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, String> i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
