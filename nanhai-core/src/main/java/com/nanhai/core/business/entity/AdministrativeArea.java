package com.nanhai.core.business.entity;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhAdministrativeArea;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * 行政区划 南海区的区县、镇、村三级行政区划
 * @author 悟空
 * @description //TODO
 * @date 16:36 2021/5/13
 * @param
 * @return null
 */

@ToString
public class AdministrativeArea {
    private NhAdministrativeArea nhAdministrativeArea;

    @Getter
    @Setter
    private List<AdministrativeArea> children;



    @Getter
    @Setter
    private String parentName;
     @JsonIgnore
    public void setNhAdministrativeArea(NhAdministrativeArea nhAdministrativeArea) {
        this.nhAdministrativeArea = nhAdministrativeArea;
    }

    public String getSelected() {
        return nhAdministrativeArea.getSelected();
    }

    public void setSelected(String selected) {
        nhAdministrativeArea.setSelected(selected);
    }

    @JsonIgnore
    public NhAdministrativeArea getNhAdministrativeArea(){
        return nhAdministrativeArea;
    }

    public AdministrativeArea(){
         this.nhAdministrativeArea=new NhAdministrativeArea();
    }

    public AdministrativeArea(NhAdministrativeArea nhAdministrativeArea){
        this.nhAdministrativeArea = nhAdministrativeArea;
    }

    public Long getId() {
        return nhAdministrativeArea.getId();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getCreateTime() {
        return nhAdministrativeArea.getCreateTime();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getUpdateTime() {
        return nhAdministrativeArea.getUpdateTime();
    }

    public String getAdministrativeCode() {
        return nhAdministrativeArea.getAdministrativeCode();
    }

    public String getAdministrativeName() {
        return nhAdministrativeArea.getAdministrativeName();
    }

    public String getAdministrativeHigh() {
        return nhAdministrativeArea.getAdministrativeHigh();
    }

    public Integer getAdministrativeLevel() {
        return nhAdministrativeArea.getAdministrativeLevel();
    }

    public void setAdministrativeLat(String administrativeLat) {
        nhAdministrativeArea.setAdministrativeLat(administrativeLat);
    }

    public String getAdministrativeLat() {
        return nhAdministrativeArea.getAdministrativeLat();
    }

    public String getAdministrativeLon() {
        return nhAdministrativeArea.getAdministrativeLon();
    }

    public String getAdministrativePcode() {
        return nhAdministrativeArea.getAdministrativePcode();
    }

    public void setAdministrativeCode(String administrativeCode) {
        nhAdministrativeArea.setAdministrativeCode(administrativeCode);
    }

    public void setAdministrativePcode(String administrativePcode) {
        nhAdministrativeArea.setAdministrativePcode(administrativePcode);
    }

    public void setAdministrativeLon(String administrativeLon) {
        nhAdministrativeArea.setAdministrativeLon(administrativeLon);
    }

    public void setAdministrativeName(String administrativeName) {
        nhAdministrativeArea.setAdministrativeName(administrativeName);
    }

    public void setAdministrativeHigh(String administrativeHigh) {
        nhAdministrativeArea.setAdministrativeHigh(administrativeHigh);
    }

    public void setAdministrativeLevel(Integer administrativeLevel) {
        nhAdministrativeArea.setAdministrativeLevel(administrativeLevel);
    }

    public void setId(Long id) {
        nhAdministrativeArea.setId(id);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhAdministrativeArea.setCreateTime(createTime);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhAdministrativeArea.setUpdateTime(updateTime);
    }
}
