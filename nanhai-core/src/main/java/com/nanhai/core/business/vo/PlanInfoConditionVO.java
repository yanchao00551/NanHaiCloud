package com.nanhai.core.business.vo;

import com.nanhai.core.business.entity.PlanInfo;
import com.nanhai.core.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * @PackageName:com.nanhai.core.business.vo
 * @ClassName:PlanInfoConditionVO
 * @Description:
 * @author: 悟空
 * @date: 2021/5/13 20:29
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PlanInfoConditionVO extends BaseConditionVO {
    private PlanInfo planInfo;
    private List<Long> planInfoIds;
    private String userLevel;
    private String administrativeCode;
    private Long status;
    /**
     * 是否到期  1已到期
     */
    private int isExpire;

    /**
     * 当前时间
     */
    private String time;
}
