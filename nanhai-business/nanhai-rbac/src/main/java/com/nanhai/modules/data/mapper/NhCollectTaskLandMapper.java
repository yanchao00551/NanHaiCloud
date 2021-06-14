package com.nanhai.modules.data.mapper;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.CollectTaskLandRs;
import com.nanhai.core.business.entity.CollectTaskLandUser;
import com.nanhai.core.business.vo.CollectTaskLandConditionVO;
import com.nanhai.core.persistence.beans.NhCollectTaskLand;
import com.nanhai.core.plugin.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author luobo
 * @create 2021/5/29
 */
@Repository
@Mapper
public interface NhCollectTaskLandMapper  extends BaseMapper<NhCollectTaskLand> {
    List<NhCollectTaskLand> findPageBreakByCondition(CollectTaskLandConditionVO vo);


    CollectTaskLandRs getCollectPlanLandStatistics(Long planId);


    List<CollectTaskLandRs> getCollectPlanLandCondition(CollectTaskLandConditionVO collectTaskLandConditionVO);


    List<CollectTaskLandUser> findPageBreakByUserList(@Param("planId") Long planId,@Param("keywords") String keywords,@Param("areaCode")List<String> areaCode);

}
