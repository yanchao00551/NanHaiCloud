package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhPropertyValue;
import com.nanhai.core.persistence.beans.NhSubjectAuditInfo;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 杨默
 * @date 2021/5/20 10:57
 * @Description
 */
public class SubjectAuditInfo {
    private NhSubjectAuditInfo nhSubjectAuditInfo;

    public SubjectAuditInfo() {
        this.nhSubjectAuditInfo = new NhSubjectAuditInfo();
    }

    public SubjectAuditInfo(NhSubjectAuditInfo nhSubjectAuditInfo) {
    }

    @JsonIgnore
    public NhSubjectAuditInfo getNhSubjectAuditInfo() {
        return nhSubjectAuditInfo;
    }

    public String getSubjectCode() {
        return nhSubjectAuditInfo.getSubjectCode();
    }

    public Long getSubjectId() {
        return nhSubjectAuditInfo.getSubjectId();
    }

    public String getSubjectName() {
        return nhSubjectAuditInfo.getSubjectName();
    }

    public void setSubjectId(Long subjectId) {
        nhSubjectAuditInfo.setSubjectId(subjectId);
    }

    public void setAuditStatus(String auditStatus) {
        nhSubjectAuditInfo.setAuditStatus(auditStatus);
    }

    public Double getSubjectYearTotalValue() {
        return nhSubjectAuditInfo.getSubjectYearTotalValue();
    }

    public String getSubjectOrgCode() {
        return nhSubjectAuditInfo.getSubjectOrgCode();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getAuditDate() {
        return nhSubjectAuditInfo.getAuditDate();
    }

    public String getSubjectBase() {
        return nhSubjectAuditInfo.getSubjectBase();
    }

    public String getAuditMemo() {
        return nhSubjectAuditInfo.getAuditMemo();
    }

    public void setSubjectOtherProduct(String subjectOtherProduct) {
        nhSubjectAuditInfo.setSubjectOtherProduct(subjectOtherProduct);
    }

    public void setSubjectLinkman(String subjectLinkman) {
        nhSubjectAuditInfo.setSubjectLinkman(subjectLinkman);
    }

    public Long getSubjectPlanId() {
        return nhSubjectAuditInfo.getSubjectPlanId();
    }

    public void setSubjectName(String subjectName) {
        nhSubjectAuditInfo.setSubjectName(subjectName);
    }

    public void setSubjectBase(String subjectBase) {
        nhSubjectAuditInfo.setSubjectBase(subjectBase);
    }

    public void setSubjectYearTotalValue(Double subjectYearTotalValue) {
        nhSubjectAuditInfo.setSubjectYearTotalValue(subjectYearTotalValue);
    }

    public void setSubjectType(@Range(min = 1, max = 3, message = "类型只能是1或2或3") Integer subjectType) {
        nhSubjectAuditInfo.setSubjectType(subjectType);
    }

    public void setSubjectOrgCode(String subjectOrgCode) {
        nhSubjectAuditInfo.setSubjectOrgCode(subjectOrgCode);
    }

    @Range(min = 1, max = 3, message = "类型只能是1或2或3")
    public Integer getSubjectType() {
        return nhSubjectAuditInfo.getSubjectType();
    }

    @Range(min = 1, max = 2, message = "类型只能是1或2")
    public Integer getSubjectIndustry() {
        return nhSubjectAuditInfo.getSubjectIndustry();
    }

    public void setAuditPerson(String auditPerson) {
        nhSubjectAuditInfo.setAuditPerson(auditPerson);
    }

    public void setAuditMemo(String auditMemo) {
        nhSubjectAuditInfo.setAuditMemo(auditMemo);
    }

    public String getSubjectOtherProduct() {
        return nhSubjectAuditInfo.getSubjectOtherProduct();
    }

    public String getSubjectLinkman() {
        return nhSubjectAuditInfo.getSubjectLinkman();
    }

    public String getSubjectTele() {
        return nhSubjectAuditInfo.getSubjectTele();
    }

    public void setSubjectIndustry(@Range(min = 1, max = 2, message = "类型只能是1或2") Integer subjectIndustry) {
        nhSubjectAuditInfo.setSubjectIndustry(subjectIndustry);
    }

    public void setSubjectCard(String subjectCard) {
        nhSubjectAuditInfo.setSubjectCard(subjectCard);
    }

    public void setSubjectVillageId(Integer subjectVillageId) {
        nhSubjectAuditInfo.setSubjectVillageId(subjectVillageId);
    }

    public String getAuditPerson() {
        return nhSubjectAuditInfo.getAuditPerson();
    }

    public void setSubjectTele(String subjectTele) {
        nhSubjectAuditInfo.setSubjectTele(subjectTele);
    }

    public String getSubjectCard() {
        return nhSubjectAuditInfo.getSubjectCard();
    }

    public String getSubjectMainProduct() {
        return nhSubjectAuditInfo.getSubjectMainProduct();
    }

    public String getSubjectUscCode() {
        return nhSubjectAuditInfo.getSubjectUscCode();
    }

    public void setSubjectIntro(String subjectIntro) {
        nhSubjectAuditInfo.setSubjectIntro(subjectIntro);
    }

    public void setSubjectCode(String subjectCode) {
        nhSubjectAuditInfo.setSubjectCode(subjectCode);
    }

    public Integer getSubjectTownId() {
        return nhSubjectAuditInfo.getSubjectTownId();
    }

    public Integer getSubjectPersonNum() {
        return nhSubjectAuditInfo.getSubjectPersonNum();
    }

    public void setSubjectMainProduct(String subjectMainProduct) {
        nhSubjectAuditInfo.setSubjectMainProduct(subjectMainProduct);
    }

    public Integer getSubjectVillageId() {
        return nhSubjectAuditInfo.getSubjectVillageId();
    }

    public String getSubjectAddr() {
        return nhSubjectAuditInfo.getSubjectAddr();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public void setAuditDate(Date auditDate) {
        nhSubjectAuditInfo.setAuditDate(auditDate);
    }

    public void setSubjectPlanId(Long subjectPlanId) {
        nhSubjectAuditInfo.setSubjectPlanId(subjectPlanId);
    }

    public String getSubjectIntro() {
        return nhSubjectAuditInfo.getSubjectIntro();
    }

    public String getSubjectBusiType() {
        return nhSubjectAuditInfo.getSubjectBusiType();
    }

    public void setSubjectAddr(String subjectAddr) {
        nhSubjectAuditInfo.setSubjectAddr(subjectAddr);
    }

    public String getAuditStatus() {
        return nhSubjectAuditInfo.getAuditStatus();
    }

    public void setSubjectBusiType(String subjectBusiType) {
        nhSubjectAuditInfo.setSubjectBusiType(subjectBusiType);
    }

    public void setSubjectUscCode(String subjectUscCode) {
        nhSubjectAuditInfo.setSubjectUscCode(subjectUscCode);
    }

    public void setSubjectPersonNum(Integer subjectPersonNum) {
        nhSubjectAuditInfo.setSubjectPersonNum(subjectPersonNum);
    }

    public void setSubjectTownId(Integer subjectTownId) {
        nhSubjectAuditInfo.setSubjectTownId(subjectTownId);
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhSubjectAuditInfo.setUpdateTime(updateTime);
    }

    public void setId(Long id) {
        nhSubjectAuditInfo.setId(id);
    }

    public Long getId() {
        return nhSubjectAuditInfo.getId();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getUpdateTime() {
        return nhSubjectAuditInfo.getUpdateTime();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getCreateTime() {
        return nhSubjectAuditInfo.getCreateTime();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhSubjectAuditInfo.setCreateTime(createTime);
    }
}
