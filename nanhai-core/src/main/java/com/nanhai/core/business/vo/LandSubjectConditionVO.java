package com.nanhai.core.business.vo;

import com.nanhai.core.business.entity.LandInfo;
import com.nanhai.core.business.entity.LandSubject;
import com.nanhai.core.framework.object.BaseConditionVO;
import com.nanhai.core.persistence.beans.NhLandInfo;
import lombok.Data;

/**
 * @author luobo
 * @create 2021/5/18
 */
@Data
public class LandSubjectConditionVO extends BaseConditionVO {
    private LandSubject landSubject;
    private LandInfo landInfo;
    private String administrativeCode;
    private Integer userLevel;
    private String subjectName;
    private String[]  landCodes;
}
