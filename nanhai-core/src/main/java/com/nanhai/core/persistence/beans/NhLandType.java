package com.nanhai.core.persistence.beans;

import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.List;

/**
 * 地块类型
 *
 * @author luobo
 * @create 2021/5/13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhLandType extends AbstractDO {
    @Transient
    private List<NhLandType> children;
    /**
     * 地块类别业务编号
     */
    @Column(name = "land_type_code")
    private Integer landTypeCode;

    /**
     * 地块类别级别
     */
    @Column(name = "land_type_level")
    private Integer landTypeLevel;

    /**
     * 地块类别名
     */
    @Column(name = "land_type_name")
    private String landTypeName;

    /**
     * 父级类型id
     */
    @Column(name = "land_type_parent_code")
    private Integer landTypeParentCode;


}
