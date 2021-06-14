package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhLandType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 地块类型
 * @author luobo
 * @create 2021/5/13
 */
public class LandType {

    private NhLandType nhLandType;

    @JsonIgnore
    public LandType(NhLandType nhLandType) {
        this.nhLandType = nhLandType;
    }

    public int getLandTypeCode() {
        return nhLandType.getLandTypeCode();
    }

    public void setLandTypeLevel(int landTypeLevel) {
        nhLandType.setLandTypeLevel(landTypeLevel);
    }

    public int getLandTypeLevel() {
        return nhLandType.getLandTypeLevel();
    }

    public String getLandTypeName() {
        return nhLandType.getLandTypeName();
    }

    public int getLandTypeParentCode() {
        return nhLandType.getLandTypeParentCode();
    }

    public void setLandTypeCode(int landTypeCode) {
        nhLandType.setLandTypeCode(landTypeCode);
    }

    public void setLandTypeName(String landTypeName) {
        nhLandType.setLandTypeName(landTypeName);
    }

    public void setLandTypeParentCode(int landTypeParentCode) {
        nhLandType.setLandTypeParentCode(landTypeParentCode);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhLandType.setCreateTime(createTime);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhLandType.setUpdateTime(updateTime);
    }

    public void setId(Long id) {
        nhLandType.setId(id);
    }

    public Long getId() {
        return nhLandType.getId();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")

    public Date getCreateTime() {
        return nhLandType.getCreateTime();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")

    public Date getUpdateTime() {
        return nhLandType.getUpdateTime();
    }
}
