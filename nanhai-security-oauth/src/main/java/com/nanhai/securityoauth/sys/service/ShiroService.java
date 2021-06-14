package com.nanhai.securityoauth.sys.service;


import java.util.Set;


public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

}
