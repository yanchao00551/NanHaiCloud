package com.nanhai.mapper;



import com.nanhai.core.business.entity.CollectTask;
import com.nanhai.core.business.vo.CollectTaskConditionVO;
import com.nanhai.core.persistence.beans.NhCollectTask;
import com.nanhai.core.persistence.beans.NhPlanInfo;
import com.nanhai.core.plugin.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NhCollectTaskMapper extends BaseMapper<NhCollectTask> {
    /**
     * 分页查询，关联查询文章标签、文章类型
     *
     * @param vo
     * @return
     */
    List<NhCollectTask> findPageBreakByCondition(CollectTaskConditionVO vo);


    /**
     * 统计指定任务的计划集合
     * @author 悟空
     * @description //TODO
     * @date 14:31 2021/5/15
     * @param ids
     * @return java.util.List<com.nanhai.core.persistence.beans.NhPlanInfo>
     */
    List<NhCollectTask> listTaskPlanInfosByPlanId(List<Long> list);

}
