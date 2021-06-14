package com.nanhai.modules.sys.mapper;


import com.nanhai.core.business.vo.OrganConditionVO;
import com.nanhai.core.persistence.beans.NhOrgan;
import com.nanhai.core.plugin.BaseMapper;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @author luobo
 * @create 2021/5/8
 */
@Repository
public interface NhOrganMapper extends BaseMapper<NhOrgan> {

    /**
     * 分页查询组织机构信息
     * @param vo
     * @return
     */
    List<NhOrgan> findByCondition(OrganConditionVO vo);

}
