package com.nanhai.securityoauth.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.nanhai.core.business.entity.SysRoleMenu;
import com.nanhai.core.util.EmptyUtils;
import com.nanhai.securityoauth.common.utils.*;
import com.nanhai.securityoauth.common.validator.ValidatorUtils;
import com.nanhai.securityoauth.sys.entity.*;
import com.nanhai.securityoauth.sys.form.ValidateForm;
import com.nanhai.securityoauth.sys.form.ValidateMsgForm;
import com.nanhai.securityoauth.sys.service.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private MemberService memberService;
    @Autowired
    private AdministrativeAreaService administrativeAreaService;
    @Autowired
    private SysCaptchaService sysCaptchaService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Autowired
    private Producer producer;


    public static final String KEY = "abc123"; // KEY为自定义秘钥


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/testrole")
    public String testrole() {
        return "角色ROLE_ADMIN 可以查看";
    }



    /**
     * 重置密码或修改手机号码
     * @author 悟空
     * @description //TODO
     * @date 11:38 2021/6/3
     * @param
     * @return com.nanhai.securityoauth.common.utils.R
     */
    @PostMapping(value = {"/resetPasswd"})
    public R resetPasswd(ValidateForm form){
        // 表单校验
        ValidatorUtils.validateEntity(form);
        String requestHash = form.getHash();
        String tamp = form.getTamp();
        String msgNum = form.getMsgNum();
        String hash = Md5Utils.hash(KEY + "@" + tamp + "@" + msgNum);
        String mobile = form.getMobile();
        String password = form.getPassword();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(); // 获取当前时间
        String currentTime = sf.format(date);

        if (tamp.compareTo(currentTime) > 0) {
            if (hash.equalsIgnoreCase(requestHash)) {
                // 校验成功
                Map<String, Object> map = new HashMap<>();
                map.put("username", mobile);
                List<SysUserEntity> isUser = sysUserService.selectByMap(map);
                if(!isUser.isEmpty() && form.getType() == 1){
                    SysUserEntity user1 = isUser.get(0);
                    if (password != null) {
                        user1.setPassword(passwordEncoder.encode(password));
                    }
                    sysUserService.updateById(user1);
                }else if(!isUser.isEmpty() && form.getType() == 2){
                    SysUserEntity user1 = isUser.get(0);
                    if(mobile != null){
                        user1.setMobile(mobile);
                    }
                    sysUserService.updateById(user1);
                }
            }else{
                //TODO: 验证码不正确，校验失败
                return R.error(ErrorMsg.REGISTER_VALIDATENUM_ERROR.getCode(),
                        ErrorMsg.REGISTER_VALIDATENUM_ERROR.getName());
            }
        }else{
            //TODO: 超时
            return R.error(ErrorMsg.REGISTER_VALIDATENUM_OUT_TIME.getCode(),
                    ErrorMsg.REGISTER_VALIDATENUM_OUT_TIME.getName());
        }
        return R.ok();
    }

    /**
     * 前台用户注册接口
     * @author 悟空
     * @description //TODO
     * @date 8:47 2021/5/25
     * @param form
     * @return com.nanhai.securityoauth.common.utils.R
     */
    @PostMapping(value = {"/register"})
    public R register(ValidateMsgForm form){
        // 表单校验
        ValidatorUtils.validateEntity(form);
        String requestHash = form.getHash();
        String tamp = form.getTamp();
        String msgNum = form.getMsgNum();
        String mobile = form.getMobile();
        String hash = Md5Utils.hash(KEY + "@" + tamp + "@" + msgNum + "@" +mobile);
        String password = form.getPassword();
        String areaCode = form.getUserAdministrativeCode();
        String realName = form.getRealName();
        String email = form.getEmail();
        String idCard = form.getRegisterCard();
        String registerMemo=form.getRegisterMemo();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(); // 获取当前时间
        String currentTime = sf.format(date);

        //TODO: 根据行政编码确定用户等级
        Wrapper<NhAdministrativeArea> wrapper = new EntityWrapper<NhAdministrativeArea>().eq("administrative_code", form.getUserAdministrativeCode());
        NhAdministrativeArea nhAdministrativeArea = administrativeAreaService.selectOne(wrapper);
        if(EmptyUtils.isEmpty(nhAdministrativeArea)){
            return R.error(ErrorMsg.USER_NBUND.getCode(),
                    ErrorMsg.USER_NBUND.getName());
        }

        Long userId = 0L;
        if (tamp.compareTo(currentTime) > 0) {
            if (hash.equalsIgnoreCase(requestHash)) {
                // 校验成功
                Map<String, Object> map = new HashMap<>();
                map.put("username", mobile);
                List<SysUserEntity> isUser = sysUserService.selectByMap(map);
                if(isUser.isEmpty()){
                    SysUserEntity sysUserEntity = new SysUserEntity();
                    sysUserEntity.setMobile(mobile);
                    sysUserEntity.setUsername(mobile);
                    if(password != null && !password.equals("")){
                        sysUserEntity.setPassword(passwordEncoder.encode(password));
                    }else{
                        //TODO: 注册密码默认手机号
                        sysUserEntity.setPassword(passwordEncoder.encode(mobile));
                    }
                    sysUserEntity.setCreateTime(date);
                    sysUserEntity.setUserAdministrativeCode(areaCode);
                    sysUserEntity.setRealName(realName);
                    sysUserEntity.setStatus(0);
                    sysUserEntity.setEmail(email);
                    sysUserEntity.setUserLoginName(mobile);
                    sysUserEntity.setOrganId(0L);
                    sysUserService.insert(sysUserEntity);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    NhUsers nhUsers = new NhUsers();
                    userId = sysUserEntity.getUserId();


                    List<SysRoleEntity> sysRoleEntities = sysRoleService.selectList(null);
                    SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
                    sysUserRoleEntity.setUserId(userId);
                    sysUserRoleEntity.setRoleId(sysRoleEntities.get(0).getRoleId());
                    sysUserRoleService.insert(sysUserRoleEntity);
                    SysRoleMenuEntity menuEntity = new SysRoleMenuEntity();
                    menuEntity.setMenuId(-666666L);
                    menuEntity.setRoleId(sysRoleEntities.get(0).getRoleId());
                    sysRoleMenuService.insert(menuEntity);



                    nhUsers.setUserId(userId);
                    nhUsers.setUserLevel(nhAdministrativeArea.getAdministrativeLevel());
                    nhUsers.setUserLoginName(mobile);
                    nhUsers.setUserAdministrativeCode(areaCode);
                    nhUsers.setRegisterCard(idCard);
                    nhUsers.setRegisterAuditStatus(0);
                    nhUsers.setRegisterMemo(registerMemo);
                    nhUsers.setOrganId(0L);
                    memberService.insert(nhUsers);
                    return R.ok("注册用户成功");

                }else{
                    if(form.getType() == 0) {
                        return R.error("该手机号码已经注册");
                    }
                    userId = isUser.get(0).getUserId();
                    SysUserEntity user1 = isUser.get(0);
                    if (password != null) {
                        user1.setPassword(DigestUtils.sha256Hex(password));
                    }
                    sysUserService.updateById(user1);
                }
            } else{
                //TODO: 验证码不正确，校验失败
                return R.error(ErrorMsg.REGISTER_VALIDATENUM_ERROR.getCode(),
                        ErrorMsg.REGISTER_VALIDATENUM_ERROR.getName());
            }
        }else{
            //TODO: 超时
            return R.error(ErrorMsg.REGISTER_VALIDATENUM_OUT_TIME.getCode(),
                    ErrorMsg.REGISTER_VALIDATENUM_OUT_TIME.getName());
        }

        return R.ok();
    }


    /**
     * 获取验证码
     * @author 悟空
     * @description //TODO
     * @date 16:37 2021/5/27
     * @param form
     * @param request
     * @return com.nanhai.securityoauth.common.utils.R
     */
    @PostMapping("sendMsg")
    public R sendMsg(SendMsgForm form, HttpServletRequest request) {
        // 表单校验
        ValidatorUtils.validateEntity(form);
        if(StringUtils.isEmpty(form.getSendType())) {
            return R.error("必须填写发送方式");
        }

        String randomNum = RandomStringUtils.randomNumeric(6);
        // 生成随机数
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, 5);
        String currentTime = sf.format(c.getTime());// 生成5分钟后时间，用户校验是否过期

        String hash = Md5Utils.hash(KEY + "@" + currentTime + "@" + randomNum + "@" + form.getMobile());// 生成MD5值
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("hash", hash);
        resultMap.put("tamp", currentTime);
        resultMap.put("validateNum", randomNum);


        //TODO: 需账号验证后
        if(form.getSendType().equals(2)){
            Wrapper<SysUserEntity> wrapper = new EntityWrapper<>();
            wrapper.eq("username",form.getMobile());
            SysUserEntity sysUserEntity = sysUserService.selectOne(wrapper);
            if(sysUserEntity == null){
                return R.error("该账号不存在！");
            }else if(sysUserEntity.getStatus().equals(0)){
                return R.error("该账号已被管理员禁用!");
            }else{
                return R.ok(resultMap);
            }
        }

        return R.ok(resultMap);
    }



    /**
     * 获取认证用户相关信息的端点
     *
     * @param user
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author 悟空
     * @description //TODO
     * @date 21:38 2021/4/22
     */
    @RequestMapping(value = {"/info"}, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(
                user.getAuthorities()
        ));
        return userInfo;

    }


}
