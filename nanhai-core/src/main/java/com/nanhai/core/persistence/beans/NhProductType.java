package com.nanhai.core.persistence.beans;

import com.nanhai.core.framework.object.AbstractBO;
import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

/**
 * @author 杨默
 * @date 2021/6/7 20:37
 * @Description 农产品类别
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhProductType extends AbstractDO {

    @Getter
    @Setter
    private List<NhProductType> children;

    /**
     * 农产品类别编号
     */
    @Column(name = "product_type_code")
    private Long productTypeCode;

    /**
     * 农产品类别等级
     */
    @Column(name = "product_type_level")
    private Long productTypeLevel;

    /**
     * 农产品类别名
     */
    @Column(name = "product_type_name")
    private String productTypeName;

    /**
     * 父级农产品类别编号
     */
    @Column(name = "product_type_parent_code")
    private Long productTypeParentCode;
}
