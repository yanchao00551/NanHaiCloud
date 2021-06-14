package com.nanhai.core.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.persistence.beans.NhCollectTask;
import com.nanhai.core.persistence.beans.NhPicture;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author luobo
 * @create 2021/5/14
 */
public class Picture  {

   private NhPicture nhPicture;

    @JsonIgnore
    public NhPicture getNhPicture(){
        return nhPicture;
    }

    public Picture(NhPicture nhPicture){
        this.nhPicture = nhPicture;
    }




    public String getImgUrl() {
        return nhPicture.getImgUrl();
    }

    public void setImgUrl(String imgUrl) {
        nhPicture.setImgUrl(imgUrl);
    }

    public Long getId() {
        return nhPicture.getId();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getCreateTime() {
        return nhPicture.getCreateTime();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getUpdateTime() {
        return nhPicture.getUpdateTime();
    }

    public void setId(Long id) {
        nhPicture.setId(id);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        nhPicture.setCreateTime(createTime);
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        nhPicture.setUpdateTime(updateTime);
    }
}
