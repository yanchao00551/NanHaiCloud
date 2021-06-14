package com.nanhai.modules.data.service;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.LandInfo;
import com.nanhai.core.business.vo.LandSubjectConditionVO;
import com.nanhai.core.persistence.beans.NhLandInfo;

/**
 * @author luobo
 * @create 2021/5/18
 */
public interface NhLandInfoService {
    /**
     * 获取地块信息列表
     * @param
     * @return
     */
    PageInfo<NhLandInfo> findPageBreakByCondition(LandSubjectConditionVO landSubjectConditionVO);


    /**
     * 根据地块编号查询主体信息
     * @param landCode
     * @return
     */
    //SubjectInfo selectSubjectIdByLandId(String landCode);


    /**
     * 根据地块编号审核修改审核状态码
     * @param landInfo
     * @return
     */
    void auditLandInfo(LandInfo landInfo);


    void updateLandInfo(LandInfo landInfo);


    /**
     * 采集人员修改地块
     * 先存入地块计划关联表
     * @param landInfo
     */
    void collectLandInfo(LandInfo landInfo);

}
