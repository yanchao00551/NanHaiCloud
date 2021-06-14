package com.nanhai.modules.sys.service;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.Organ;
import com.nanhai.core.business.vo.OrganConditionVO;
import com.nanhai.core.framework.object.AbstractService;
import com.nanhai.core.persistence.beans.NhOrgan;

/**
 * @author luobo
 * @create 2021/5/20
 */
public interface NhOrganService  {
    void putOrganById(Organ organ);

    void deleteOrganById(Long id);

    void add(Organ organ);

    PageInfo<NhOrgan> findByCondition(OrganConditionVO vo);
}
