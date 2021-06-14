package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhCollectTaskLand;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @PackageName:com.nanhai.core.business.entity
 * @ClassName:CollectTaskLand
 * @Description:
 * @author: 悟空
 * @date: 2021/5/29 15:12
 * @email: 10947@163.com
 */
@ToString
public class CollectTaskLand {
    private NhCollectTaskLand nhCollectTaskLand;

    public CollectTaskLand(NhCollectTaskLand nhCollectTaskLand){
        this.nhCollectTaskLand = nhCollectTaskLand;
    }

    public CollectTaskLand(){
        this.nhCollectTaskLand = new NhCollectTaskLand();
    }

    @JsonIgnore
    public NhCollectTaskLand getNhCollectTaskLand() {
        return nhCollectTaskLand;
    }

    public Date getAuditDate() {
        return nhCollectTaskLand.getAuditDate();
    }

    public String getLandProduce() {
        return nhCollectTaskLand.getLandProduce();
    }

    public Long getPlanId() {
        return nhCollectTaskLand.getPlanId();
    }

    public String  getLandId() {
        return nhCollectTaskLand.getLandId();
    }

    public Integer getLandType() {
        return nhCollectTaskLand.getLandType();
    }

    public Integer getLandProduct() {
        return nhCollectTaskLand.getLandProduct();
    }

    public String getLandOtherType() {
        return nhCollectTaskLand.getLandOtherType();
    }

    public void setUpdatePerson(String updatePerson) {
        nhCollectTaskLand.setUpdatePerson(updatePerson);
    }

    public void setLandOtherType(String landOtherType) {
        nhCollectTaskLand.setLandOtherType(landOtherType);
    }

    public void setLandProduce(String landProduce) {
        nhCollectTaskLand.setLandProduce(landProduce);
    }

    public BigDecimal getLandProductArea() {
        return nhCollectTaskLand.getLandProductArea();
    }

    public Integer getAuditStatus() {
        return nhCollectTaskLand.getAuditStatus();
    }

    public void setLandType(Integer landType) {
        nhCollectTaskLand.setLandType(landType);
    }

    public Double getLandYearValue() {
        return nhCollectTaskLand.getLandYearValue();
    }

    public void setAuditPerson(String auditPerson) {
        nhCollectTaskLand.setAuditPerson(auditPerson);
    }

    public void setAuditMemo(String auditMemo) {
        nhCollectTaskLand.setAuditMemo(auditMemo);
    }

    public String getCreatePerson() {
        return nhCollectTaskLand.getCreatePerson();
    }

    public void setLandProductArea(BigDecimal landProductArea) {
        nhCollectTaskLand.setLandProductArea(landProductArea);
    }

    public String getUpdatePerson() {
        return nhCollectTaskLand.getUpdatePerson();
    }

    public void setLandId(String landId) {
        nhCollectTaskLand.setLandId(landId);
    }

    public void setCreatePerson(String createPerson) {
        nhCollectTaskLand.setCreatePerson(createPerson);
    }

    public String getAuditPerson() {
        return nhCollectTaskLand.getAuditPerson();
    }

    public void setPlanId(Long planId) {
        nhCollectTaskLand.setPlanId(planId);
    }

    public String getAuditMemo() {
        return nhCollectTaskLand.getAuditMemo();
    }

    public void setAuditStatus(Integer auditStatus) {
        nhCollectTaskLand.setAuditStatus(auditStatus);
    }

    public void setAuditDate(Date auditDate) {
        nhCollectTaskLand.setAuditDate(auditDate);
    }

    public void setLandProduct(Integer landProduct) {
        nhCollectTaskLand.setLandProduct(landProduct);
    }

    public void setLandYearValue(Double landYearValue) {
        nhCollectTaskLand.setLandYearValue(landYearValue);
    }

    public void setCreateTime(Date createTime) {
        nhCollectTaskLand.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return nhCollectTaskLand.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        nhCollectTaskLand.setUpdateTime(updateTime);
    }

    public void setId(Long id) {
        nhCollectTaskLand.setId(id);
    }

    public Long getId() {
        return nhCollectTaskLand.getId();
    }

    public Date getCreateTime() {
        return nhCollectTaskLand.getCreateTime();
    }

    public Integer getCollectStatus() {
        return nhCollectTaskLand.getCollectStatus();
    }

    public void setCollectStatus(Integer collectStatus) {
        nhCollectTaskLand.setCollectStatus(collectStatus);
    }

    public String getPlanName() {
        return nhCollectTaskLand.getPlanName();
    }

    public void setPlanName(String planName) {
        nhCollectTaskLand.setPlanName(planName);
    }

    public String getLandTownCode() {
        return nhCollectTaskLand.getLandTownCode();
    }

    public String getLandVillageCode() {
        return nhCollectTaskLand.getLandVillageCode();
    }

    public String getLandName() {
        return nhCollectTaskLand.getLandName();
    }

    public void setLandTownCode(String landTownCode) {
        nhCollectTaskLand.setLandTownCode(landTownCode);
    }

    public void setLandVillageCode(String landVillageCode) {
        nhCollectTaskLand.setLandVillageCode(landVillageCode);
    }

    public void setLandName(String landName) {
        nhCollectTaskLand.setLandName(landName);
    }

    public String getLandTownName() {
        return nhCollectTaskLand.getLandTownName();
    }

    public String getLandVillageName() {
        return nhCollectTaskLand.getLandVillageName();
    }

    public void setLandTownName(String landTownName) {
        nhCollectTaskLand.setLandTownName(landTownName);
    }

    public void setLandVillageName(String landVillageName) {
        nhCollectTaskLand.setLandVillageName(landVillageName);
    }

    public String getLandTypeName() {
        return nhCollectTaskLand.getLandTypeName();
    }

    public void setLandTypeName(String landTypeName) {
        nhCollectTaskLand.setLandTypeName(landTypeName);
    }

    public String getImgUrl() {
        return nhCollectTaskLand.getImgUrl();
    }

    public Double getLandYearOutput() {
        return nhCollectTaskLand.getLandYearOutput();
    }

    public String getLandOutputUnit() {
        return nhCollectTaskLand.getLandOutputUnit();
    }

    public void setImgUrl(String imgUrl) {
        nhCollectTaskLand.setImgUrl(imgUrl);
    }

    public void setLandYearOutput(Double landYearOutput) {
        nhCollectTaskLand.setLandYearOutput(landYearOutput);
    }

    public void setLandOutputUnit(String landOutputUnit) {
        nhCollectTaskLand.setLandOutputUnit(landOutputUnit);
    }


}
