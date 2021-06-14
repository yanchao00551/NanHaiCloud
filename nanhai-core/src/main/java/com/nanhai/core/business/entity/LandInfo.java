package com.nanhai.core.business.entity;


import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhCollectTask;
import com.nanhai.core.persistence.beans.NhLandInfo;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author luobo
 * @create 2021/5/13
 * 地块信息
 */
@ToString
public class LandInfo {

    private NhLandInfo nhLandInfo;

    @JsonIgnore
    public NhLandInfo getNhLandInfo(){
        return nhLandInfo;
    }


    public LandInfo (){

         this.nhLandInfo=new NhLandInfo();
    }

    @JsonIgnore
    public LandInfo(NhLandInfo nhLandInfo) {
        this.nhLandInfo = nhLandInfo;
    }
    @NotNull(message = "缺少必要参数:landType",groups = Group.One.class)
    @Min(value = 0,message = "请检查格式:landType",groups = Group.One.class)
    public Integer getLandType() {
        return nhLandInfo.getLandType();
    }
    public String getLandCode() {
        return nhLandInfo.getLandCode();
    }
    @NotNull(message = "缺少必要参数:landName",groups = {Group.One.class,Group.Two.class})
    public String getLandName() {
        return nhLandInfo.getLandName();
    }


    public String getLandOtherType() {
        return nhLandInfo.getLandOtherType();
    }

    public void setLandOtherType(String landOtherType) {
        nhLandInfo.setLandOtherType(landOtherType);
    }


    public void setLandProduct(Integer landProduct) {
        nhLandInfo.setLandProduct(landProduct);
    }

    public void setAuditMemo(String auditMemo) {
        nhLandInfo.setAuditMemo(auditMemo);
    }



    public String getAuditPerson() {
        return nhLandInfo.getAuditPerson();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setAuditDate(Date auditDate) {
        nhLandInfo.setAuditDate(auditDate);
    }

    public Integer getAuditStatus() {
        return nhLandInfo.getAuditStatus();
    }
    public void setLandName(String landName) {
        nhLandInfo.setLandName(landName);
    }

    public Date getAuditDate() {
        return nhLandInfo.getAuditDate();
    }

    public Double getLandYearOutput() {
        return nhLandInfo.getLandYearOutput();
    }

    public void setCreatePerson(String createPerson) {
        nhLandInfo.setCreatePerson(createPerson);
    }

    public String getCreatePerson() {
        return nhLandInfo.getCreatePerson();
    }

    public void setAuditPerson(String auditPerson) {
        nhLandInfo.setAuditPerson(auditPerson);
    }

    public String getLandOutputUnit() {
        return nhLandInfo.getLandOutputUnit();
    }

    public void setAuditStatus(Integer auditStatus) {
        nhLandInfo.setAuditStatus(auditStatus);
    }

    @NotNull(message = "缺少必要参数:landVillageCode",groups = Group.One.class)
    public String getLandVillageCode() {
        return nhLandInfo.getLandVillageCode();
    }
    @NotNull(message = "缺少必要参数:landArea",groups = Group.One.class)
    @Min(value = 0,message = "请检查格式:setLandProduct",groups = Group.One.class)
    public Integer getLandProduct() {
        return nhLandInfo.getLandProduct();
    }
    public void setLandCode(String landCode) {
        nhLandInfo.setLandCode(landCode);
    }



    public void setLandOutputUnit(String landOutputUnit) {
        nhLandInfo.setLandOutputUnit(landOutputUnit);
    }

    public void setLandPlanId(Long landPlanId) {
        nhLandInfo.setLandPlanId(landPlanId);
    }

    public void setUpdatePerson(String updatePerson) {
        nhLandInfo.setUpdatePerson(updatePerson);
    }
    public void setLandVillageCode(String landVillageCode) {
        nhLandInfo.setLandVillageCode(landVillageCode);
    }
    @NotNull(message = "缺少必要参数:landTownCode",groups = Group.One.class)
    public String getLandTownCode() {
        return nhLandInfo.getLandTownCode();
    }

    public String getAuditMemo() {
        return nhLandInfo.getAuditMemo();
    }

    public Long getLandPlanId() {
        return nhLandInfo.getLandPlanId();
    }

    public void setLandMemo(String landMemo) {
        nhLandInfo.setLandMemo(landMemo);
    }

    public String getUpdatePerson() {
        return nhLandInfo.getUpdatePerson();
    }

    public String getLandMemo() {
        return nhLandInfo.getLandMemo();
    }




    public void setLandType(Integer  landType) {
        nhLandInfo.setLandType(landType);
    }

    public void setLandTownCode(String landTownCode) {
        nhLandInfo.setLandTownCode(landTownCode);
    }
    public Date getCreateTime() {
        return nhLandInfo.getCreateTime();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhLandInfo.setCreateTime(createTime);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhLandInfo.setUpdateTime(updateTime);
    }
    @NotNull(message = "缺少必要参数:landTownCode",groups = Group.Two.class)
    public void setId(Long id) {
        nhLandInfo.setId(id);
    }


    public Long getId() {
        return nhLandInfo.getId();
    }

    public Date getUpdateTime() {
        return nhLandInfo.getUpdateTime();
    }

    public String getImgUrl() {
        return nhLandInfo.getImgUrl();
    }

    public void setImgUrl(String imgUrl) {
        nhLandInfo.setImgUrl(imgUrl);
    }

    public List<LandSubjectRs> getLandSubjectRs() {
        return nhLandInfo.getLandSubjectRs();
    }

    public JSONArray getOssImgList() {
        return nhLandInfo.getOssImgList();
    }


    public String getLandTypeName() {
        return nhLandInfo.getLandTypeName();
    }

    public void setLandProduce(String landProduce) {
        nhLandInfo.setLandProduce(landProduce);
    }

    public String getLandProduce() {
        return nhLandInfo.getLandProduce();
    }

    public String getSubjectNames() {
        return nhLandInfo.getSubjectNames();
    }

    public String getLandPlanName() {
        return nhLandInfo.getLandPlanName();
    }

    public Integer getCollectStatus() {
        return nhLandInfo.getCollectStatus();
    }

    public void setCollectStatus(Integer collectStatus) {
        nhLandInfo.setCollectStatus(collectStatus);
    }

    public Integer getLandNameTailType() {
        return nhLandInfo.getLandNameTailType();
    }

    public BigDecimal getLandArea() {
        return nhLandInfo.getLandArea();
    }

    public String getLandTownName() {
        return nhLandInfo.getLandTownName();
    }

    public String getLandVillageName() {
        return nhLandInfo.getLandVillageName();
    }

    public void setIsHighStandardFarmland(String isHighStandardFarmland) {
        nhLandInfo.setIsHighStandardFarmland(isHighStandardFarmland);
    }

    public void setFishHistoryId(String fishHistoryId) {
        nhLandInfo.setFishHistoryId(fishHistoryId);
    }

    public String getLevelOneType() {
        return nhLandInfo.getLevelOneType();
    }

    public void setLandTypeName(String landTypeName) {
        nhLandInfo.setLandTypeName(landTypeName);
    }

    public void setLandYearOutput(Double landYearOutput) {
        nhLandInfo.setLandYearOutput(landYearOutput);
    }

    public String getLevelTwoType() {
        return nhLandInfo.getLevelTwoType();
    }

    public String getHighStandardFarmlandHistoryId() {
        return nhLandInfo.getHighStandardFarmlandHistoryId();
    }

    public void setLandTownName(String landTownName) {
        nhLandInfo.setLandTownName(landTownName);
    }

    public void setIsLsscq(String isLsscq) {
        nhLandInfo.setIsLsscq(isLsscq);
    }

    public void setLevelTwoType(String levelTwoType) {
        nhLandInfo.setLevelTwoType(levelTwoType);
    }

    public String getIsHighStandardFarmland() {
        return nhLandInfo.getIsHighStandardFarmland();
    }

    public void setLandSubjectRs(List<LandSubjectRs> landSubjectRs) {
        nhLandInfo.setLandSubjectRs(landSubjectRs);
    }

    public void setSubjectNames(String subjectNames) {
        nhLandInfo.setSubjectNames(subjectNames);
    }

    public void setLandVillageName(String landVillageName) {
        nhLandInfo.setLandVillageName(landVillageName);
    }

    public void setLevelOneType(String levelOneType) {
        nhLandInfo.setLevelOneType(levelOneType);
    }

    public String getIsLsscq() {
        return nhLandInfo.getIsLsscq();
    }

    public void setLandNameTailType(Integer landNameTailType) {
        nhLandInfo.setLandNameTailType(landNameTailType);
    }

    public void setOssImgList(JSONArray ossImgList) {
        nhLandInfo.setOssImgList(ossImgList);
    }

    public String getFishHistoryId() {
        return nhLandInfo.getFishHistoryId();
    }

    public BigDecimal getMu() {
        return nhLandInfo.getMu();
    }

    public void setLandPlanName(String landPlanName) {
        nhLandInfo.setLandPlanName(landPlanName);
    }

    public void setLandArea(BigDecimal landArea) {
        nhLandInfo.setLandArea(landArea);
    }

    public void setHighStandardFarmlandHistoryId(String highStandardFarmlandHistoryId) {
        nhLandInfo.setHighStandardFarmlandHistoryId(highStandardFarmlandHistoryId);
    }

    public void setMu(BigDecimal mu) {
        nhLandInfo.setMu(mu);
    }

    public Double getLandYearValue() {
        return nhLandInfo.getLandYearValue();
    }

    public void setLandYearValue(Double landYearValue) {
        nhLandInfo.setLandYearValue(landYearValue);
    }
}
