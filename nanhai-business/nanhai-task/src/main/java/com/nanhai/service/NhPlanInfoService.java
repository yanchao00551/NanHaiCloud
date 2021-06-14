package com.nanhai.service;


import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.PlanInfo;
import com.nanhai.core.business.vo.CollectTaskConditionVO;
import com.nanhai.core.business.vo.PlanInfoConditionVO;
import com.nanhai.core.framework.object.AbstractService;

public interface NhPlanInfoService extends AbstractService<PlanInfo,Long> {
    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<PlanInfo> findPageBreakByCondition(PlanInfoConditionVO vo);


    /**
     * 根据计划id查询任务
     * @author 悟空
     * @description //TODO
     * @date 16:40 2021/5/15
     * @param vo
     * @return com.github.pagehelper.PageInfo<com.nanhai.core.business.entity.PlanInfo>
     */
    PageInfo<PlanInfo> findPlanAccordingToTheTask(PlanInfoConditionVO vo);


    /**
     * 创建计划任务
     * @author 悟空
     * @description //TODO
     * @date 21:52 2021/5/21
     * @param planInfo
     * @return java.lang.Boolean
     */
    int createPlan(PlanInfo planInfo);


    /**
     * 修改计划任务
     * @author 悟空
     * @description //TODO
     * @date 21:53 2021/5/21
     * @param planInfo
     * @return java.lang.Boolean
     */
    Boolean updatePlan(PlanInfo planInfo);

    /**
     * 修改计划状态
     * @author 悟空
     * @description //TODO
     * @date 22:52 2021/5/21
     * @param id
     * @param status
     * @return boolean
     */
    boolean setStatus(Long id, Integer status,String username);

    /**
     * 查询我的任务
     * luobo
     * @param vo
     * @return
     */
    PageInfo<PlanInfo> queryMyPlan(PlanInfoConditionVO vo);
}
