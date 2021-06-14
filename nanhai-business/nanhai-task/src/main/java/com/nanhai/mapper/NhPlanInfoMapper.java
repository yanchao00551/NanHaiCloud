package com.nanhai.mapper;


import com.nanhai.core.business.entity.PlanInfo;
import com.nanhai.core.business.vo.PlanInfoConditionVO;
import com.nanhai.core.persistence.beans.NhPlanInfo;
import com.nanhai.core.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface NhPlanInfoMapper extends BaseMapper<NhPlanInfo> {
    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    List<NhPlanInfo> findPageBreakByCondition(PlanInfoConditionVO vo);


    List<NhPlanInfo> findPlanAccordingToTheTask(PlanInfoConditionVO vo);

    List<NhPlanInfo> listPlanInfosTaskByPlanId(List<Long> list);

    List<NhPlanInfo> queryMyPlan(PlanInfoConditionVO vo);





}
