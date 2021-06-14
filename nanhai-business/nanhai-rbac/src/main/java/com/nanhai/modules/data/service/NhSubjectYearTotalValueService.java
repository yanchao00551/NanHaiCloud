package com.nanhai.modules.data.service;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SubjectYearTotalValue;
import com.nanhai.core.business.vo.SubjectInfoConditionVO;
import com.nanhai.core.framework.object.AbstractService;
import com.nanhai.core.persistence.beans.NhSubjectYearTotalValue;

/**
 * @author luobo
 * @create 2021/5/15
 */
public interface NhSubjectYearTotalValueService  extends AbstractService<NhSubjectYearTotalValue,Long> {

    void insertSubjectYearTotalValue(SubjectYearTotalValue subjectYearTotalValue);

    void deleteSubjectYearTotalValue(Long subjectYearTotalValueId);

    void putSubjectYearTotalValue(SubjectYearTotalValue subjectYearTotalValue);

    PageInfo<NhSubjectYearTotalValue> findSubjectYearTotalValues(SubjectInfoConditionVO subjectInfoConditionVO);
}
