package com.nanhai.core.framework.object;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @PackageName:com.nanhai.usercenter.api
 * @ClassName:SsoToken
 * @Description:
 * @author: 悟空
 * @date: 2021/5/14 15:05
 * @email: 10947@163.com
 */
@Data
@ToString
public class SsoUser implements Serializable {
    private static final long serialVersionUID = -6957361951748382519L;
    private String exp;
    private String username;
    private Integer userLevel;
    private String administrativeCode;
    private Long userId;
    private String loginName;
    private List<String> userIdentity;
    private List<String> authorities;
    private String jti;
    private String client_id;
    private List<String> scope;
    private String token;
}
