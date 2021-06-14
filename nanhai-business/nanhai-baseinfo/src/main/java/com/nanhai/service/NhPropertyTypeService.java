package com.nanhai.service;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.PropertyType;
import com.nanhai.core.business.vo.PropertyTypeConditionVO;
import com.nanhai.core.framework.object.AbstractService;
import com.nanhai.core.persistence.beans.NhPropertyType;
import com.nanhai.core.persistence.beans.NhUsers;

/**
 * @author 杨默
 * @date 2021/5/15 9:28
 * @Description
 */
public interface NhPropertyTypeService  {

    public PageInfo<NhPropertyType> selectByPage(NhPropertyType conditionVO);

    /**
     * 新增属性类别
     * @param propertyType
     * @return
     */
    int insertPropertyType(NhPropertyType propertyType);

    /**
     * 根据主键id删除属性类别
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 根据主键id修改属性类别
     * @param propertyType
     * @return
     */
    int updateById(NhPropertyType propertyType);

    /**
     * 根据主键id查询属性类别
     * @param id
     * @return
     */
    NhPropertyType selectById(String id);

}
