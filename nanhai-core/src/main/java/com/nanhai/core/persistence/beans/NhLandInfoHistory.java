package com.nanhai.core.persistence.beans;


import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 地块信息->历史采集
 * @author luoboz
 * @创建时间 2021/5/13
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhLandInfoHistory extends AbstractDO {

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

    private double landArea;
    /**
     * 地块类型
     */
    private int landType;
    /**
     * 其他类型
     */
    private String landOtherType;

    /**
     * 年产量
     */
    private double landYearOutput;
    /**
     * 产量单位
     */
    private String landOutputUnit;
    /**
     * 农产品类别
     */
    private int landProduct;
    /**
     * 年产值
     */
    private double landYearValue;
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
    private Date auditDate;

    /**
     * 审核批注
     */
    private String auditMemo;
    /**
     * 审核状态
     */

    private Integer auditStatus;




}
