package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhUsers;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @PackageName:com.nanhai.core.business.entity
 * @ClassName:Users
 * @Description:
 * @author: 悟空
 * @date: 2021/5/20 19:23
 * @email: 10947@163.com
 */
public class Users {
    private NhUsers nhUsers;

    public Users(NhUsers nhUsers){
        this.nhUsers = nhUsers;
    }
    public Users(){
        this.nhUsers = new NhUsers();
    }

    @JsonIgnore
    public NhUsers getNhUsers() {
        return nhUsers;
    }

    public Long getUserId() {
        return nhUsers.getUserId();
    }

    public Integer getUserLevel() {
        return nhUsers.getUserLevel();
    }

    public void setPageSize(Integer pageSize) {
        nhUsers.setPageSize(pageSize);
    }

    public String getUserLoginName() {
        return nhUsers.getUserLoginName();
    }

    public void setRegisterCode(String registerCode) {
        nhUsers.setRegisterCode(registerCode);
    }

    public void setOrganId(Long organId) {
        nhUsers.setOrganId(organId);
    }

    public String getUserName() {
        return nhUsers.getUserName();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhUsers.setCreateTime(createTime);
    }

    public Integer getPageNumber() {
        return nhUsers.getPageNumber();
    }

    public void setUserId(Long userId) {
        nhUsers.setUserId(userId);
    }

    public void setUserLoginName(String userLoginName) {
        nhUsers.setUserLoginName(userLoginName);
    }

    public void setPageNumber(Integer pageNumber) {
        nhUsers.setPageNumber(pageNumber);
    }

    public void setRegisterTele(String registerTele) {
        nhUsers.setRegisterTele(registerTele);
    }

    public String getUserAdministrativeCode() {
        return nhUsers.getUserAdministrativeCode();
    }

    public String getRegisterCard() {
        return nhUsers.getRegisterCard();
    }

    public String getRegisterCode() {
        return nhUsers.getRegisterCode();
    }

    public String getRegisterTele() {
        return nhUsers.getRegisterTele();
    }

    public void setUserAdministrativeCode(String userAdministrativeCode) {
        nhUsers.setUserAdministrativeCode(userAdministrativeCode);
    }

    public Integer getRegisterAuditStatus() {
        return nhUsers.getRegisterAuditStatus();
    }

    public Long getOrganId() {
        return nhUsers.getOrganId();
    }

    public void setUserName(String userName) {
        nhUsers.setUserName(userName);
    }

    public void setRegisterAuditStatus(Integer registerAuditStatus) {
        nhUsers.setRegisterAuditStatus(registerAuditStatus);
    }

    public Date getCreateTime() {
        return nhUsers.getCreateTime();
    }

    public void setUserLevel(Integer userLevel) {
        nhUsers.setUserLevel(userLevel);
    }

    public void setRegisterCard(String registerCard) {
        nhUsers.setRegisterCard(registerCard);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhUsers.setUpdateTime(updateTime);
    }

    public Integer getPageSize() {
        return nhUsers.getPageSize();
    }

    public Date getUpdateTime() {
        return nhUsers.getUpdateTime();
    }

    public void setId(Long id) {
        nhUsers.setId(id);
    }

    public Long getId() {
        return nhUsers.getId();
    }

}
