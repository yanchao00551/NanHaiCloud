package com.nanhai.core.persistence.beans;

import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 主体地块关联表->历史信息
 * @author luobo
 * @create 2021/5/13
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhLandSubjectHistory extends AbstractDO {

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

    private Double lsSubjectYearValue ;



}
