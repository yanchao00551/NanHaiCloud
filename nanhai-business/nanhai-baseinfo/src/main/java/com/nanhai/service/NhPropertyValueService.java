package com.nanhai.service;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.PropertyType;
import com.nanhai.core.business.entity.PropertyValue;
import com.nanhai.core.business.vo.PropertyValueConditionVO;
import com.nanhai.core.framework.object.AbstractService;
import com.nanhai.core.persistence.beans.NhPropertyValue;

import java.util.List;

/**
 * @author 杨默
 * @date 2021/5/16 16:49
 * @Description
 */
public interface NhPropertyValueService  {

    public PageInfo<NhPropertyValue> selectByPage(NhPropertyValue nhPropertyValue);

    /**
     * 通过ID获取NhPropertyValue
     * @param primaryKey
     * @return
     */
    public NhPropertyValue selectByPrimaryKey(String primaryKey);

    /**
     * 根据属性类别id新增属性值
     * @param propertyValue
     * @return
     */
    int insertPropertyValue(NhPropertyValue propertyValue);

    /**
     * 根据属性值id删除属性值
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 根据属性类别id修改属性值
     * @param propertyValue
     * @return
     */
    int updateById(NhPropertyValue propertyValue);

    /**
     * 根据属性类别id查询属性值
     * 分页查询
     * @param vo
     * @return
     */
    //PageInfo<PropertyValue> findPageBreakByCondition(PropertyValueConditionVO vo);

    /**
     * 根据地块类别id查询属性值集合
     * @param propertyTypeId
     * @return
     */
    List<NhPropertyValue> selectByPropertyTypeId(NhPropertyValue nhPropertyValue);
}
