package com.nanhai.api;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.Group;
import com.nanhai.core.business.vo.ProductTypeConditionVO;
import com.nanhai.core.persistence.beans.NhLandType;
import com.nanhai.core.persistence.beans.NhProductType;
import com.nanhai.core.util.R;
import com.nanhai.service.NhProductTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * @author 杨默
 * @date 2021/6/7 21:23
 * @Description
 */
@RestController
@RequestMapping(value = {"/api/v1.0/fishing/landTypep/productType"})
@Slf4j
public class ProductTypeController {
    @Autowired
    private NhProductTypeService nhProductTypeService;

    /**
     * 新增属性类别
     * @param nhProductType
     * @return
     */
    @PostMapping("/insert")
    public R insert(NhProductType nhProductType){
        int index = nhProductTypeService.insertProductType(nhProductType);
        return R.ok().put("data" , index);
    }

    /**
     * 根据主键id删除农产品类别
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public R delete(Long id){
        int index = nhProductTypeService.deleteById(id);
        return R.ok().put("data" , index);
    }

    /**
     * 根据主键id修改农产品类别
     * @param nhProductType
     * @return
     */
    @PostMapping("/update")
    public R update(NhProductType nhProductType){
        int index = nhProductTypeService.updateProductType(nhProductType);
        return R.ok().put("data" , index);
    }

    /**
     * 根据主键id查询农产品类别
     * @param id
     * @return
     */
    @GetMapping("/selectById")
    public R selectById(Long id){
        NhProductType nhProductType = nhProductTypeService.selectById(id);
        return R.ok().put("data" , nhProductType);
    }

    /**
     * 绑定变量名字和属性,参数进类
     * @param binder
     */
    @InitBinder
    public void initBinderAddr(WebDataBinder binder){
        binder.setFieldDefaultPrefix("productType.");
    }
    /**
     * 根据多种条件查询农产品类别
     * @param vo
     * @return
     */
    @GetMapping("/getList")
    public R getList(ProductTypeConditionVO vo){
        PageInfo<NhProductType> byCondition = nhProductTypeService.findByCondition(vo);
        return R.ok().put("data" , byCondition);
    }
}
