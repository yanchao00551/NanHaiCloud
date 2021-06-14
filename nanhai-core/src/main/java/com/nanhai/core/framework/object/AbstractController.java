package com.nanhai.core.framework.object;

import com.alibaba.fastjson.JSON;

import org.springframework.security.core.Authentication;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @PackageName:com.nanhai.usercenter.api
 * @ClassName:AbstractController
 * @Description:
 * @author: 悟空
 * @date: 2021/5/14 15:23
 * @email: 10947@163.com
 */
public abstract class AbstractController {

    @RequestMapping(value = "/parse", method = RequestMethod.GET)
    public SsoUser parse(Authentication authentication){  //解析jwt
        OAuth2AuthenticationDetails oAuth2AuthenticationDetails=(OAuth2AuthenticationDetails) authentication.getDetails();
        String token=oAuth2AuthenticationDetails.getTokenValue();
        Jwt jwt= JwtHelper.decode(token);
        String claims=jwt.getClaims();
        String encoded=jwt.getEncoded();

        SsoUser user = new SsoUser();
        user = JSON.parseObject(claims,SsoUser.class);
        user.setToken(encoded);
        return user;
    }
}
