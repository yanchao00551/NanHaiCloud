package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nanhai.core.persistence.beans.NhSubjectYearTotalValue;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * 主体历史年产值
 *
 * @author luobo
 * @create 2021/5/13
 */
public class SubjectYearTotalValue {

    private NhSubjectYearTotalValue nhSubjectYearTotalValue;



    @JsonIgnore
    public NhSubjectYearTotalValue getNhSubjectYearTotalValue() {
        return nhSubjectYearTotalValue;
    }

    public SubjectYearTotalValue() {
        this.nhSubjectYearTotalValue = new NhSubjectYearTotalValue();
    }
    public SubjectYearTotalValue(NhSubjectYearTotalValue nhSubjectYearTotalValue) {
        this.nhSubjectYearTotalValue = nhSubjectYearTotalValue;
    }

    public void setNhSubjectYearTotalValue(NhSubjectYearTotalValue nhSubjectYearTotalValue) {
        this.nhSubjectYearTotalValue = nhSubjectYearTotalValue;
    }

    public String getSytvSubjectCode() {
        return nhSubjectYearTotalValue.getSytvSubjectCode();
    }

    public Integer getSytvYear() {
        return nhSubjectYearTotalValue.getSytvYear();
    }

    public Double getSytvYearTotalValue() {
        return nhSubjectYearTotalValue.getSytvYearTotalValue();
    }

    public void setSytvSubjectCode(String sytvSubjectCode) {
        nhSubjectYearTotalValue.setSytvSubjectCode(sytvSubjectCode);
    }

    public void setSytvYear(Integer sytvYear) {
        nhSubjectYearTotalValue.setSytvYear(sytvYear);
    }

    public void setSytvYearTotalValue(Double sytvYearTotalValue) {
        nhSubjectYearTotalValue.setSytvYearTotalValue(sytvYearTotalValue);
    }

    public void setUpdateTime(Date updateTime) {
        nhSubjectYearTotalValue.setUpdateTime(updateTime);
    }

    public Long getId() {
        return nhSubjectYearTotalValue.getId();
    }

    public Date getCreateTime() {
        return nhSubjectYearTotalValue.getCreateTime();
    }

    public Date getUpdateTime() {
        return nhSubjectYearTotalValue.getUpdateTime();
    }

    public void setId(Long id) {
        nhSubjectYearTotalValue.setId(id);
    }

    public void setCreateTime(Date createTime) {
        nhSubjectYearTotalValue.setCreateTime(createTime);
    }
}

