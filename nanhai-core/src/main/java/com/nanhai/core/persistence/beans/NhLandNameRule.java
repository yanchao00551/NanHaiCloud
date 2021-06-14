package com.nanhai.core.persistence.beans;


import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

/**
 * 地块自动命名规则
 * @author luobo
 * @create 2021/5/7
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhLandNameRule  extends AbstractDO {


    /**
     * 镇 前缀 规则是否开启（0关闭1开启）
     */
    private Integer town;

    /**
     * 村 前缀 规则是否开启（0关闭1开启）
     */

    private Integer village;

    /**
     * 地块类型 前缀 规则是否开启（0关闭1开启）
     */

    private Integer landType;
    /**
     * 后缀 英文 规则是否开启（0关闭1开启）
     */

    private Integer en;
    /**
     * 后缀数字 规则是否开启（0关闭1开启）
     */

    private Integer num;

    /**
     * 规则是否开启
     */
    private Integer ruleNameStatus;
}
