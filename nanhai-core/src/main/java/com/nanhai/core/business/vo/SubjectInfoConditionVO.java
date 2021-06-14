package com.nanhai.core.business.vo;

import com.nanhai.core.business.entity.LandSubject;
import com.nanhai.core.business.entity.SubjectInfo;
import com.nanhai.core.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Delegate;

import java.util.List;


/**
 * @author luobo
 * @create 2021/5/14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SubjectInfoConditionVO extends BaseConditionVO {


    private SubjectInfo subjectInfo;

    private LandSubject landSubject;

    private String administrativeCode;

    private Integer userLevel;

    private List<Integer> subjectIndustryList;

}
