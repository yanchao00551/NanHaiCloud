package com.nanhai.core.persistence.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author 杨默
 * @date 2021/5/15 9:39
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhPropertyType {

    /**
     * 属性类别编号
     */
    @Id
    private String ptCode;
    /**
     * 属性类别名称
     */
    private String propertyTypeName;

    /**
     * 属性类别说明
     */
    private String propertyTypeMemo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    @Transient
    private Integer pageNumber;
    @Transient
    private Integer pageSize;
}
