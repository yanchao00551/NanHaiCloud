package com.nanhai.core.business.vo;

import com.nanhai.core.business.entity.PropertyValue;
import com.nanhai.core.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 杨默
 * @date 2021/5/16 16:43
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PropertyValueConditionVO extends BaseConditionVO {
    private PropertyValue propertyValue;
    private Integer propertyTypeId;

}
