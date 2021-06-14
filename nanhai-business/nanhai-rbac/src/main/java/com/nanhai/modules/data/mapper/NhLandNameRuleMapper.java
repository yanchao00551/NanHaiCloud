package com.nanhai.modules.data.mapper;

import com.nanhai.core.persistence.beans.NhLandNameRule;
import com.nanhai.core.plugin.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author luobo
 * @create 2021/5/20
 */
@Repository
public interface NhLandNameRuleMapper extends BaseMapper<NhLandNameRule> {
    @Select("select count(*) from nh_land_info where id!=#{landId} and land_name_tail_type=#{landNameTailType} and land_name  like concat(#{landName},'%')")
    int getLandInfoByLandName(@Param("landName") String landName, @Param("landNameTailType") Integer landNameTailType, @Param("landId") Long landId);
}
