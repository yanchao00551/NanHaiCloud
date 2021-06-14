package com.nanhai.modules.data.service;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.LandNameRule;
import com.nanhai.core.persistence.beans.NhLandNameRule;

/**
 * @author luobo
 * @create 2021/5/20
 */
public interface NhLandNameRuleService {
    PageInfo<NhLandNameRule> getLandNameRuleList();

    void updateLandNameRuleById(LandNameRule landNameRule);

    String getLandNameAuto(Long landId, String town, String village, String landType);
}
