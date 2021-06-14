package com.nanhai.core.business.vo;

import com.nanhai.core.business.entity.CollectTask;
import com.nanhai.core.framework.object.BaseConditionVO;
import com.nanhai.core.framework.object.SsoUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @PackageName:com.nanhai.core.business.vo
 * @ClassName:CollectTaskConditionVO
 * @Description:
 * @author: 悟空
 * @date: 2021/5/13 20:17
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CollectTaskConditionVO extends BaseConditionVO {
    private CollectTask collectTask;
    private Long planInfoId;
    private List<Long> planInfoIds;
    private String userLevel;
    private String administrativeCode;
}
