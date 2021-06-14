package com.nanhai.core.persistence.beans;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.*;

/**
 * @PackageName:com.nanhai.core.persistence.beans
 * @ClassName:NhCollectTaskLand
 * @Description:
 * @author: 悟空
 * @date: 2021/5/29 15:03
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhCollectTaskLand extends AbstractDO {

    @Transient
    private JSONArray ossImgList;

    @Transient
    private String planName;

    @Transient
    private String subjectNames;
    private String landName;

    @Transient
    private String landTypeName;


    @Transient
    private String landProductName;
    /**
     * 计划ID
     *
     * @author 悟空
     * @description //TODO
     * @date 15:04 2021/5/29
     * @param null
     * @return null
     */
    private Long planId;

    /**
     * 地块ID
     *
     * @author 悟空
     * @description //TODO
     * @date 15:04 2021/5/29
     * @param null
     * @return null
     */
    private String landId;


    /**
     * 地块类型
     *
     * @author 悟空
     * @description //TODO
     * @date 15:05 2021/5/29
     * @param null
     * @return null
     */
    private Integer landType;


/*
    */
/**
     * 地块类型名称
     *//*

    private String landTypeName;
*/

    /**
     * 农产品类型
     *
     * @author 悟空
     * @description //TODO
     * @date 15:05 2021/5/29
     * @param null
     * @return null
     */
    private Integer landProduct;


    /**
     * 作物
     *
     * @author 悟空
     * @description //TODO
     * @date 15:06 2021/5/29
     * @param null
     * @return null
     */
    private String landProduce;


    /**
     * 品种
     *
     * @author 悟空
     * @description //TODO
     * @date 15:07 2021/5/29
     * @param null
     * @return null
     */
    private String landOtherType;


    /**
     * 面积(亩)
     *
     * @author 悟空
     * @description //TODO
     * @date 15:07 2021/5/29
     * @param null
     * @return null
     */
    private BigDecimal landProductArea;


    /**
     * 年产值(万元)
     *
     * @author 悟空
     * @description //TODO
     * @date 15:07 2021/5/29
     * @param null
     * @return null
     */
    private Double landYearValue;


    /**
     * 创建人
     *
     * @author 悟空
     * @description //TODO
     * @date 15:08 2021/5/29
     * @param null
     * @return null
     */
    private String createPerson;

    /**
     * 更新人
     *
     * @author 悟空
     * @description //TODO
     * @date 15:08 2021/5/29
     * @param null
     * @return null
     */
    private String updatePerson;


    /**
     * 审核人
     *
     * @author 悟空
     * @description //TODO
     * @date 15:09 2021/5/29
     * @param null
     * @return null
     */
    private String auditPerson;


    /**
     * 审核时间
     *
     * @author 悟空
     * @description //TODO
     * @date 15:09 2021/5/29
     * @param null
     * @return null
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditDate;


    /**
     * 审核状态
     *
     * @author 悟空
     * @description //TODO
     * @date 15:10 2021/5/29
     * @param null
     * @return null
     */
    private Integer auditStatus;


    /**
     * 审核意见
     *
     * @author 悟空
     * @description //TODO
     * @date 15:10 2021/5/29
     * @param null
     * @return null
     */
    private String auditMemo;

    /**
     * 采集状态0默认 1未采集 2已采集
     */
    private Integer collectStatus;


    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 年产值
     */
    private Double landYearOutput;
    /**
     * 年产值单位
     */
    private String landOutputUnit;


    private String landTownCode;

    private String landVillageCode;

    private String landTownName;

    private String landVillageName;
}
