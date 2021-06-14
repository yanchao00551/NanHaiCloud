package com.nanhai.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.ProductType;
import com.nanhai.core.business.vo.ProductTypeConditionVO;
import com.nanhai.core.persistence.beans.NhOrgan;
import com.nanhai.core.persistence.beans.NhProductType;
import com.nanhai.mapper.NhProductTypeMapper;
import com.nanhai.service.NhProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 杨默
 * @date 2021/6/7 21:14
 * @Description
 */
@Service
public class NhProductTypeServiceImpl implements NhProductTypeService {

    @Autowired
    private NhProductTypeMapper nhProductTypeMapper;

    /**
     * 新增农产品类别
     *
     * @param nhProductType
     * @return
     */
    @Override
    public int insertProductType(NhProductType nhProductType) {
        int index = nhProductTypeMapper.insert(nhProductType);
        if (index == 1) {
            return index;
        }
        return index;
    }

    /**
     * 根据主键id删除农产品类别
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(Long id) {
        int index = nhProductTypeMapper.deleteByPrimaryKey(id);
        if (index == 1) {
            return index;
        }
        return index;
    }

    /**
     * 根据农产品类别id修改农产品类别
     *
     * @param nhProductType
     * @return
     */
    @Override
    public int updateProductType(NhProductType nhProductType) {
        int index = nhProductTypeMapper.updateByPrimaryKey(nhProductType);
        if (index == 1) {
            return index;
        }
        return index;
    }

    /**
     * 根据主键id查询农产品类别
     *
     * @param id
     * @return
     */
    @Override
    public NhProductType selectById(Long id) {
        NhProductType nhProductType = nhProductTypeMapper.selectByPrimaryKey(id);
        return nhProductType;
    }

    /**
     * 根据多种条件查询农产品类别
     *
     * @param vo
     * @return
     */
    @Override
    public PageInfo<NhProductType> findByCondition(ProductTypeConditionVO vo) {
        List<NhProductType> list;
        System.out.println(vo);
        if (null != vo.getProductType()) {
            ProductType productType = vo.getProductType();
            Example example = new Example(NhProductType.class);
            Example.Criteria criteria = example.createCriteria();
            //根据主键id查询农产品类别
            if (productType.getId() != null && !"".equals(productType.getId())) {
                criteria.andEqualTo("id", productType.getId());
            }
            //根据农产品编号查询农产品类别
            if (productType.getProductTypeCode() != null && !"".equals(productType.getProductTypeCode())) {
                criteria.andEqualTo("productTypeCode", productType.getProductTypeCode());
            }
            //根据农产品等级查询农产品类别
            if (productType.getProductTypeLevel() != null && !"".equals(productType.getProductTypeLevel())) {
                criteria.andEqualTo("productTypeLevel", productType.getProductTypeLevel());
            }
            //根据农产品名称模糊查询农产品类别
            if (productType.getProductTypeName() != null && !"".equals(productType.getProductTypeName())) {
                criteria.andLike("productTypeName", "%" + productType.getProductTypeName() + "%");
            }
            //根据父级农产品编号查询农产品类别
            if (productType.getProductTypeParentCode() != null && !"".equals(productType.getProductTypeParentCode())) {
                criteria.andEqualTo("productTypeParentCode", productType.getProductTypeParentCode());
            }

            list = nhProductTypeMapper.selectByExample(example);
        } else {

            list = nhProductTypeMapper.selectAll();
        }
        System.out.println("---------------------" + list.toString());
        //定义新的集合
        List<NhProductType> categoriesList = new ArrayList<>();
        //先找到所有的一级分类
        for (NhProductType nhProductType : list) {
            System.out.println("+++++++++++++++++++++" + nhProductType.toString());
            //一级分类的父级农产品编号为0
            if (nhProductType.getProductTypeParentCode() == 0) {
                categoriesList.add(nhProductType);
            }
        }
        System.out.println("categoriesList" + categoriesList);
        // 为一级菜单设置子菜单，getChild是递归调用的
        for(NhProductType nhProductType : categoriesList){
            nhProductType.setChildren(getChilde(nhProductType.getProductTypeCode(), list));
        }
        return new PageInfo<>(categoriesList);
    }

    /**
     * 递归查找子菜单
     * @param
     * @param rootList 要查找的菜单列表
     * @return
     */
    private List<NhProductType> getChilde(Long productTypeCode , List<NhProductType> rootList){
        //子菜单
        List<NhProductType> childList = new ArrayList<>();
        for(NhProductType category : rootList){
            // 遍历所有节点，将父菜单id与传过来的id比较
            if(category.getProductTypeParentCode().equals(productTypeCode)){
                childList.add(category);
            }
        }
        // 把子菜单的子菜单再循环一遍
        for(NhProductType category : childList){
            category.setChildren(getChilde(category.getProductTypeCode(), rootList));
        }
        // 递归退出条件
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }

    @Override
    public ProductType insert(ProductType entity) {
        return null;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(ProductType entity) {
        return false;
    }

    @Override
    public ProductType getByPrimaryKey(Long primaryKey) {
        return null;
    }
}
