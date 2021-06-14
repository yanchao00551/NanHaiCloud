package com.nanhai.core.persistence.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author 杨默
 * @date 2021/5/16 16:40
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhPropertyValue  {

    /**
     * 属性id
     */
    @Id
    private String pvCode;

    /**
     * 属性类别id
     */
    private String ptCode;

    /**
     * 属性值
     */
    private String propertyValue;


    /**
     * 属性值说明
     */
    private String propertyValueMemo;

    /**
     * 属性分类名
     */
    @Transient
    private String propertyTypeName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    @Transient
    private Integer pageNumber;
    @Transient
    private Integer pageSize;
}
