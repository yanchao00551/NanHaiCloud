package com.nanhai.core.business.vo;

import com.nanhai.core.business.entity.CollectTaskLand;
import com.nanhai.core.business.entity.LandInfo;
import com.nanhai.core.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @PackageName:com.nanhai.core.business.vo
 * @ClassName:CollectTaskLandConditionVO
 * @Description:
 * @author: 悟空
 * @date: 2021/5/29 15:14
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CollectTaskLandConditionVO extends BaseConditionVO {
    private CollectTaskLand collectTaskLand;
    private LandInfo landInfo;
    private List<Long> ids;
    private String administrativeCode;
    private Integer userLevel;
    private String subjectName;
    private String keywords;
    private String landTownCode;
    private List<String> areaCode;
    private String[]  landCodes;
}
