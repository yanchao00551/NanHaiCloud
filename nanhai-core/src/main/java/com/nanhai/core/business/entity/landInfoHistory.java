package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhLandInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author luobo
 * @create 2021/5/13
 * 地块信息->历史
 */
public class landInfoHistory {

    private NhLandInfo nhLandInfo;

    @JsonIgnore
    public landInfoHistory(NhLandInfo nhLandInfo) {
        this.nhLandInfo = nhLandInfo;
    }

    public String getLandCode() {
        return nhLandInfo.getLandCode();
    }

    public String getCreatePerson() {
        return nhLandInfo.getCreatePerson();
    }

    public String getLandName() {
        return nhLandInfo.getLandName();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setAuditDate(Date auditDate) {
        nhLandInfo.setAuditDate(auditDate);
    }

    public void setLandYearOutput(double landYearOutput) {
        nhLandInfo.setLandYearOutput(landYearOutput);
    }

    public Date getAuditDate() {
        return nhLandInfo.getAuditDate();
    }

    public void setLandArea(BigDecimal landArea) {
        nhLandInfo.setLandArea(landArea);
    }

    public void setAuditMemo(String auditMemo) {
        nhLandInfo.setAuditMemo(auditMemo);
    }

    public void setLandOtherType(String landOtherType) {
        nhLandInfo.setLandOtherType(landOtherType);
    }

    public void setLandTownCode(String landTownCode) {
        nhLandInfo.setLandTownCode(landTownCode);
    }

    public BigDecimal getLandArea() {
        return nhLandInfo.getLandArea();
    }

    public int getLandType() {
        return nhLandInfo.getLandType();
    }

    public String getLandOtherType() {
        return nhLandInfo.getLandOtherType();
    }

    public double getLandYearOutput() {
        return nhLandInfo.getLandYearOutput();
    }

    public void setLandMemo(String landMemo) {
        nhLandInfo.setLandMemo(landMemo);
    }

    public void setLandName(String landName) {
        nhLandInfo.setLandName(landName);
    }

    public void setLandProduct(int landProduct) {
        nhLandInfo.setLandProduct(landProduct);
    }

    public void setLandVillageCode(String landVillageCode) {
        nhLandInfo.setLandVillageCode(landVillageCode);
    }

    public void setUpdatePerson(String updatePerson) {
        nhLandInfo.setUpdatePerson(updatePerson);
    }

    public void setLandType(int landType) {
        nhLandInfo.setLandType(landType);
    }

    public Integer getAuditStatus() {
        return nhLandInfo.getAuditStatus();
    }

    public String getUpdatePerson() {
        return nhLandInfo.getUpdatePerson();
    }

    public String getLandTownCode() {
        return nhLandInfo.getLandTownCode();
    }

    public String getLandVillageCode() {
        return nhLandInfo.getLandVillageCode();
    }

    public void setAuditStatus(Integer auditStatus) {
        nhLandInfo.setAuditStatus(auditStatus);
    }

    public void setLandYearValue(double landYearValue) {
        nhLandInfo.setLandYearValue(landYearValue);
    }

    public String getAuditMemo() {
        return nhLandInfo.getAuditMemo();
    }

    public void setLandCode(String landCode) {
        nhLandInfo.setLandCode(landCode);
    }

    public String getLandOutputUnit() {
        return nhLandInfo.getLandOutputUnit();
    }

    public void setAuditPerson(String auditPerson) {
        nhLandInfo.setAuditPerson(auditPerson);
    }

    public void setLandOutputUnit(String landOutputUnit) {
        nhLandInfo.setLandOutputUnit(landOutputUnit);
    }

    public void setLandPlanId(Long landPlanId) {
        nhLandInfo.setLandPlanId(landPlanId);
    }

    public int getLandProduct() {
        return nhLandInfo.getLandProduct();
    }

    public double getLandYearValue() {
        return nhLandInfo.getLandYearValue();
    }

    public Long getLandPlanId() {
        return nhLandInfo.getLandPlanId();
    }

    public void setCreatePerson(String createPerson) {
        nhLandInfo.setCreatePerson(createPerson);
    }

    public String getLandMemo() {
        return nhLandInfo.getLandMemo();
    }

    public String getAuditPerson() {
        return nhLandInfo.getAuditPerson();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhLandInfo.setUpdateTime(updateTime);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhLandInfo.setCreateTime(createTime);
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getCreateTime() {
        return nhLandInfo.getCreateTime();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getUpdateTime() {
        return nhLandInfo.getUpdateTime();
    }

    public Long getId() {
        return nhLandInfo.getId();
    }

    public void setId(Long id) {
        nhLandInfo.setId(id);
    }
}
