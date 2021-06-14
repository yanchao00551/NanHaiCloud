package com.nanhai.securityoauth.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nanhai.securityoauth.sys.dao.MemberDao;
import com.nanhai.securityoauth.sys.dao.SysRoleDao;
import com.nanhai.securityoauth.sys.entity.NhUsers;
import com.nanhai.securityoauth.sys.entity.SysRoleEntity;
import com.nanhai.securityoauth.sys.service.MemberService;
import com.nanhai.securityoauth.sys.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * @PackageName:com.nanhai.securityoauth.sys.service.impl
 * @ClassName:MemberServiceImpl
 * @Description:
 * @author: 悟空
 * @date: 2021/5/25 8:37
 * @email: 10947@163.com
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberDao, NhUsers> implements MemberService {

}
