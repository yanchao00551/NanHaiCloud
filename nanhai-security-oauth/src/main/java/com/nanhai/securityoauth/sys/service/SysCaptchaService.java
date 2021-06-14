
package com.nanhai.securityoauth.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.nanhai.securityoauth.sys.entity.SysCaptchaEntity;

import java.awt.image.BufferedImage;

/**
 * 验证码
 * @author 悟空
 * @description //TODO
 * @date 15:31 2021/5/27
 * @param null
 * @return null
 */
public interface SysCaptchaService extends IService<SysCaptchaEntity> {

    /**
     * 获取图片验证码
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码效验
     * @param uuid  uuid
     * @param code  验证码
     * @return  true：成功  false：失败
     */
    boolean validate(String uuid, String code);
}
