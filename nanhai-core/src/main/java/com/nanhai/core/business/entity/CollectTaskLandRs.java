package com.nanhai.core.business.entity;

import lombok.Data;

import java.util.List;

/**
 * @author luobo
 * @create 2021/6/4
 */
@Data
public class CollectTaskLandRs {
    private Integer collectStatus;
    private Integer auditStatus;
    private Long planId;
    private Integer count=0;
    private Integer count2=0;
    private Integer count3=0;
    private Integer collectNum=0;
    private Integer noCollectNum=0;
    private Integer auditStatusNum=0;
    private Integer total=0;


    private String collectTaskTownId;
    /**
     *     区划名字
     */
    private String areaCode;
    /**
     *     区划名字
     */
    private String areaName;



    private List<CollectTaskLandRs> children;
    //private String categotiesList;


}
