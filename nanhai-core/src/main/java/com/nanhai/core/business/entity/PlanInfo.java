package com.nanhai.core.business.entity;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhCollectTask;
import com.nanhai.core.persistence.beans.NhPlanInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * 计划表
 * @author 悟空
 * @description //TODO
 * @date 16:53 2021/5/13
 * @param
 * @return null
 */
@ToString
public class PlanInfo {
    private NhPlanInfo nhPlanInfo;

    @Getter
    @Setter
    private String area;



    public JSONObject getTreeData() {
        return nhPlanInfo.getTreeData();
    }

    public JSONArray getOssImgList() {
        return nhPlanInfo.getOssImgList();
    }

    public void setOssImgList(JSONArray ossImgList) {
        nhPlanInfo.setOssImgList(ossImgList);
    }

    public void setTreeData(JSONObject treeData) {
        nhPlanInfo.setTreeData(treeData);
    }

    public List<NhCollectTask> getCollectTasks() {
        return nhPlanInfo.getCollectTasks();
    }

    public void setCollectTasks(List<NhCollectTask> collectTasks) {
        nhPlanInfo.setCollectTasks(collectTasks);
    }

    public PlanInfo(){
        this.nhPlanInfo = new NhPlanInfo();
    }

    @JsonIgnore
    public NhPlanInfo getNhPlanInfo() {
        return nhPlanInfo;
    }

    public PlanInfo(NhPlanInfo nhPlanInfo){
        this.nhPlanInfo = nhPlanInfo;
    }

    public Long getId() {
        return nhPlanInfo.getId();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getCreateTime() {
        return nhPlanInfo.getCreateTime();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getUpdateTime() {
        return nhPlanInfo.getUpdateTime();
    }

    public void setId(Long id) {
        nhPlanInfo.setId(id);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhPlanInfo.setCreateTime(createTime);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhPlanInfo.setUpdateTime(updateTime);
    }

    public String getPlanRequire() {
        return nhPlanInfo.getPlanRequire();
    }

    public String getPlanCode() {
        return nhPlanInfo.getPlanCode();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getPlanStartTime() {
        return nhPlanInfo.getPlanStartTime();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getPlanEndTime() {
        return nhPlanInfo.getPlanEndTime();
    }

    public String getPlanName() {
        return nhPlanInfo.getPlanName();
    }

    public Integer getPlanStatus() {
        return nhPlanInfo.getPlanStatus();
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setPlanEndTime(Date planEndTime) {
        nhPlanInfo.setPlanEndTime(planEndTime);
    }

    public String getCreatePerson() {
        return nhPlanInfo.getCreatePerson();
    }

    public void setCreatePerson(String createPerson) {
        nhPlanInfo.setCreatePerson(createPerson);
    }

    public String getUpdatePerson() {
        return nhPlanInfo.getUpdatePerson();
    }

    public void setPlanName(String planName) {
        nhPlanInfo.setPlanName(planName);
    }

    public void setPlanFiles(String planFiles) {
        nhPlanInfo.setPlanFiles(planFiles);
    }

    public String getPlanFiles() {
        return nhPlanInfo.getPlanFiles();
    }

    public void setPlanRequire(String planRequire) {
        nhPlanInfo.setPlanRequire(planRequire);
    }

    public void setPlanCode(String planCode) {
        nhPlanInfo.setPlanCode(planCode);
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setPlanStartTime(Date planStartTime) {
        nhPlanInfo.setPlanStartTime(planStartTime);
    }

    public void setUpdatePerson(String updatePerson) {
        nhPlanInfo.setUpdatePerson(updatePerson);
    }

    public void setPlanStatus(Integer planStatus) {
        nhPlanInfo.setPlanStatus(planStatus);
    }

   /* public CollectTaskLandRs getCollectTaskLandRs() {
        return nhPlanInfo.getCollectTaskLandRs();
    }

    public void setCollectTaskLandRs(CollectTaskLandRs collectTaskLandRs) {
        nhPlanInfo.setCollectTaskLandRs(collectTaskLandRs);
    }
*/
     public JSONArray getCollectTaskLandRs() {
        return nhPlanInfo.getCollectTaskLandRs();
    }

    public void setCollectTaskLandRs(JSONArray collectTaskLandRs) {
        nhPlanInfo.setCollectTaskLandRs(collectTaskLandRs);
    }
}
