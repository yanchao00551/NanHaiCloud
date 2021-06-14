package com.nanhai.core.persistence.beans;


import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nanhai.core.business.entity.LandSubjectRs;
import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.security.acl.Group;
import java.util.Date;
import java.util.List;

/**
 * 地块信息
 *
 * @author luoboz
 * @创建时间 2021/5/13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhLandInfo extends AbstractDO {


    @Transient
    private List<LandSubjectRs> landSubjectRs;

    @Transient
    private JSONArray ossImgList;

    @Transient
    private String subjectNames;

    @Transient
    private String landPlanName;

    /**
     * 地块编码
     */
    private String landCode;

    /**
     * 地块名称
     */
    private String landName;
    /**
     * 地块面积
     */

    private BigDecimal landArea;
    /**
     * 地块类型
     */
    private Integer landType;

    /**
     * 地块类型名称
     */
    @Transient
    private String landTypeName;


    /**
     * 其他类型
     */
    private String landOtherType;

    /**
     * 年产量
     */
    @Column(name = "land_year_output")
    private Double landYearOutput;
    /**
     * 产量单位
     */
    private String landOutputUnit;
    /**
     * 农产品类别
     */
    private Integer landProduct;
    /**
     * 年产值
     */
    private Double landYearValue;
    /**
     * 所属计划编号
     */
    private Long landPlanId;
    /**
     * 地块备注
     */
    private String landMemo;
    /**
     * 地块所属镇行政区划编码
     */
    private String landTownCode;
    /**
     * 地块所属村庄区划编码
     */
    private String landVillageCode;

    /**
     * 创建人
     */
    private String createPerson;

    /**
     * 更新人
     */
    private String updatePerson;

    /**
     * 审核人
     */
    private String auditPerson;

    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditDate;

    /**
     * 审核批注
     */
    private String auditMemo;
    /**
     * 审核状态
     */

    private Integer auditStatus;

    private String imgUrl;

    private Integer landNameTailType;




    /**
     * 采集状态（0未采集1已采集）

     */

    private Integer collectStatus;


    /**
     * 镇名称
     */

    private String landTownName;

    /**
     * 村名称
     */

    private String landVillageName;


    /**
     *一级分类名称
     */
    private  String levelOneType;

    /**
     *一级分类名称
     */
    private  String levelTwoType;


    /**
     * 作物名称
     */
    private String landProduce;


    /**
     * GBZNTLSID（高标准农田历史ID）
     */
    private String highStandardFarmlandHistoryId;

    /**
     * SFGBZNT（是否高标准农田）
     */
    private String isHighStandardFarmland;


    /**
     * SFLSSCGNQ（是否粮食生产功能区）
     */
    private String isLsscq;


    /**
     * YTLSID（鱼塘历史ID）
     */
    private String fishHistoryId;


    /**
     * 亩
     */
    private BigDecimal mu;
}
