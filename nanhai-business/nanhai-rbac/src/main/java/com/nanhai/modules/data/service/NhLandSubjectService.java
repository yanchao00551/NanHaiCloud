package com.nanhai.modules.data.service;


import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.LandSubject;
import com.nanhai.core.business.entity.LandSubjectRs;
import com.nanhai.core.business.vo.LandSubjectConditionVO;
import com.nanhai.core.persistence.beans.NhLandSubject;


import java.util.List;
/**
 * @author luobo
 * @create 2021/5/18
 */

public interface NhLandSubjectService {
    /**
     * 添加地块主体关联表
     * @param landSubject
     */
    void add(LandSubject landSubject);

    List<NhLandSubject> selectLandSubjectByLandCode(String landCode);

    int updateLandSubjectByLandCode(NhLandSubject nhLandSubject);

    void delete(Long id);

    void updateLandSubject(LandSubject landSubject);



    PageInfo<LandSubjectRs> selectLandSubject(LandSubjectConditionVO vo);

}
