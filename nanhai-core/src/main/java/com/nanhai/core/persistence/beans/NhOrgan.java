package com.nanhai.core.persistence.beans;

import com.nanhai.core.business.entity.AdministrativeArea;
import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.util.List;

/**
 * @author 杨默
 * @date 2021/5/19 18:30
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhOrgan extends AbstractDO {

    @Getter
    @Setter
    private List<NhOrgan> children;
    /**
     * 组织机构编号
     */
    private String organCode;
    /**
     * 组织机构名称
     */
    private String organName;
    /**
     * 组织机构联系人
     */
    private String linkMan;
    /**
     * 组织机构联系人电话
     */
    private String linkPhone;
    /**
     * 组织机构简称
     */
    private String organShortName;
    /**
     * 组织机构地址
     */
    private String organAddress;
    /**
     * 组织机构描述
     */
    private String organMemo;
    /**
     * 组织机构所属上级机构
     */
    private Long organParent;

    /**
     * 省级编码
     * @author 悟空
     * @description //TODO
     * @date 19:53 2021/6/11
     * @param null
     * @return null
     */
    @Transient
    private Integer provinceCode;

    /**
     * 市编码
     * @author 悟空
     * @description //TODO
     * @date 19:53 2021/6/11
     * @param null
     * @return null
     */
    @Transient
    private  Integer cityCode;


    /**
     * 区编码
     * @author 悟空
     * @description //TODO
     * @date 19:54 2021/6/11
     * @param null
     * @return null
     */
    @Transient
    private Integer areaCode;


    /**
     * 详细地址门牌号
     * @author 悟空
     * @description //TODO
     * @date 19:55 2021/6/11
     * @param null
     * @return null
     */
    @Transient
    private String detailAddress;

}
