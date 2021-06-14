package com.nanhai.core.persistence.beans;

import com.nanhai.core.framework.object.AbstractDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author luobo
 * @create 2021/5/13
 * @Description:主体地块关联表
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhLandSubject  extends AbstractDO {

    /**
     * 所属计划主键
     */
    private Long lsPlanId;
    /**
     * 所属地块编码
     */
    private String lsLandCode;
    /**
     * 所属主体编码
     */
    private String lsSubjectCode;

    /**
     *   主体使用面积
     */
    private Double lsSubjectUseArea ;
    /**
     *   年产值
     */

    private Double lsYearValue ;


    /**
     * 审核状态
     */
    private Integer auditStatus;



}
