package com.nanhai.core.business.entity;

import com.alibaba.fastjson.JSONArray;
import com.nanhai.core.persistence.beans.NhSubjectInfo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author luobo
 * @create 2021/5/20
 */
@Data
public class SubjectInfo {


    private NhSubjectInfo nhSubjectInfo;

    public SubjectInfo() {
        this.nhSubjectInfo=new NhSubjectInfo();
    }

    public SubjectInfo(NhSubjectInfo nhSubjectInfo) {
        this.nhSubjectInfo = nhSubjectInfo;
    }

    public List<LandSubjectRs> getLandSubjectRs() {
        return nhSubjectInfo.getLandSubjectRs();
    }


    public String getSubjectBase() {
        return nhSubjectInfo.getSubjectBase();
    }

    public String getSubjectName() {
        return nhSubjectInfo.getSubjectName();
    }

    public void setSubjectPlanId(Long subjectPlanId) {
        nhSubjectInfo.setSubjectPlanId(subjectPlanId);
    }

    public void setImgUrl(String imgUrl) {
        nhSubjectInfo.setImgUrl(imgUrl);
    }

    public String getSubjectOtherProduct() {
        return nhSubjectInfo.getSubjectOtherProduct();
    }

    public void setSubjectUscCode(String subjectUscCode) {
        nhSubjectInfo.setSubjectUscCode(subjectUscCode);
    }

    public String getCreatePerson() {
        return nhSubjectInfo.getCreatePerson();
    }

    public JSONArray getOssImgList() {
        return nhSubjectInfo.getOssImgList();
    }

    public String getSubjectCode() {
        return nhSubjectInfo.getSubjectCode();
    }

    public void setSubjectLinkman(String subjectLinkman) {
        nhSubjectInfo.setSubjectLinkman(subjectLinkman);
    }

    public void setSubjectBase(String subjectBase) {
        nhSubjectInfo.setSubjectBase(subjectBase);
    }

    public void setSubjectCard(String subjectCard) {
        nhSubjectInfo.setSubjectCard(subjectCard);
    }

    public void setLandSubjectRs(List<LandSubjectRs> landSubjectRs) {
        nhSubjectInfo.setLandSubjectRs(landSubjectRs);
    }

    public void setSubjectBusiType(String subjectBusiType) {
        nhSubjectInfo.setSubjectBusiType(subjectBusiType);
    }

    public void setOssImgList(JSONArray ossImgList) {
        nhSubjectInfo.setOssImgList(ossImgList);
    }

    public Long getSubjectPlanId() {
        return nhSubjectInfo.getSubjectPlanId();
    }

    public Double getSubjectYearTotalValue() {
        return nhSubjectInfo.getSubjectYearTotalValue();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setAuditDate(Date auditDate) {
        nhSubjectInfo.setAuditDate(auditDate);
    }

    public void setSubjectPersonNum(Integer subjectPersonNum) {
        nhSubjectInfo.setSubjectPersonNum(subjectPersonNum);
    }

    public String getSubjectLinkman() {
        return nhSubjectInfo.getSubjectLinkman();
    }

    public void setSubjectName(String subjectName) {
        nhSubjectInfo.setSubjectName(subjectName);
    }

    public void setAuditStatus(Integer auditStatus) {
        nhSubjectInfo.setAuditStatus(auditStatus);
    }

    public void setAuditMemo(String auditMemo) {
        nhSubjectInfo.setAuditMemo(auditMemo);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public Date getAuditDate() {
        return nhSubjectInfo.getAuditDate();
    }

    public void setSubjectOtherProduct(String subjectOtherProduct) {
        nhSubjectInfo.setSubjectOtherProduct(subjectOtherProduct);
    }

    public String getSubjectMainProduct() {
        return nhSubjectInfo.getSubjectMainProduct();
    }

    public String getSubjectUscCode() {
        return nhSubjectInfo.getSubjectUscCode();
    }

    public void setSubjectOrgCode(String subjectOrgCode) {
        nhSubjectInfo.setSubjectOrgCode(subjectOrgCode);
    }

    public void setSubjectType(Integer subjectType) {
        nhSubjectInfo.setSubjectType(subjectType);
    }

    public void setSubjectCode(String subjectCode) {
        nhSubjectInfo.setSubjectCode(subjectCode);
    }

    public void setAuditPerson(String auditPerson) {
        nhSubjectInfo.setAuditPerson(auditPerson);
    }

    public void setSubjectTele(String subjectTele) {
        nhSubjectInfo.setSubjectTele(subjectTele);
    }

    public Integer getSubjectPersonNum() {
        return nhSubjectInfo.getSubjectPersonNum();
    }

    public Integer getSubjectIndustry() {
        return nhSubjectInfo.getSubjectIndustry();
    }

    public String getSubjectTele() {
        return nhSubjectInfo.getSubjectTele();
    }

    public void setSubjectYearTotalValue(Double subjectYearTotalValue) {
        nhSubjectInfo.setSubjectYearTotalValue(subjectYearTotalValue);
    }

    public void setUpdatePerson(String updatePerson) {
        nhSubjectInfo.setUpdatePerson(updatePerson);
    }

    public void setSubjectVillageId(String subjectVillageId) {
        nhSubjectInfo.setSubjectVillageId(subjectVillageId);
    }

    public void setSubjectIndustry(Integer subjectIndustry) {
        nhSubjectInfo.setSubjectIndustry(subjectIndustry);
    }

    public String getSubjectCard() {
        return nhSubjectInfo.getSubjectCard();
    }

    public String getSubjectTownId() {
        return nhSubjectInfo.getSubjectTownId();
    }

    public void setSubjectTownId(String subjectTownId) {
        nhSubjectInfo.setSubjectTownId(subjectTownId);
    }

    public void setSubjectAddr(String subjectAddr) {
        nhSubjectInfo.setSubjectAddr(subjectAddr);
    }

    public Integer getAuditStatus() {
        return nhSubjectInfo.getAuditStatus();
    }

    public String getSubjectVillageId() {
        return nhSubjectInfo.getSubjectVillageId();
    }

    public void setSubjectMainProduct(String subjectMainProduct) {
        nhSubjectInfo.setSubjectMainProduct(subjectMainProduct);
    }

    public String getImgUrl() {
        return nhSubjectInfo.getImgUrl();
    }

    public Integer getSubjectType() {
        return nhSubjectInfo.getSubjectType();
    }

    public String getAuditPerson() {
        return nhSubjectInfo.getAuditPerson();
    }

    public void setSubjectIntro(String subjectIntro) {
        nhSubjectInfo.setSubjectIntro(subjectIntro);
    }

    public String getSubjectAddr() {
        return nhSubjectInfo.getSubjectAddr();
    }

    public String getSubjectBusiType() {
        return nhSubjectInfo.getSubjectBusiType();
    }

    public String getSubjectIntro() {
        return nhSubjectInfo.getSubjectIntro();
    }

    public String getUpdatePerson() {
        return nhSubjectInfo.getUpdatePerson();
    }

    public String getAuditMemo() {
        return nhSubjectInfo.getAuditMemo();
    }

    public void setCreatePerson(String createPerson) {
        nhSubjectInfo.setCreatePerson(createPerson);
    }

    public String getSubjectOrgCode() {
        return nhSubjectInfo.getSubjectOrgCode();
    }

    public Date getUpdateTime() {
        return nhSubjectInfo.getUpdateTime();
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhSubjectInfo.setCreateTime(createTime);
    }

    public Date getCreateTime() {
        return nhSubjectInfo.getCreateTime();
    }

    public void setId(Long id) {
        nhSubjectInfo.setId(id);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhSubjectInfo.setUpdateTime(updateTime);
    }

    public Long getId() {
        return nhSubjectInfo.getId();
    }
}
