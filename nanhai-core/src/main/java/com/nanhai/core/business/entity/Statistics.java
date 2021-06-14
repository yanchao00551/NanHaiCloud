package com.nanhai.core.business.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author luobo
 * @create 2021/6/2
 */
@Data
public class Statistics {

    private String  landTypeName;
    private String  subjectTypeName;
    private Long landCount;
    private Long subjectCount;
    private BigDecimal mu;
    private BigDecimal landYearValue;

}
