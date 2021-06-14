package com.nanhai.securityoauth.config;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nanhai.core.framework.object.MyRestTemplate;
import com.nanhai.securityoauth.sys.entity.SysRoleEntity;
import com.nanhai.securityoauth.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.util.JsonParser;
import org.springframework.security.oauth2.common.util.JsonParserFactory;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @PackageName:com.nanhai.securityoauth.config
 * @ClassName:MyJwtAccessTokenConverter
 * @Description:
 * @author: 悟空
 * @date: 2021/5/18 12:03
 * @email: 10947@163.com
 */
public class MyJwtAccessTokenConverter extends JwtAccessTokenConverter
{

    private AccessTokenConverter tokenConverter = new MyDefaultAccessTokenConverter();

    private JsonParser objectMapper = JsonParserFactory.create();

    private String verifierKey = "0123456789";

    private Signer signer = new MacSigner(verifierKey);



    /**
     * @param tokenConverter the tokenConverter to set
     */
    @Override
    public void setAccessTokenConverter(AccessTokenConverter tokenConverter) {
        this.tokenConverter = tokenConverter;
    }

    /**
     * @return the tokenConverter in use
     */
    @Override
    public AccessTokenConverter getAccessTokenConverter() {
        return tokenConverter;
    }

    @Override
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        return tokenConverter.convertAccessToken(token, authentication);
    }

    @Override
    public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map) {
        return tokenConverter.extractAccessToken(value, map);
    }

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        return tokenConverter.extractAuthentication(map);
    }

    @Override
    protected String encode(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        String content;
        try {
            content = objectMapper.formatMap(tokenConverter.convertAccessToken(accessToken, authentication));
        }
        catch (Exception e) {
            throw new IllegalStateException("Cannot convert access token to JSON", e);
        }
        String token = JwtHelper.encode(content, signer).getEncoded();
        return token;
    }


    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        if (accessToken instanceof DefaultOAuth2AccessToken) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof SysUserEntity) {
                SysUserEntity user = (SysUserEntity) principal;
                HashMap<String, Object> map = new HashMap<>();
                map.put("username",user.getUsername());
                map.put("userId", user.getUserId());
                map.put("userLevel",user.getUserLevel());
                map.put("administrativeCode",user.getUserAdministrativeCode());
                map.put("loginName",user.getUserLoginName());
                List<String> roleNameList = user.getSysRoleEntities().stream().map(SysRoleEntity::getRoleName).collect(Collectors.toList());
                map.put("roleList",roleNameList);
                List<String> identity = new LinkedList<>();
                if(user.getUserLevel().equals(3)){
                    identity.add("区级信息员");
                    map.put("userIdentity",identity);
                }else if(user.getUserLevel().equals(4)){
                    identity.add("镇街信息员");
                    map.put("userIdentity",identity);
                }else {
                    identity.add("村级信息员");
                    map.put("userIdentity",identity);
                }


                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(map);
            }
        }
        return super.enhance(accessToken, authentication);
    }


}
