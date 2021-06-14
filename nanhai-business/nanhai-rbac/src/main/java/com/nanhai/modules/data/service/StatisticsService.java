package com.nanhai.modules.data.service;

import com.nanhai.core.business.vo.StatisticsConditionVO;
import com.nanhai.core.framework.object.SsoUser;

import java.util.List;
import java.util.Map;

/**
 * @author luobo
 * @create 2021/6/2
 */
public interface StatisticsService {
    Map<String ,Object> getStatistics(StatisticsConditionVO vo);
}
