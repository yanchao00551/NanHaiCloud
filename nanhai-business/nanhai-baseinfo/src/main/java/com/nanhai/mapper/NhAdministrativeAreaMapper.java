package com.nanhai.mapper;

import com.nanhai.core.business.entity.AdministrativeArea;
import com.nanhai.core.business.vo.AdministrativeAreaConditionVO;
import com.nanhai.core.business.vo.PlanInfoConditionVO;
import com.nanhai.core.persistence.beans.NhAdministrativeArea;
import com.nanhai.core.persistence.beans.NhPlanInfo;
import com.nanhai.core.plugin.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhAdministrativeAreaMapper extends BaseMapper<NhAdministrativeArea> {

    /**
     * 条件查询
     *
     * @param vo
     * @return
     */
    List<NhAdministrativeArea> findByCondition(AdministrativeAreaConditionVO vo);


    List<NhAdministrativeArea> selectAllSelect(@Param("townIds") List<String> townIds, @Param("villageIds") List<String> villageIds);
}
