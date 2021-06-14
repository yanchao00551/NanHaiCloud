package com.nanhai.core.persistence.beans;

import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

/**
 * @author 杨默
 * @date 2021/5/20 10:52
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhSubjectAuditInfo extends AbstractDO {

    /**
     * 主体信息 主键编号
     */
    private Long subjectId;
    /**
     * 主体编码
     */
    private String subjectCode;
    /**
     * 主体名称
     */
    private String subjectName;

    /**
     * 主体的基地
     */
    private String subjectBase;
    /**
     * 联系人
     */
    private String subjectLinkman;

    /**
     * 联系人 电话
     */
    private String subjectTele;
    /**
     * 联系人身份证号码
     */
    private String subjectCard;
    /**
     * 所属镇 (区域编码)
     */
    private Integer subjectTownId;
    /**
     * 所属村
     */
    private Integer subjectVillageId;
    /**
     * 地址
     */
    private String subjectAddr;

    /**
     * 产品供销类型
     */
    private String subjectBusiType;


    /**
     * 所属计划编号
     */
    private Long subjectPlanId;

    /**
     * 主要产品
     */
    private String subjectMainProduct;
    /**
     * 其他产品
     */
    private String subjectOtherProduct;


    /**
     * 主体类型
     */
    @Range(min = 1, max = 3, message = "类型只能是1或2或3")
    private Integer subjectType;

    /**
     * 主体行业
     */
    @Range(min = 1, max = 2, message = "类型只能是1或2")
    private Integer subjectIndustry;

    /**
     * 人数
     */
    private Integer subjectPersonNum;
    /**
     * 年产值（去年）
     */
    private Double subjectYearTotalValue;
    /**
     * 组织机构代码
     */
    private String subjectOrgCode;
    /**
     * 统一社会信用代码
     */
    private String subjectUscCode;
    /**
     * 简介
     */
    private String subjectIntro;

    /**
     * 审核人
     */
    private String  auditPerson;

    /**
     * 审核日期
     */
    private Date auditDate;

    /**
     * 审核说明
     */
    private String auditMemo;

    /**
     * 审核状态
     */
    private String auditStatus;
}
