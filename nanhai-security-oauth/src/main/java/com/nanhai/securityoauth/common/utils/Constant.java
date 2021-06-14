package com.nanhai.securityoauth.common.utils;

/**
 * 常量
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月15日 下午1:23:52
 */
public class Constant {
	/** 超级管理员ID */
	public static final int SUPER_ADMIN = 1;

	/**
	 * 菜单类型
	 * 
	 * @author chenshun
	 * @email sunlightcs@gmail.com
	 * @date 2016年11月15日 下午1:24:29
	 */
    public enum MenuType {
        /**
         * 目录
         */
    	CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    
    /**
     * 定时任务状态
     * 
     * @author chenshun
     * @email sunlightcs@gmail.com
     * @date 2016年12月3日 上午12:07:22
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
    	NORMAL(0),
        /**
         * 暂停
         */
    	PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3);

        private int value;

        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    
    public enum Template{
    	//如何赚积分
    	EARN_POINT,
    	//服务协议
    	SERVICE_AGREEMENT,
    	//隐私政策
    	PRIVACY_POLICY,
    	//用户协议
    	USER_AGREEMENT,
    	//成为合伙人协议
    	PARTNER_AGREEMENT,
    	//积分规则
    	POINT_RULE,
    	//合伙人规则
    	PARTNER_RULE,
    	//日历帮助
    	CALENDAR_HELP;
    	
    	public static Template valueOf(int ordinal) {
    		if(ordinal < 0 || ordinal >= values().length) {
    			throw new IndexOutOfBoundsException("Invalid ordinal");
    		}
    		return values()[ordinal];
    	}
    }
    
    public enum MemberLevel{
    	//合伙人
    	合伙人,
    	//高级会员
    	高级会员,
    	//受邀会员
    	受邀会员;
    	
    	public static MemberLevel valueOf(int ordinal) {
    		if(ordinal < 0 || ordinal >= values().length) {
    			throw new IndexOutOfBoundsException("Invalid ordinal");
    		}
    		return values()[ordinal];
    	}
    }
//    public final static String IOS_QRCODE_PATH = "D:/workspace/panjin_jiudian/target/classes/static/ios/qrcode.png";
    public final static String IOS_QRCODE_PATH = "classes/static/ios/qrcode.png";
    
    public final static String IOS_QRCODE_URL_PATH = "/qrcode/ios/qrcode.png";
    
//    public final static String ANDROID_QRCODE_PATH = "D:/workspace/panjin_jiudian/target/classes/static/android/qrcode.png";
    public final static String ANDROID_QRCODE_PATH = "classes/static/android/qrcode.png";
	
    public final static String ANDROID_QRCODE_URL_PATH = "/qrcode/android/qrcode.png";
    
    public final static String BG_IMG_PATH = "/qrcode/background.png";
    
    public final static String LEVEL2TOLEVEL1 = "LEVEL2TOLEVEL1";
    
    public final static String LEVEL3TOLEVEL1 = "LEVEL3TOLEVEL1";
    
    public final static String LEVEL3TOLEVEL2 = "LEVEL3TOLEVEL2";
    //轮播图
    public final static String TURNIMGS = "TURNIMGS";
    
	public static int getWordCount(String s) {
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			int ascii = Character.codePointAt(s, i);
			if (ascii >= 0 && ascii <= 255)
				length++;
			else
				length += 2;

		}
		return length;
	}

}
