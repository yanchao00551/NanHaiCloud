package com.nanhai.modules.sys.controller;


import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SysUser;
import com.nanhai.core.business.vo.SysUserConditionVO;
import com.nanhai.core.framework.object.AbstractController;
import com.nanhai.core.framework.object.SsoUser;
import com.nanhai.core.util.R;
import com.nanhai.modules.sys.service.NhSysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/sysuser")
public class SysUserController extends AbstractController {
    @Autowired
    private NhSysUserService userService;




    @GetMapping(value = {"/list"})
    public R list(SysUserConditionVO vo){
        PageInfo<SysUser> pageInfo = userService.findPageBreakByCondition(vo);
        return R.ok().put("data", pageInfo);
    }

    @PostMapping(value = {"/save"})
    @Transactional(rollbackFor = Exception.class)
    public R save(SysUserConditionVO vo, Authentication authentication){
        SsoUser user = parse(authentication);
        //TODO: 色划定：若选"全部镇街"则为"区级信息员"  若选某个镇街，选“全部村居"，则为"镇街信息员" 若选某个村居，则为"村居信息员"
        vo.setCreateUserId(user.getUserId());
        Boolean rsp = userService.register(vo);

        if(!rsp){
            return R.error(-99999,"该用户名已经被其他用户注册！").put("result","fail");
        }
        return R.ok().put("data",rsp);
    }

    @PostMapping(value = {"/update"})
    @Transactional(rollbackFor = Exception.class)
    public R update(SysUserConditionVO vo, Authentication authentication){
        SsoUser user = parse(authentication);
        Boolean rsp = userService.updateUserInfo(vo);
        return R.ok();
    }



    @PostMapping(value = {"/delete"})
    public R delete(Long[] userIds, Authentication authentication){
        if(ArrayUtils.contains(userIds,1L)){
            return R.error("系统管理员不能删除");
        }
        SsoUser user = parse(authentication);
        if(ArrayUtils.contains(userIds,user.getUserId())){
            return R.error("当前用户不能删除");
        }
        userService.deleteBatch(userIds);
        return R.ok();
    }


    /**
     * 注册申请审核
     * @author 悟空
     * @description //TODO
     * @date 16:12 2021/5/28
     * @param userIds
     * @return com.nanhai.core.util.R
     */
    @PostMapping(value = {"/regAuditStatus"})
    public R regAuditStatus(Long[] userIds){
        //批量审核
        userService.auditBatch(userIds);
        return R.ok();
    }

    /**
     * 修改用户头像
     * @author 悟空
     * @description //TODO
     * @date 16:26 2021/6/3
     * @param headImg
     * @param authentication
     * @return com.nanhai.core.util.R
     */
    @PostMapping(value = {"/updateCurrentHead"})
    public R updateUserHead(String[] headImg,Authentication authentication){
        SsoUser parse = parse(authentication);
        userService.updateHead(headImg,parse.getUserId());
        return R.ok();
    }

    @GetMapping(value = {"/getCurrentUserInfo"})
    public R getCurrentUserInfo(Authentication authentication){
        SsoUser parse = parse(authentication);
        SysUser sysUser = userService.getUserDetail(parse.getUserId());
        return R.ok().put("data",sysUser);
    }



}

