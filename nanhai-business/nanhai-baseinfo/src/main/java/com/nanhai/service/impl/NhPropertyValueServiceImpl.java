package com.nanhai.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.PropertyValue;
import com.nanhai.core.business.vo.PropertyTypeConditionVO;
import com.nanhai.core.business.vo.PropertyValueConditionVO;
import com.nanhai.core.persistence.beans.NhPlanInfo;
import com.nanhai.core.persistence.beans.NhPropertyType;
import com.nanhai.core.persistence.beans.NhPropertyValue;
import com.nanhai.core.util.EmptyUtils;
import com.nanhai.mapper.NhPropertyValueMapper;
import com.nanhai.service.NhPropertyValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 杨默selectByPage
 * @date 2021/5/16 16:52
 * @Description
 */
@Slf4j
@Service
public class NhPropertyValueServiceImpl implements  NhPropertyValueService {

    @Autowired
    private NhPropertyValueMapper nhPropertyValueMapper;


    @Override
    public PageInfo<NhPropertyValue> selectByPage(NhPropertyValue nhPropertyValue) {
        PageHelper.startPage(nhPropertyValue.getPageNumber(),nhPropertyValue.getPageSize());
        List<NhPropertyValue> nhPropertyValues = nhPropertyValueMapper.selectPage(nhPropertyValue);
        PageInfo<NhPropertyValue> pageInfo = new PageInfo<NhPropertyValue>(nhPropertyValues);
        return pageInfo;
    }

    /**
     * 根据属性类别id新增属性值
     * @param propertyValue
     * @return
     */
    @Override
    public int insertPropertyValue(NhPropertyValue propertyValue) {
        return nhPropertyValueMapper.insertSelective(propertyValue);
    }

    /**
     * 根据属性值id删除属性值
     * @param id
     * @return
     */
    @Override
    public int deleteById(String id) {
        return nhPropertyValueMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据主键id修改属性值
     * @param propertyValue
     * @return
     */
    @Override
    public int updateById(NhPropertyValue propertyValue) {
        return nhPropertyValueMapper.updateByPrimaryKey(propertyValue);
    }



    @Override
    public NhPropertyValue selectByPrimaryKey(String primaryKey) {
        return nhPropertyValueMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public List<NhPropertyValue> selectByPropertyTypeId(NhPropertyValue nhPropertyValue) {
        Example example=new Example(NhPropertyValue.class);
        Example.Criteria criteria=example.createCriteria();
        if(!EmptyUtils.isEmpty(nhPropertyValue)){
            criteria.andEqualTo("ptCode",nhPropertyValue.getPtCode());
        }
        if(!EmptyUtils.isEmpty(nhPropertyValue)){
            criteria.andEqualTo("pvCode",nhPropertyValue.getPvCode());
        }
        return nhPropertyValueMapper.selectByExample(example);
    }


}
