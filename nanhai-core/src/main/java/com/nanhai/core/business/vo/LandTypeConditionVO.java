package com.nanhai.core.business.vo;

import com.nanhai.core.business.entity.LandType;
import com.nanhai.core.business.entity.PropertyType;
import com.nanhai.core.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 杨默
 * @date 2021/6/9 14:22
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LandTypeConditionVO extends BaseConditionVO {
    private LandType landType;
}
