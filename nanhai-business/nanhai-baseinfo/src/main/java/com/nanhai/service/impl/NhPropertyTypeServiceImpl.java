package com.nanhai.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.PropertyType;
import com.nanhai.core.business.entity.PropertyValue;
import com.nanhai.core.business.vo.PropertyTypeConditionVO;
import com.nanhai.core.business.vo.PropertyValueConditionVO;
import com.nanhai.core.persistence.beans.NhPropertyType;
import com.nanhai.core.persistence.beans.NhUsers;
import com.nanhai.mapper.NhPropertyTypeMapper;
import com.nanhai.mapper.NhPropertyValueMapper;
import com.nanhai.service.NhPropertyTypeService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @author 杨默
 * @date 2021/5/15 9:28
 * @Description
 */
@Slf4j
@Service
public class NhPropertyTypeServiceImpl implements NhPropertyTypeService {

    @Autowired
    private NhPropertyTypeMapper propertyTypeMapper;

    NhPropertyValueServiceImpl nhPropertyValueServiceImpl = new NhPropertyValueServiceImpl();

    @Override
    public PageInfo<NhPropertyType> selectByPage(NhPropertyType nhPropertyType) {
        PageHelper.startPage(nhPropertyType.getPageNumber(),nhPropertyType.getPageSize());
        List<NhPropertyType> users = propertyTypeMapper.selectAll();
        PageInfo<NhPropertyType> pageInfo = new PageInfo<NhPropertyType>(users);
        return pageInfo;
    }

    /**
     * 新增属性类别
     * @param propertyType
     * @return
     */
    @Override
    public int insertPropertyType(NhPropertyType propertyType) {
        return propertyTypeMapper.insert(propertyType);
    }

    /**
     * 根据主键id删除属性类别
     * @param id
     * @return
     */
    @Override
    public int deleteById(String id) {
        if (id != null ){
            return propertyTypeMapper.deleteByPrimaryKey(id);
        }else{
            return 0;
        }
    }

    /**
     * 根据主键id修改属性类别
     * @param propertyType
     * @return
     */
    @Override
    public int updateById(NhPropertyType propertyType) {
        return propertyTypeMapper.updateByPrimaryKey(propertyType);
    }


    /**
     * 根据主键id查询属性类别
     * @param id
     * @return
     */
    @Override
    public NhPropertyType selectById(String  id) {
        return propertyTypeMapper.selectByPrimaryKey(id);
    }




}
