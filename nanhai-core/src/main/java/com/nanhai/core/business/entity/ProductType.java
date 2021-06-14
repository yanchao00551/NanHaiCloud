package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhProductType;
import com.nanhai.core.persistence.beans.NhPropertyType;
import lombok.ToString;

import java.util.Date;

/**
 * @author 杨默
 * @date 2021/6/7 20:50
 * @Description
 */
@ToString
public class ProductType {
    private NhProductType nhProductType;

    @JsonIgnore
    public NhProductType getNhProductType() {
        return nhProductType;
    }

    public ProductType(NhProductType nhProductType) {
        this.nhProductType = nhProductType;
    }

    public String getProductTypeName() {
        return nhProductType.getProductTypeName();
    }

    public Long getProductTypeCode() {
        return nhProductType.getProductTypeCode();
    }

    public Long getProductTypeLevel() {
        return nhProductType.getProductTypeLevel();
    }

    public Long getProductTypeParentCode() {
        return nhProductType.getProductTypeParentCode();
    }

    public void setProductTypeCode(Long productTypeCode) {
        nhProductType.setProductTypeCode(productTypeCode);
    }

    public void setProductTypeLevel(Long productTypeLevel) {
        nhProductType.setProductTypeLevel(productTypeLevel);
    }

    public void setProductTypeName(String productTypeName) {
        nhProductType.setProductTypeName(productTypeName);
    }

    public void setProductTypeParentCode(Long productTypeParentCode) {
        nhProductType.setProductTypeParentCode(productTypeParentCode);
    }

    public void setUpdateTime(Date updateTime) {
        nhProductType.setUpdateTime(updateTime);
    }

    public Long getId() {
        return nhProductType.getId();
    }

    public void setCreateTime(Date createTime) {
        nhProductType.setCreateTime(createTime);
    }

    public Date getCreateTime() {
        return nhProductType.getCreateTime();
    }

    public void setId(Long id) {
        nhProductType.setId(id);
    }

    public Date getUpdateTime() {
        return nhProductType.getUpdateTime();
    }
}
