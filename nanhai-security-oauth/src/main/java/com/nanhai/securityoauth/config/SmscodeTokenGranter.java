package com.nanhai.securityoauth.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.Map;

/**
 * @PackageName:com.nanhai.securityoauth.config
 * @ClassName:SmscodeTokenGranter
 * @Description:
 * @author: 悟空
 * @date: 2021/6/4 11:18
 * @email: 10947@163.com
 */
public class SmscodeTokenGranter extends AbstractTokenGranter {

    private static final String GRANT_TYPE = "sms_code";

    protected UserDetailsServiceBean userDetailsService;

    private OAuth2RequestFactory requestFactory;

    public SmscodeTokenGranter(UserDetailsServiceBean userDetailsService,
                               AuthorizationServerTokenServices tokenServices,
                               ClientDetailsService clientDetailsService,
                               OAuth2RequestFactory requestFactory) {
        super(tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);
        this.userDetailsService = userDetailsService;
        this.requestFactory = requestFactory;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> parameters = tokenRequest.getRequestParameters();
        UserDetails user = this.getUser(parameters);
        if (user == null) {
            throw new InvalidGrantException("无法获取用户信息");
        }
        OAuth2Request storedOAuth2Request = this.requestFactory.createOAuth2Request(client, tokenRequest);
        PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(user, null, user.getAuthorities());
        authentication.setDetails(user);
        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(storedOAuth2Request, authentication);
        return oAuth2Authentication;
    }

    private UserDetails getUser(Map<String, String> params) {
        return userDetailsService.loadUserByUsernameAndSmscode(params.get("username"), params.get("smscode"),params.get("hash"),params.get("tamp"));
    }
}
