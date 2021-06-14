package com.nanhai.securityoauth.config;


import com.alibaba.fastjson.JSONObject;
import com.nanhai.core.framework.object.MyRestTemplate;

import com.nanhai.core.util.EmptyUtils;
import com.nanhai.securityoauth.sys.entity.SysRoleEntity;
import com.nanhai.securityoauth.sys.entity.SysUserEntity;
import com.nanhai.securityoauth.sys.service.ShiroService;
import com.nanhai.securityoauth.sys.service.SysRoleService;
import com.nanhai.securityoauth.sys.service.SysUserRoleService;
import com.nanhai.securityoauth.sys.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * 获取用户信息
 * @PackageName:org.jpa.jpaweb.config
 * @ClassName:UserDetailsService
 * @Description:
 * @author: 悟空
 * @date: 2021/4/25 21:25
 * @email: 10947@163.com
 */
@Configuration
public class UserDetailsServiceBean implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private ShiroService shiroService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    MyRestTemplate myRestTemplate;

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceBean.class);


    //将访问地址改为网关服务名称
    private static final String GATEWAY_SERVICE = "http://nanhai-zuul-gateway:8280/";


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity userDetails = sysUserService.queryByUserName(username);
        if(EmptyUtils.isNotEmpty(userDetails)){
            //TODO: 状态  0：禁用   1：正常
            if(userDetails.getStatus() == 0){
                return null;
            }else{
                Set<String> userPermissions = shiroService.getUserPermissions(userDetails.getUserId());
                userDetails.setUserPermissions(userPermissions);
                //获取用户所属的角色列表
                List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userDetails.getUserId());
                userDetails.setRoleIdList(roleIdList);
                List<SysRoleEntity> roleList = sysRoleService.selectBatchIds(roleIdList);
                userDetails.setSysRoleEntities(roleList);
                String lettersCommaSeparated = userPermissions.stream().collect(Collectors.joining(","));
                userDetails.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(lettersCommaSeparated));
                userDetails.setUsername(username);
                userDetails.isConfig();
            }
        }
        return userDetails;
    }

    public UserDetails loadUserByUsernameAndSmscode(String username,String smscode,String hash,String tamp){
        Boolean verified=sysUserService.verifyLoginSmscode(username, smscode,hash,tamp);
        if(!verified){
            return null;
        }

        SysUserEntity userDetails = sysUserService.queryByUserName(username);
        if(EmptyUtils.isNotEmpty(userDetails)){
            //TODO: 状态  0：禁用   1：正常
            if(userDetails.getStatus() == 0){
                return null;
            }else{
                Set<String> userPermissions = shiroService.getUserPermissions(userDetails.getUserId());
                userDetails.setUserPermissions(userPermissions);
                //获取用户所属的角色列表
                List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userDetails.getUserId());
                userDetails.setRoleIdList(roleIdList);
                List<SysRoleEntity> roleList = sysRoleService.selectBatchIds(roleIdList);
                userDetails.setSysRoleEntities(roleList);
                String lettersCommaSeparated = userPermissions.stream().collect(Collectors.joining(","));
                userDetails.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(lettersCommaSeparated));
                userDetails.setUsername(username);
                userDetails.isConfig();
            }
        }
        return userDetails;
    }


    
}
