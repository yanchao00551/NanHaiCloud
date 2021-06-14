package com.nanhai.securityoauth.config;

import com.nanhai.securityoauth.sys.entity.SysUserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.security.oauth2.common.OAuth2AccessToken.SCOPE;
import static org.springframework.security.oauth2.common.util.OAuth2Utils.CLIENT_ID;
import static org.springframework.security.oauth2.common.util.OAuth2Utils.GRANT_TYPE;
import static org.springframework.security.oauth2.provider.token.AccessTokenConverter.*;

/**
 * @PackageName:com.nanhai.securityoauth.config
 * @ClassName:MyUserAuthenticationConverter
 * @Description:
 * @author: 悟空
 * @date: 2021/5/18 12:06
 * @email: 10947@163.com
 */
public class MyDefaultAccessTokenConverter extends DefaultAccessTokenConverter {

    private boolean includeGrantType;

    private String scopeAttribute = SCOPE;

    private String clientIdAttribute = CLIENT_ID;

    private MyUserAuthenticationConverter userTokenConverter = new MyUserAuthenticationConverter();


    @Override
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        Map<String, Object> response = new HashMap<String, Object>();
        OAuth2Request clientToken = authentication.getOAuth2Request();

        if (!authentication.isClientOnly()) {
            response.putAll(userTokenConverter.convertUserAuthentication(authentication.getUserAuthentication()));
        } else {
            if (clientToken.getAuthorities() != null && !clientToken.getAuthorities().isEmpty()) {
                response.put(MyUserAuthenticationConverter.AUTHORITIES,
                        AuthorityUtils.authorityListToSet(clientToken.getAuthorities()));
            }
        }

        if (token.getScope() != null) {
            response.put(scopeAttribute, token.getScope());
        }
        if (token.getAdditionalInformation().containsKey(JTI)) {
            response.put(JTI, token.getAdditionalInformation().get(JTI));
        }

        if (token.getExpiration() != null) {
            response.put(EXP, token.getExpiration().getTime() / 1000);
        }

        if (includeGrantType && authentication.getOAuth2Request().getGrantType() != null) {
            response.put(GRANT_TYPE, authentication.getOAuth2Request().getGrantType());
        }

        response.putAll(token.getAdditionalInformation());

        response.put(clientIdAttribute, clientToken.getClientId());
        if (clientToken.getResourceIds() != null && !clientToken.getResourceIds().isEmpty()) {
            response.put(AUD, clientToken.getResourceIds());
        }
        return response;
    }
}