package com.nanhai.modules.data.service.impl;

import com.nanhai.core.business.entity.Statistics;
import com.nanhai.core.business.vo.StatisticsConditionVO;
import com.nanhai.core.framework.object.SsoUser;
import com.nanhai.core.persistence.beans.NhLandInfo;
import com.nanhai.core.persistence.beans.NhSubjectInfo;
import com.nanhai.modules.data.mapper.NhLandInfoMapper;
import com.nanhai.modules.data.mapper.NhSubjectInfoMapper;
import com.nanhai.modules.data.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luobo
 * @create 2021/6/2
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    NhLandInfoMapper nhLandInfoMapper;
    @Autowired
    NhSubjectInfoMapper nhSubjectInfoMapper;

    @Override
    public Map<String, Object> getStatistics(StatisticsConditionVO vo) {
        Map<String, Object> resultMap = new HashMap<>(15);
        List<Map> resultList1 = new ArrayList<>();
        List<Map> resultList2 = new ArrayList<>();
        List<Map> resultList3 = new ArrayList<>();
        List<Map> resultList4 = new ArrayList<>();

        List<Statistics> res = nhLandInfoMapper.landTypeStatistics(vo);
        for (Statistics statistics : res) {
            Map<String, Object> map1 = new HashMap<>(10);
            map1.put("name", statistics.getLandTypeName());
            map1.put("value", statistics.getLandCount());
            resultList1.add(map1);
            Map<String, Object> map2 = new HashMap<>(10);
            map2.put("name", statistics.getLandTypeName());
            map2.put("value", statistics.getMu());
            resultList2.add(map2);
            Map<String, Object> map4 = new HashMap<>(10);
            map4.put("name", statistics.getLandTypeName());
            map4.put("value", statistics.getLandYearValue());
            resultList4.add(map4);
        }
        List<Statistics> res2 = nhSubjectInfoMapper.subjectTypeStatistics(vo);
        for (Statistics statistics : res2) {
            Map<String, Object> map3 = new HashMap<>(10);
            map3.put("name", statistics.getSubjectTypeName());
            map3.put("value", statistics.getSubjectCount());
            resultList3.add(map3);
        }
        resultMap.put("list1", resultList1);
        resultMap.put("list2", resultList2);
        resultMap.put("list3", resultList3);
        resultMap.put("list4", resultList4);

        return resultMap;
    }
}
