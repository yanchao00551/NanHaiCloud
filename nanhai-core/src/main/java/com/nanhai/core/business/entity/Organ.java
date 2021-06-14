package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.nanhai.core.persistence.beans.NhOrgan;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


/**
 * @author 杨默
 * @date 2021/5/19 18:31
 * @Description
 */
@Data
public class Organ {
    private NhOrgan nhOrgan;

    public Organ() {
        this.nhOrgan=new NhOrgan();
    }

    public Organ(NhOrgan nhOrgan) {
        this.nhOrgan = nhOrgan;
    }




    public String getOrganCode() {
        return nhOrgan.getOrganCode();
    }

    public String getLinkMan() {
        return nhOrgan.getLinkMan();
    }

    public String getOrganName() {
        return nhOrgan.getOrganName();
    }

    public void setLinkPhone(String linkPhone) {
        nhOrgan.setLinkPhone(linkPhone);
    }

    public void setOrganAddress(String organAddress) {
        nhOrgan.setOrganAddress(organAddress);
    }

    public String getLinkPhone() {
        return nhOrgan.getLinkPhone();
    }

    public String getOrganShortName() {
        return nhOrgan.getOrganShortName();
    }

    public String getOrganAddress() {
        return nhOrgan.getOrganAddress();
    }

    public String getOrganMemo() {
        return nhOrgan.getOrganMemo();
    }

    public void setOrganShortName(String organShortName) {
        nhOrgan.setOrganShortName(organShortName);
    }

    public Long getOrganParent() {
        return nhOrgan.getOrganParent();
    }

    public void setOrganCode(String organCode) {
        nhOrgan.setOrganCode(organCode);
    }

    public void setOrganName(String organName) {
        nhOrgan.setOrganName(organName);
    }

    public void setOrganMemo(String organMemo) {
        nhOrgan.setOrganMemo(organMemo);
    }

    public void setOrganParent(Long organParent) {
        nhOrgan.setOrganParent(organParent);
    }

    public void setLinkMan(String linkMan) {
        nhOrgan.setLinkMan(linkMan);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhOrgan.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return nhOrgan.getUpdateTime();
    }

    public Date getCreateTime() {
        return nhOrgan.getCreateTime();
    }

    public Long getId() {
        return nhOrgan.getId();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhOrgan.setUpdateTime(updateTime);
    }

    public void setId(Long id) {
        nhOrgan.setId(id);
    }
}
