package com.nanhai.core.persistence.beans;


import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 *
 *
 * @author luobo
 * @create 2021/5/13
 * @Description 主体 年产值关系表
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhSubjectYearTotalValue extends AbstractDO {

    /**
     * 主体编号
     */

    private String sytvSubjectCode;


    /**
     * 年份
     */

    private Integer sytvYear;
    /**
     * 年产值（万元）
     */

    private Double sytvYearTotalValue;


}
