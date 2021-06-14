package com.nanhai.modules.data.service;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SubjectInfo;
import com.nanhai.core.business.vo.SubjectInfoConditionVO;
import com.nanhai.core.framework.object.AbstractService;
import com.nanhai.core.framework.object.SsoUser;
import com.nanhai.core.persistence.beans.NhSubjectInfo;

/**
 * @author luobo
 * @create 2021/5/14
 */
public interface NhSubjectInfoService extends AbstractService<NhSubjectInfo,Long> {


    void insertSubjectInfo(SubjectInfo subjectInfo);

    PageInfo<NhSubjectInfo> findPageBreakByCondition(SubjectInfoConditionVO subjectInfoConditionVO, SsoUser parse);

    void updateSubjectInfo(SubjectInfo subjectInfo);
}
