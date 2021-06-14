package com.nanhai.core.business.vo;

import com.nanhai.core.business.entity.PropertyType;
import com.nanhai.core.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 杨默
 * @date 2021/5/15 9:46
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PropertyTypeConditionVO extends BaseConditionVO {
    private PropertyType propertyType;
}
