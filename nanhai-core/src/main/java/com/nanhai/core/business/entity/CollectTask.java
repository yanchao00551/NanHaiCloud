package com.nanhai.core.business.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhCollectTask;
import com.nanhai.core.persistence.beans.NhPlanInfo;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 任务表
 * @author 悟空
 * @description //TODO
 * @date 16:41 2021/5/13
 * @param
 * @return null
 */
public class CollectTask {
    private NhCollectTask nhCollectTask;

    public String getAdministrativeName() {
        return nhCollectTask.getAdministrativeName();
    }

    public Date getPlanStartTime() {
        return nhCollectTask.getPlanStartTime();
    }

    public Date getPlanEndTime() {
        return nhCollectTask.getPlanEndTime();
    }

    public void setAdministrativeName(String administrativeName) {
        nhCollectTask.setAdministrativeName(administrativeName);
    }

    public void setPlanStartTime(Date planStartTime) {
        nhCollectTask.setPlanStartTime(planStartTime);
    }

    public void setPlanEndTime(Date planEndTime) {
        nhCollectTask.setPlanEndTime(planEndTime);
    }

    public String getPlanName() {
        return nhCollectTask.getPlanName();
    }

    public void setPlanName(String planName) {
        nhCollectTask.setPlanName(planName);
    }

    @JsonIgnore
    public NhCollectTask getNhCollectTask(){
        return nhCollectTask;
    }

    public CollectTask(NhCollectTask nhCollectTask){
        this.nhCollectTask = nhCollectTask;
    }

    public Long getId() {
        return nhCollectTask.getId();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getCreateTime() {
        return nhCollectTask.getCreateTime();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getUpdateTime() {
        return nhCollectTask.getUpdateTime();
    }

    public void setId(Long id) {
        nhCollectTask.setId(id);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhCollectTask.setCreateTime(createTime);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhCollectTask.setUpdateTime(updateTime);
    }

    public List<NhPlanInfo> getPlanInfos() {
        return nhCollectTask.getPlanInfos();
    }

    public Long getCollectTaskPlanId() {
        return nhCollectTask.getCollectTaskPlanId();
    }

    public String getCollectTaskTownId() {
        return nhCollectTask.getCollectTaskTownId();
    }

    public String getCollectTaskVillageId() {
        return nhCollectTask.getCollectTaskVillageId();
    }

    public void setPlanInfos(List<NhPlanInfo> planInfos) {
        nhCollectTask.setPlanInfos(planInfos);
    }

    public void setCollectTaskPlanId(Long collectTaskPlanId) {
        nhCollectTask.setCollectTaskPlanId(collectTaskPlanId);
    }

    public void setCollectTaskTownId(String collectTaskTownId) {
        nhCollectTask.setCollectTaskTownId(collectTaskTownId);
    }

    public void setCollectTaskVillageId(String collectTaskVillageId) {
        nhCollectTask.setCollectTaskVillageId(collectTaskVillageId);
    }

    public String getCollectTaskVillageName() {
        return nhCollectTask.getCollectTaskVillageName();
    }

    public void setCollectTaskVillageName(String collectTaskVillageName) {
        nhCollectTask.setCollectTaskVillageName(collectTaskVillageName);
    }
}
