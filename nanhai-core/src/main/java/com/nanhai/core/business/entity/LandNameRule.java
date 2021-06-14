package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhLandNameRule;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 地块自动命名规则
 *
 * @author luobo
 * @create 2021/5/13
 */
public class LandNameRule {

    private NhLandNameRule nhLandNameRule;

    public LandNameRule() {
        this.nhLandNameRule=new NhLandNameRule();
    }

    @JsonIgnore
    public LandNameRule(NhLandNameRule nhLandNameRule) {
        this.nhLandNameRule = nhLandNameRule;
    }

    public NhLandNameRule getNhLandNameRule() {
        return nhLandNameRule;
    }

    public void setNhLandNameRule(NhLandNameRule nhLandNameRule) {
        this.nhLandNameRule = nhLandNameRule;
    }

    public Integer getTown() {
        return nhLandNameRule.getTown();
    }

    public Integer getVillage() {
        return nhLandNameRule.getVillage();
    }

    public Integer getLandType() {
        return nhLandNameRule.getLandType();
    }

    public Integer getEn() {
        return nhLandNameRule.getEn();
    }

    public Integer getNum() {
        return nhLandNameRule.getNum();
    }

    public void setTown(Integer town) {
        nhLandNameRule.setTown(town);
    }

    public void setVillage(Integer village) {
        nhLandNameRule.setVillage(village);
    }

    public void setLandType(Integer landType) {
        nhLandNameRule.setLandType(landType);
    }

    public void setEn(Integer en) {
        nhLandNameRule.setEn(en);
    }

    public void setNum(Integer num) {
        nhLandNameRule.setNum(num);
    }



    public Date getCreateTime() {
        return nhLandNameRule.getCreateTime();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhLandNameRule.setUpdateTime(updateTime);
    }

    public void setId(Long id) {
        nhLandNameRule.setId(id);
    }



    public Date getUpdateTime() {
        return nhLandNameRule.getUpdateTime();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhLandNameRule.setCreateTime(createTime);
    }

    public Long getId() {
        return nhLandNameRule.getId();
    }

    public Integer getRuleNameStatus() {
        return nhLandNameRule.getRuleNameStatus();
    }

    public void setRuleNameStatus(Integer ruleNameStatus) {
        nhLandNameRule.setRuleNameStatus(ruleNameStatus);
    }
}
