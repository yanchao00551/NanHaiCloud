package com.nanhai.core.business.vo;


import com.nanhai.core.business.entity.Organ;
import com.nanhai.core.framework.object.BaseConditionVO;
import com.nanhai.core.persistence.beans.NhOrgan;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Delegate;
import org.aspectj.weaver.ast.Or;

import java.util.Date;

/**
 * @author 杨默
 * @date 2021/5/19 18:31
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrganConditionVO extends BaseConditionVO {

    private Organ organ;

    public OrganConditionVO() {
        this.organ=new Organ();
    }

    public NhOrgan getNhOrgan() {
        return organ.getNhOrgan();
    }

    public void setNhOrgan(NhOrgan nhOrgan) {
        organ.setNhOrgan(nhOrgan);
    }

    public String getOrganCode() {
        return organ.getOrganCode();
    }

    public String getLinkMan() {
        return organ.getLinkMan();
    }

    public String getOrganName() {
        return organ.getOrganName();
    }

    public void setLinkPhone(String linkPhone) {
        organ.setLinkPhone(linkPhone);
    }

    public void setOrganAddress(String organAddress) {
        organ.setOrganAddress(organAddress);
    }

    public String getLinkPhone() {
        return organ.getLinkPhone();
    }

    public String getOrganShortName() {
        return organ.getOrganShortName();
    }

    public String getOrganAddress() {
        return organ.getOrganAddress();
    }

    public String getOrganMemo() {
        return organ.getOrganMemo();
    }

    public void setOrganShortName(String organShortName) {
        organ.setOrganShortName(organShortName);
    }

    public Long getOrganParent() {
        return organ.getOrganParent();
    }

    public void setOrganCode(String organCode) {
        organ.setOrganCode(organCode);
    }

    public void setOrganName(String organName) {
        organ.setOrganName(organName);
    }

    public void setOrganMemo(String organMemo) {
        organ.setOrganMemo(organMemo);
    }

    public void setOrganParent(Long organParent) {
        organ.setOrganParent(organParent);
    }

    public void setLinkMan(String linkMan) {
        organ.setLinkMan(linkMan);
    }

    public void setCreateTime(Date createTime) {
        organ.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return organ.getUpdateTime();
    }

    public Date getCreateTime() {
        return organ.getCreateTime();
    }

    public Long getId() {
        return organ.getId();
    }

    public void setUpdateTime(Date updateTime) {
        organ.setUpdateTime(updateTime);
    }

    public void setId(Long id) {
        organ.setId(id);
    }
}
