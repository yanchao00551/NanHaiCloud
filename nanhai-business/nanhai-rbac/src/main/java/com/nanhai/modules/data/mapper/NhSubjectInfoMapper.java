package com.nanhai.modules.data.mapper;




import com.nanhai.core.business.entity.Statistics;
import com.nanhai.core.business.vo.StatisticsConditionVO;
import com.nanhai.core.business.vo.SubjectInfoConditionVO;
import com.nanhai.core.persistence.beans.NhSubjectInfo;
import com.nanhai.core.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luobo
 * @create 2021/5/14
 */
@Repository
public interface NhSubjectInfoMapper extends BaseMapper<NhSubjectInfo> {
    List<NhSubjectInfo> findPageBreakByCondition(SubjectInfoConditionVO subjectInfoConditionVO);

    /**
     * 主体数据统计
     * @param vo 哈哈
     * @return
     */
    List<Statistics> subjectTypeStatistics(StatisticsConditionVO vo);

}
