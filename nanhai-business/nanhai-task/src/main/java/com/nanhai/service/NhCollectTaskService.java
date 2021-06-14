package com.nanhai.service;


import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.AdministrativeArea;
import com.nanhai.core.business.entity.CollectTask;
import com.nanhai.core.business.vo.CollectTaskConditionVO;
import com.nanhai.core.framework.object.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;



public interface NhCollectTaskService extends AbstractService<CollectTask,Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<CollectTask> findPageBreakByCondition(CollectTaskConditionVO vo);


    /**
     * 根据计划查询多个任务（支持多个计划id）
     * @author 悟空
     * @description //TODO 
     * @date 14:26 2021/5/15
     * @param vo
     * @return java.util.List<com.nanhai.core.business.entity.CollectTask>
     */
    PageInfo<CollectTask> findTasksAccordingToPlan(CollectTaskConditionVO vo);

    /**
     * 根据任务id 修改任务
     * @param collectTask
     */
    void updateTask(CollectTask collectTask);
}
