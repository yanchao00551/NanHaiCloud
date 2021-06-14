package com.nanhai.modules.data.service;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.CollectTaskLandRs;
import com.nanhai.core.business.entity.CollectTaskLandUser;
import com.nanhai.core.business.entity.LandInfo;
import com.nanhai.core.business.vo.CollectTaskLandConditionVO;
import com.nanhai.core.persistence.beans.NhCollectTaskLand;
import com.nanhai.core.persistence.beans.NhPlanInfo;

import java.util.List;
import java.util.Map;

/**
 * @author luobo
 * @create 2021/5/29
 */
public interface NhCollectTaskLandService {
    /**
     * 批量插入任务地块关联
     * @param nhPlanInfo
     */
    void insertCollectTaskLand(NhPlanInfo nhPlanInfo);

    /***
     * 审核
     * @author 悟空
     * @description //TODO
     * @date 18:34 2021/5/29
     * @param landInfo
     */
    void updateAudit(Long[] landIds,String username,String auditMemo,Integer auditStatus);

    /**
     * 获取数据中心数据
     * @param vo
     * @return
     */
    PageInfo<NhCollectTaskLand> selectCollectTaskLandList(CollectTaskLandConditionVO vo);

   List< CollectTaskLandRs> getCollectPlanLandStatistics(Long planId);

    List<CollectTaskLandRs> getCollectPlanLandCondition( CollectTaskLandConditionVO collectTaskLandConditionVO);

    PageInfo<CollectTaskLandUser> selectCollectLandUserList(CollectTaskLandConditionVO vo);
}
