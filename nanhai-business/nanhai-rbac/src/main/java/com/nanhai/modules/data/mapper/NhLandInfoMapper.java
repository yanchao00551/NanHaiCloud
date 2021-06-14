package com.nanhai.modules.data.mapper;


import com.nanhai.core.business.entity.Statistics;
import com.nanhai.core.business.vo.LandSubjectConditionVO;
import com.nanhai.core.business.vo.StatisticsConditionVO;
import com.nanhai.core.framework.object.SsoUser;
import com.nanhai.core.persistence.beans.NhLandInfo;

import com.nanhai.core.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author luobo
 * @create 2021/5/18
 */
@Repository
public interface NhLandInfoMapper extends BaseMapper<NhLandInfo> {

    List<NhLandInfo> findPageBreakByCondition( LandSubjectConditionVO landSubjectConditionVO);

    /**
     * 二级地类数据统计
     * @param vo 哈哈
     * @return
     */
    List<Statistics> landTypeStatistics(StatisticsConditionVO vo);
}
