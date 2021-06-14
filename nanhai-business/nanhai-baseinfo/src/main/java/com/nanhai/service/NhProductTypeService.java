package com.nanhai.service;


import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.ProductType;
import com.nanhai.core.business.vo.ProductTypeConditionVO;
import com.nanhai.core.framework.object.AbstractService;
import com.nanhai.core.persistence.beans.NhProductType;

/**
 * @author 杨默
 * @date 2021/6/7 21:05
 * @Description
 */
public interface NhProductTypeService extends AbstractService<ProductType , Long> {
    /**
     * 新增农产品类别
     * @param nhProductType
     * @return
     */
    int insertProductType(NhProductType nhProductType);

    /**
     * 根据主键id删除农产品类别
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据农产品类别id修改农产品类别
     * @param nhProductType
     * @return
     */
    int updateProductType(NhProductType nhProductType);

    /**
     * 根据主键id查询农产品类别
     * @param id
     * @return
     */
    NhProductType selectById(Long id);

    /**
     * 根据多种条件查询农产品类别
     * @param vo
     * @return
     */
    PageInfo<NhProductType> findByCondition(ProductTypeConditionVO vo);
}
