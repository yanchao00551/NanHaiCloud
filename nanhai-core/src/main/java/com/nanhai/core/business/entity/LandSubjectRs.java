package com.nanhai.core.business.entity;

import lombok.Data;

/**
 * @author luobo
 * @create 2021/5/17
 */
@Data
public class LandSubjectRs {
     private String landSubjectId;
     private String subjectCode;
     private String subjectName;
     private String subjectBase;
     private int landType;
     private int count;
     private  double lsSubjectUseArea;
     private Double lsYearValue;
}
