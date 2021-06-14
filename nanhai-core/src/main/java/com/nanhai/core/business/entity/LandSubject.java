package com.nanhai.core.business.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhLandSubject;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 主体地块联系表
 *
 * @author luobo
 * @create 2021/5/13
 */
@ToString
public class LandSubject {
    private NhLandSubject nhLandSubject;

    public NhLandSubject getNhLandSubject() {
        return nhLandSubject;
    }

    public void setNhLandSubject(NhLandSubject nhLandSubject) {
        this.nhLandSubject = nhLandSubject;
    }

    public LandSubject(){
        nhLandSubject=new NhLandSubject();
    }
    @JsonIgnore
    public LandSubject(NhLandSubject nhLandSubject) {
        this.nhLandSubject = nhLandSubject;
    }

    public Long getLsPlanId() {
        return nhLandSubject.getLsPlanId();
    }

    public Double getLsSubjectUseArea() {
        return nhLandSubject.getLsSubjectUseArea();
    }

    public String getLsLandCode() {
        return nhLandSubject.getLsLandCode();
    }

    public String getLsSubjectCode() {
        return nhLandSubject.getLsSubjectCode();
    }


    public void setLsPlanId(Long lsPlanId) {
        nhLandSubject.setLsPlanId(lsPlanId);
    }

    public void setLsLandCode(String lsLandCode) {
        nhLandSubject.setLsLandCode(lsLandCode);
    }

    public void setLsSubjectCode(String lsSubjectCode) {
        nhLandSubject.setLsSubjectCode(lsSubjectCode);
    }

    public Double getLsYearValue() {
        return nhLandSubject.getLsYearValue();
    }

    public void setLsYearValue(Double lsYearValue) {
        nhLandSubject.setLsYearValue(lsYearValue);
    }

    public void setLsSubjectUseArea(Double lsSubjectUseArea) {
        nhLandSubject.setLsSubjectUseArea(lsSubjectUseArea);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhLandSubject.setCreateTime(createTime);
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    public Date getUpdateTime() {
        return nhLandSubject.getUpdateTime();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhLandSubject.setUpdateTime(updateTime);
    }

    public void setId(Long id) {
        nhLandSubject.setId(id);
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    public Date getCreateTime() {
        return nhLandSubject.getCreateTime();
    }

    public Long getId() {
        return nhLandSubject.getId();
    }


}
