package com.nanhai.core.business.vo;

import com.nanhai.core.business.entity.ProductType;
import com.nanhai.core.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 杨默
 * @date 2021/6/7 20:52
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductTypeConditionVO  {
    private ProductType productType;
}
