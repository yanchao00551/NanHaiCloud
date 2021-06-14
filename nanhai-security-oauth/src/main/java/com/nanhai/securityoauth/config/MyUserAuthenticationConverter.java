package com.nanhai.securityoauth.config;

import com.nanhai.securityoauth.sys.entity.SysUserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @PackageName:com.nanhai.securityoauth.config
 * @ClassName:MyUserAuthenticationConverter
 * @Description:
 * @author: 悟空
 * @date: 2021/5/18 12:12
 * @email: 10947@163.com
 */
public class MyUserAuthenticationConverter implements UserAuthenticationConverter {

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        LinkedHashMap response = new LinkedHashMap();
        response.put("username", ((SysUserEntity) authentication.getPrincipal()).getUsername());
        if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
            response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
        }
        return response;
    }

    @Override
    public org.springframework.security.core.Authentication extractAuthentication(Map<String, ?> map) {
        return null;
    }
}
