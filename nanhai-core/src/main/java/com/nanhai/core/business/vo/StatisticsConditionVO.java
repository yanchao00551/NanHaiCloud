package com.nanhai.core.business.vo;

import com.nanhai.core.framework.object.BaseConditionVO;
import lombok.Data;

/**
 * @author luobo
 * @create 2021/6/2
 */
@Data
public class StatisticsConditionVO  extends BaseConditionVO {


    private String administrativeCode;
    private Integer userLevel;


    /**
     *   条件搜索镇编码
     */
    private String townCode;
    /**
     *   条件搜索镇编码
     */
    private String villageCode;

}
