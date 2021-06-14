package com.nanhai.core.business.entity;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhSysRole;
import com.nanhai.core.persistence.beans.NhSysUser;
import lombok.experimental.Delegate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @PackageName:com.nanhai.core.business.entity
 * @ClassName:SysUser
 * @Description:
 * @author: 悟空
 * @date: 2021/5/19 17:51
 * @email: 10947@163.com
 */
public class SysUser {
    private NhSysUser nhSysUser;

    public List<String> getParentCode() {
        return nhSysUser.getParentCode();
    }

    public Long getOrganParent() {
        return nhSysUser.getOrganParent();
    }

    public void setParentCode(List<String> parentCode) {
        nhSysUser.setParentCode(parentCode);
    }

    public void setOrganParent(Long organParent) {
        nhSysUser.setOrganParent(organParent);
    }

    public String getAdministrativeHigh() {
        return nhSysUser.getAdministrativeHigh();
    }

    public void setAdministrativeHigh(String administrativeHigh) {
        nhSysUser.setAdministrativeHigh(administrativeHigh);
    }

    public String getOrganCode() {
        return nhSysUser.getOrganCode();
    }

    public void setOrganCode(String organCode) {
        nhSysUser.setOrganCode(organCode);
    }

    public JSONArray getUserHeadImgs() {
        return nhSysUser.getUserHeadImgs();
    }

    public void setUserHeadImgs(JSONArray userHeadImgs) {
        nhSysUser.setUserHeadImgs(userHeadImgs);
    }

    public String getUserHead() {
        return nhSysUser.getUserHead();
    }

    public String getUserIdenty() {
        return nhSysUser.getUserIdenty();
    }

    public void setUserHead(String userHead) {
        nhSysUser.setUserHead(userHead);
    }

    public void setUserIdenty(String userIdenty) {
        nhSysUser.setUserIdenty(userIdenty);
    }

    public List<NhSysRole> getRoles() {
        return nhSysUser.getRoles();
    }

    public void setRoles(List<NhSysRole> roles) {
        nhSysUser.setRoles(roles);
    }

    public String getRegisterTele() {
        return nhSysUser.getRegisterTele();
    }

    public List<Long> getRoleIds() {
        return nhSysUser.getRoleIds();
    }

    public void setRoleIds(List<Long> roleIds) {
        nhSysUser.setRoleIds(roleIds);
    }

    public void setRegisterCard(String registerCard) {
        nhSysUser.setRegisterCard(registerCard);
    }



    public String getRegisterCard() {
        return nhSysUser.getRegisterCard();
    }



    public void setRegisterTele(String registerTele) {
        nhSysUser.setRegisterTele(registerTele);
    }

    public SysUser(NhSysUser nhSysUser){
        this.nhSysUser = nhSysUser;
    }

    @JsonIgnore
    public NhSysUser getNhSysUser() {
        return nhSysUser;
    }

    public SysUser(){
        this.nhSysUser = new NhSysUser();
    }


    public Long getUserId() {
        return nhSysUser.getUserId();
    }

    public String getEmail() {
        return nhSysUser.getEmail();
    }

    public void setMobile(String mobile) {
        nhSysUser.setMobile(mobile);
    }

    public void setUserPermissions(Set<String> userPermissions) {
        nhSysUser.setUserPermissions(userPermissions);
    }

    public String getUsername() {
        return nhSysUser.getUsername();
    }

    public Integer getUserLevel() {
        return nhSysUser.getUserLevel();
    }

    @JsonIgnore
    public String getPassword() {
        return nhSysUser.getPassword();
    }

    public String getSalt() {
        return nhSysUser.getSalt();
    }

    public String getUserLoginName() {
        return nhSysUser.getUserLoginName();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhSysUser.setCreateTime(createTime);
    }

    public String getMobile() {
        return nhSysUser.getMobile();
    }

    public Integer getStatus() {
        return nhSysUser.getStatus();
    }

    public List<Long> getRoleIdList() {
        return nhSysUser.getRoleIdList();
    }

    public Date getUpdateTime() {
        return nhSysUser.getUpdateTime();
    }

    public void setSalt(String salt) {
        nhSysUser.setSalt(salt);
    }

    public void setRoleIdList(List<Long> roleIdList) {
        nhSysUser.setRoleIdList(roleIdList);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhSysUser.setUpdateTime(updateTime);
    }

    public void setCreateUserId(Long createUserId) {
        nhSysUser.setCreateUserId(createUserId);
    }

    public void setEmail(String email) {
        nhSysUser.setEmail(email);
    }

    public String getRealName() {
        return nhSysUser.getRealName();
    }

    public void setUserLoginName(String userLoginName) {
        nhSysUser.setUserLoginName(userLoginName);
    }

    public Set<String> getUserPermissions() {
        return nhSysUser.getUserPermissions();
    }

    public Long getCreateUserId() {
        return nhSysUser.getCreateUserId();
    }

    public String getOrganName() {
        return nhSysUser.getOrganName();
    }

    public void setUserAdministrativeCode(String userAdministrativeCode) {
        nhSysUser.setUserAdministrativeCode(userAdministrativeCode);
    }

    public void setStatus(Integer status) {
        nhSysUser.setStatus(status);
    }

    public Date getCreateTime() {
        return nhSysUser.getCreateTime();
    }

    public void setOrganName(String organName) {
        nhSysUser.setOrganName(organName);
    }

    public void setUserLevel(Integer userLevel) {
        nhSysUser.setUserLevel(userLevel);
    }

    public void setUserId(Long userId) {
        nhSysUser.setUserId(userId);
    }

    public void setUsername(String username) {
        nhSysUser.setUsername(username);
    }

    public void setOrganId(Long organId) {
        nhSysUser.setOrganId(organId);
    }

    public void setRealName(String realName) {
        nhSysUser.setRealName(realName);
    }

    public Long getOrganId() {
        return nhSysUser.getOrganId();
    }

    public String getUserAdministrativeCode() {
        return nhSysUser.getUserAdministrativeCode();
    }

    public void setPassword(String password) {
        nhSysUser.setPassword(password);
    }

    public String getAdministrativeName() {
        return nhSysUser.getAdministrativeName();
    }

    public void setAdministrativeName(String administrativeName) {
        nhSysUser.setAdministrativeName(administrativeName);
    }
}
