package com.nanhai.service;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.LandType;
import com.nanhai.core.business.vo.LandTypeConditionVO;
import com.nanhai.core.framework.object.AbstractService;
import com.nanhai.core.persistence.beans.NhLandType;

public interface NhLandTypeService extends AbstractService<NhLandType, Long> {
    PageInfo<NhLandType> findByCondition(LandTypeConditionVO vo);

}
