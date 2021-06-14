package com.nanhai.modules.sys.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SysUser;
import com.nanhai.core.business.entity.Users;
import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.core.business.vo.SysUserConditionVO;
import com.nanhai.core.framework.object.MyRestTemplate;
import com.nanhai.core.persistence.beans.*;
import com.nanhai.core.util.EmptyUtils;
import com.nanhai.modules.sys.mapper.*;
import com.nanhai.modules.sys.service.NhSysRoleService;
import com.nanhai.modules.sys.service.NhSysUserRoleService;
import com.nanhai.modules.sys.service.NhSysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 系统用户
 */
@Service
@Slf4j
public class NhSysUserServiceImpl implements NhSysUserService {

    @Autowired
    private NhSysUserMapper sysUserMapper;
    @Autowired
    private NhSysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private NhSysRoleMapper sysRoleMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private NhUsersMapper nhUsersMapper;
    @Autowired
    private NhOrganMapper organMapper;
    @Autowired
    private MyRestTemplate myRestTemplate;

    private static final String GATEWAY_SERVICE = "http://nanhai-zuul-gateway:8280/";



    private List<String> treeDataCode(List<String> parentCodeList,Long parentId,String code){
        List<String> parentCode = null;
        if(parentCodeList == null){
            parentCode = new LinkedList<>();
            parentCode.add(code);
        }else{
            parentCode = parentCodeList;
        }
        NhOrgan nhOrgan = organMapper.selectByPrimaryKey(parentId);
        if(nhOrgan != null && EmptyUtils.isNotEmpty(nhOrgan)){
            parentCode.add(nhOrgan.getOrganCode());
            treeDataCode(parentCode,nhOrgan.getOrganParent(),nhOrgan.getOrganCode());
        }
        return parentCode;
    }

    @Override
    public PageInfo<SysUser> findPageBreakByCondition(SysUserConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<NhSysUser> list = sysUserMapper.findPageBreakByCondition(vo);
        List<SysUser> boList = new LinkedList<>();


        List<Long> ids = list.stream().map(NhSysUser::getUserId).collect(Collectors.toList());
        if (ids.size() > 0) {
            list.stream().forEach((item) -> {
                item.setParentCode(treeDataCode(null,item.getOrganParent(),item.getOrganCode()));
            });


            List<NhSysUserRole> sysUserRoles = sysUserRoleMapper.selectInUserId(ids);
            Map<Long, NhSysUserRole> userRoleMap = sysUserRoles.stream().collect(Collectors.toMap(NhSysUserRole::getId, a -> a, (k1, k2) -> k1));
            log.info("userRoleMap:{}", userRoleMap);
            Set<Map.Entry<Long, NhSysUserRole>> entries = userRoleMap.entrySet();
            Iterator<Map.Entry<Long, NhSysUserRole>> itr = entries.iterator();
            List<Long> roleIds = new LinkedList<>();
            while (itr.hasNext()) {
                Map.Entry<Long, NhSysUserRole> next = itr.next();
                list.stream().forEach((item) -> {
                    if (next.getValue().getUserId().equals(item.getUserId())) {
                        roleIds.add(next.getValue().getRoleId());
                        item.setRoleIds(roleIds);
                        Example example = new Example(NhSysRole.class);
                        example.createCriteria().andIn("roleId", roleIds);
                        List<NhSysRole> nhSysRoles = sysRoleMapper.selectByExample(example);
                        item.setRoles(nhSysRoles);
                    }
                });
            }

            log.info("roleIds:{}", roleIds);

            for(NhSysUser item:list){
                boList.add(new SysUser(item));
            }

            PageInfo bean = new PageInfo<NhSysUser>(list);
            bean.setList(boList);
            return bean;
        } else {
            boList = null;
        }

        //指定返回的分页数据格式
        PageInfo bean = new PageInfo<NhSysUser>(list);
        bean.setList(boList);
        return bean;
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return null;
    }

    @Override
    public NhSysUser queryByUserName(String username) {
        return null;
    }

    @Override
    public Integer updatePassword(Long userId, String password, String newPassword) {
        return null;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(SysUserConditionVO vo) {
        Assert.notNull(vo.getSysUser().getUsername(), "username不可为空！");
        Assert.notNull(vo.getSysUser().getPassword(), "password不可为空！");
        SysUser sysUser = vo.getSysUser();
        Users users = vo.getUsers();

        NhSysUser nhSysUser = new NhSysUser();
        nhSysUser.setUsername(sysUser.getUsername());
        NhSysUser user = sysUserMapper.selectOne(nhSysUser);

        if (EmptyUtils.isEmpty(user)) {

            //TODO: 密码加密
            String password = sysUser.getPassword().trim();
            String encodePwd = passwordEncoder.encode(password);

            //TODO: 设用户主表信息
            Example example = new Example(NhOrgan.class);
            example.createCriteria().andEqualTo("organCode",vo.getOrganCode());
            NhOrgan nhOrgan = organMapper.selectOneByExample(example);
            sysUser.setOrganId(nhOrgan.getId());
            sysUser.setPassword(encodePwd);
            sysUser.setMobile(vo.getRegisterTele());
            //TODO: 后台添加用户默认为1，不用审核
            sysUser.setStatus(1);
            sysUser.setUserLevel(Integer.parseInt(vo.getAdministrativeLevel()));
            sysUser.setUserLoginName(sysUser.getUsername());
            sysUser.setCreateTime(new Date());
            sysUser.setUserAdministrativeCode(vo.getAdministrativeCode());
            sysUser.setRealName(vo.getRealName());

            //TODO: 插入用户附表
            //得到插入后的主键id
            log.info("待插入用户主表信息：{}", sysUser.getNhSysUser());
            int regId = sysUserMapper.insertSelective(sysUser.getNhSysUser());
            if (regId > 0) {
                //TODO:设值用户角色关系表
                Long insertId = sysUser.getNhSysUser().getUserId();
                log.info("insertId:{}", insertId);

                //TODO:设值附表
                users.setOrganId(nhOrgan.getId());
                users.setUserLoginName(vo.getUsername());
                users.setUserAdministrativeCode(vo.getAdministrativeCode());
                users.setUserLevel(Integer.parseInt(vo.getAdministrativeLevel()));
                users.setRegisterCard(vo.getRegisterCard());
                users.setUserId(insertId);
                users.setUserName(sysUser.getUsername());
                users.setRegisterTele(vo.getRegisterTele());
                users.setCreateTime(new Date());
                nhUsersMapper.insertSelective(users.getNhUsers());


                //TODO: 插入用户角色关系
                if (EmptyUtils.isNotEmpty(vo.getIds())) {
                    for (Long item : vo.getIds()) {
                        NhSysUserRole userRole = new NhSysUserRole();
                        userRole.setUserId(insertId);
                        userRole.setRoleId(item);
                        userRole.setCreateTime(new Date());
                        sysUserRoleMapper.insertSelective(userRole);
                    }
                }


                log.info("操作完成");
            } else {
                return false;
            }
        } else {
            return false;
        }

        //TODO: 插入用户详情
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateUserInfo(SysUserConditionVO vo) {
        Assert.notNull(vo.getSysUser().getUsername(), "username不可为空！");
        Assert.notNull(vo.getSysUser().getPassword(), "password不可为空！");
        SysUser sysUser = vo.getSysUser();
        Users users = vo.getUsers();

        NhSysUser nhSysUser = new NhSysUser();
        nhSysUser.setUserId(vo.getUserId());
        NhSysUser user = sysUserMapper.selectOne(nhSysUser);

        if (EmptyUtils.isNotEmpty(user)) {

            //TODO: 重新构建用户角色关系
            NhSysUserRole userRole = new NhSysUserRole();
            userRole.setUserId(user.getUserId());
            sysUserRoleMapper.delete(userRole);
            if (EmptyUtils.isNotEmpty(vo.getIds())) {
                for (Long item : vo.getIds()) {
                    NhSysUserRole userRole1 = new NhSysUserRole();
                    userRole1.setUserId(user.getUserId());
                    userRole1.setRoleId(item);
                    userRole1.setUpdateTime(new Date());
                    sysUserRoleMapper.insertSelective(userRole1);
                }
            }


            //TODO: 密码加密
            String password = vo.getPassword().trim();
            String encodePwd;
            if(!password.isEmpty() && password != null){
                encodePwd = passwordEncoder.encode(password);
                user.setPassword(encodePwd);
            }


            //TODO: 设用户主表信息
            Example example = new Example(NhOrgan.class);
            example.createCriteria().andEqualTo("organCode",vo.getOrganCode());
            NhOrgan nhOrgan = organMapper.selectOneByExample(example);
            user.setOrganId(nhOrgan.getId());
            user.setMobile(vo.getRegisterTele());
            user.setUserLevel(Integer.parseInt(vo.getAdministrativeLevel()));
            user.setUsername(vo.getUsername());
            user.setUserLoginName(vo.getUsername());
            user.setUpdateTime(new Date());
            user.setUserAdministrativeCode(vo.getAdministrativeCode());
            user.setRealName(vo.getRealName());
            user.setUpdateTime(new Date());

            //TODO: 用户附表
            //得到修改后的值
            int i = sysUserMapper.updateByPrimaryKeySelective(user);
            if (i > 0) {


                //TODO:设值附表
                NhUsers s = new NhUsers();
                s.setUserId(user.getUserId());
                NhUsers nhUsers = nhUsersMapper.selectOne(s);
                users.setId(nhUsers.getId());
                users.setOrganId(nhOrgan.getId());
                users.setUserLoginName(vo.getUsername());
                users.setUserAdministrativeCode(vo.getAdministrativeCode());
                users.setUserLevel(Integer.parseInt(vo.getAdministrativeLevel()));
                users.setRegisterCard(vo.getRegisterCard());
                users.setUserName(user.getUsername());
                users.setRegisterTele(vo.getRegisterTele());
                users.setUpdateTime(new Date());
                nhUsersMapper.updateByPrimaryKeySelective(users.getNhUsers());


                log.info("修改操作完成");
            }
        } else {
            return false;
        }

        //TODO: 修改用户详情
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] userIds) {
        Example example = new Example(NhSysUser.class);
        example.createCriteria().andIn("userId", Arrays.asList(userIds));
        sysUserMapper.deleteByExample(example);
        Example example1 = new Example(NhUsers.class);
        example1.createCriteria().andIn("userId", Arrays.asList(userIds));
        nhUsersMapper.deleteByExample(example1);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void auditBatch(Long[] userIds) {
        Example example = new Example(NhSysUser.class);
        example.createCriteria().andIn("userId", Arrays.asList(userIds));
        List<NhSysUser> nhSysUsers = sysUserMapper.selectByExample(example);
        nhSysUsers.stream().forEach((value) -> {
            value.setStatus(1);
            sysUserMapper.updateByPrimaryKeySelective(value);
        });
    }

    @Override
    public void updateHead(String[] headImg, Long userId) {
        //TODO:  修改用户头像，考虑一个用户多个头像
        Example example = new Example(NhUsers.class);
        example.createCriteria().andEqualTo("userId",userId);
        NhUsers nhUsers = nhUsersMapper.selectOneByExample(example);
        if(nhUsers != null){
            nhUsers.setUserHead(StringUtils.join(headImg,","));
            nhUsersMapper.updateByPrimaryKeySelective(nhUsers);
        }
    }

    @Override
    public SysUser getUserDetail(Long userId) {
        NhSysUser nhSysUser = sysUserMapper.selectUserDetail(userId);
        List<Long> userIds = new ArrayList<>();
        userIds.add(userId);
        List<NhSysUserRole> sysUserRoles = sysUserRoleMapper.selectInUserId(userIds);
        List<Long> roleIds = sysUserRoles.stream().map(NhSysUserRole::getRoleId).collect(Collectors.toList());
        Example example = new Example(NhSysRole.class);
        example.createCriteria().andIn("roleId",roleIds);
        List<NhSysRole> nhSysRoles = sysRoleMapper.selectByExample(example);
        nhSysUser.setRoles(nhSysRoles);
        if(nhSysUser.getUserLevel() == 3){
            nhSysUser.setUserIdenty("区级管理员");
        }else if(nhSysUser.getUserLevel() == 4){
            nhSysUser.setUserIdenty("镇街管理员");
        }else {
            nhSysUser.setUserIdenty("村级信息员");
        }
        String imgs;
        if(nhSysUser.getUserHead() != null && nhSysUser.getUserHead() != ""){
            imgs = myRestTemplate.getForObject(GATEWAY_SERVICE + "/oss/file/getList?pictureIds=" + nhSysUser.getUserHead(), String.class);
            JSONObject j1 = JSONObject.parseObject(imgs);
            nhSysUser.setUserHeadImgs(j1.getJSONArray("data"));
        }
        return new SysUser(nhSysUser);
    }

    @Override
    public SysUser insert(SysUser entity) {
        return null;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(SysUser entity) {
        return false;
    }


    @Override
    public SysUser getByPrimaryKey(Long primaryKey) {
        return null;
    }
}
