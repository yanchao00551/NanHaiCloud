package com.nanhai.modules.data.mapper;


import com.nanhai.core.business.entity.LandSubject;
import com.nanhai.core.business.entity.LandSubjectRs;
import com.nanhai.core.business.vo.LandSubjectConditionVO;
import com.nanhai.core.persistence.beans.NhLandInfo;
import com.nanhai.core.persistence.beans.NhLandSubject;
import com.nanhai.core.plugin.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author luobo
 * @create 2021/5/18
 */
@Repository
public interface NhLandSubjectMapper extends BaseMapper<NhLandSubject> {

    @Select("SELECT * FROM land_subject WHERE ls_plan_id = #{plan_id}")
    @Results(id = "aaa", value = {
            @Result(property = "lsSubjectYearValue",column = "ls_year_value")

    })
    List<LandSubject> selectAllLandSubjectByPlanInfoId(@Param("plan_id") Long planId);

    @Delete("DELETE FROM land_subject WHERE ls_plan_id = #{plan_id}")
    int myDeleteById(@Param("plan_id") Long landPlanId);


/*
    @Select(" select * " +
            " from land_info li,subject_info si " +
            " where li.land_plan_id = si.subject_plan_id " +
            " and li.land_plan_id = #{plan_id} " +
            " and si.subject_plan_id = #{plan_id} ")
    @Results(id = "get", value = {
            @Result(property = "landInfo", column = "land_plan_id", many =
            @Many(select = "cn.gov.nanhai.fishing.mapper.LandInfoMapper.selectLandInfoAllByPlanId")),

            @Result(property = "SubjectInfo", column = "land_plan_id", many =
            @Many(select = "cn.gov.nanhai.fishing.mapper.SubjectInfoMapper.selectSubjectInfoAllByPlanId"))
    })
    List<ReleaseTaskVo> get(@Param("plan_id") Long planId);
*/


    @Insert(" INSERT into land_subject(ls_plan_id,ls_land_code,ls_subject_code,ls_subject_use_area,ls_year_value) " +
            " SELECT #{plan_id},ls_land_code,ls_subject_code,ls_subject_use_area,ls_year_value " +
            " from land_subject " +
            " where ls_plan_id = #{old_plan_id} ")
    int insertRelease(@Param("plan_id") Long planId, @Param("old_plan_id") Long oldPlanId);


    @Select("select  ls.ls_subject_code,l.land_type,sum(ls.ls_subject_use_area)  'sumArea',count(*)  'count'  from land_subject ls join land_info l on ls.ls_land_code=l.land_code  where ls.ls_subject_code=#{subjectCode}    GROUP BY ls.ls_subject_code, l.land_type"
            )
    @Results(id = "selectPageByVillage", value = {
            @Result(property = "subjectCode", column = "ls_subject_code"),
    })
    List<NhLandSubject> selectSubjectLand(String subjectCode);


    /**
     * 根据主体编码获取地块信息
     * @param subjectCode
     * @return
     */
    @Select("select l.land_name,l.land_code,l.land_id,l.land_village_code,l.land_town_code,l.land_type from land_info l join land_subject ls on l.land_code=ls.ls_land_code where ls.ls_subject_code=#{subjectCode}")
    List<NhLandInfo> getLandInfoListBySubjectCode(String subjectCode);




    List<LandSubjectRs> findLandSubject1( @Param("lsSubjectCode") String lsSubjectCode, @Param("lsLandCode")String lsLandCode);





    /**
     * 根据地块编号查询主体与地块的关联信息
     * @param landCode
     */
    List<NhLandSubject> selectLandSubjectByLandCode(String landCode);



    int updateLandSubjectByLandCode(NhLandSubject nhLandSubject);



 //   List<NhLandSubject> selectLandSubject(LandSubjectConditionVO vo);
}
