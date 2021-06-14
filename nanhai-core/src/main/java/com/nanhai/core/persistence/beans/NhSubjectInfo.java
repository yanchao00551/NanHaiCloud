package com.nanhai.core.persistence.beans;



import com.alibaba.fastjson.JSONArray;

import com.nanhai.core.business.entity.LandSubjectRs;
import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 *
 *主体信息
 * @author luobo
 * @create 2021/5/13
 */


@Data
@EqualsAndHashCode(callSuper = false)
public class NhSubjectInfo extends AbstractDO {



    @Transient
    private List<LandSubjectRs> landSubjectRs;

    @Transient
    private JSONArray ossImgList;
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

    private String subjectTownId;
    /**
     * 所属村
     */
    private String subjectVillageId;
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
     * 个体 合作社 企业
     * 主体类型  类型只能是1或2或3
     */
    private Integer subjectType;

    /**
     * 主体行业
     */

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
     * 创建人
     */

    private String createPerson;

    /**
     * 更新人
     */
    private String updatePerson;



    /**
     * 审核状态
     */

    private Integer auditStatus;

    /**
     * 审核人
     */
    private String auditPerson;

    /**
     * 审核日期
     */
    private Date auditDate;

    /**
     * 审核批注
     */
    private String auditMemo;


    /**
     * 资源路径
     */
    private String imgUrl;

    /**
     * 所属镇 名称
     */
    @Transient
    private String subjectTownName;
    /**
     * 所属村 名称
     */
    @Transient

    private String subjectVillageName;
}
