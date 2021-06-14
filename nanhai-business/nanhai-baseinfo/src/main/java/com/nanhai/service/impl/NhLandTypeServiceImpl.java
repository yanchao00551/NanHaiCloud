package com.nanhai.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.LandType;
import com.nanhai.core.business.entity.ProductType;
import com.nanhai.core.business.vo.LandTypeConditionVO;
import com.nanhai.core.business.vo.ProductTypeConditionVO;
import com.nanhai.core.persistence.beans.NhLandType;
import com.nanhai.core.persistence.beans.NhProductType;
import com.nanhai.core.util.EmptyUtils;
import com.nanhai.mapper.NhLandTypeMapper;
import com.nanhai.service.NhLandTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service("nhLandTypeService")
public class NhLandTypeServiceImpl implements NhLandTypeService {
    @Autowired
    private NhLandTypeMapper nhLandTypeMapper;

    @Override
    public List<NhLandType> listAll() {
        return nhLandTypeMapper.selectAll();
    }


    @Override
    public NhLandType insert(NhLandType landType) {
        int res = nhLandTypeMapper.insertSelective(landType);
        return landType;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        int res = nhLandTypeMapper.deleteByPrimaryKey(primaryKey);
        if(res==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateSelective(NhLandType landType) {
        int res = nhLandTypeMapper.updateByPrimaryKeySelective(landType);
        if(res==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public NhLandType getByPrimaryKey(Long primaryKey) {
        NhLandType landType = nhLandTypeMapper.selectByPrimaryKey(primaryKey);
        return landType;
    }


    /**
     * 根据多种条件查询农产品类别
     * @param vo
     * @return
     */
    @Override
    public PageInfo<NhLandType> findByCondition(LandTypeConditionVO vo) {
        List<NhLandType> list;
        System.out.println(vo);
        if (null != vo.getLandType()) {
            LandType landType = vo.getLandType();
            Example example = new Example(NhLandType.class);
            Example.Criteria criteria = example.createCriteria();
            //根据主键id查询农产品类别
            if (landType.getId() != null && landType.getId()!=0) {
                criteria.andEqualTo("id", landType.getId());
            }
            //根据农产品编号查询农产品类别
            landType.getLandTypeCode();
            if (!EmptyUtils.isEmpty(landType.getLandTypeCode())) {
                criteria.andEqualTo("landTypeCode", landType.getLandTypeCode());
            }
            //根据农产品等级查询农产品类别
            landType.getLandTypeLevel();
            if (!EmptyUtils.isEmpty(landType.getLandTypeLevel())) {
                criteria.andEqualTo("landTypeLevel", landType.getLandTypeLevel());
            }
            //根据农产品名称模糊查询农产品类别
            if (landType.getLandTypeName() != null && !"".equals(landType.getLandTypeName())) {
                criteria.andLike("landTypeName", "%" + landType.getLandTypeName() + "%");
            }
            //根据父级农产品编号查询农产品类别
            landType.getLandTypeParentCode();
            if (!EmptyUtils.isEmpty(landType.getLandTypeParentCode())) {
                criteria.andEqualTo("landTypeParentCode", landType.getLandTypeParentCode());
            }
            //如果农产品类别不为空就返回查询到的数据
            PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
            list = nhLandTypeMapper.selectByExample(example);
        } else {
            //如果农产品类别为空,则返回所有数据
            PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
            list = nhLandTypeMapper.selectAll();
        }
        System.out.println("---------------------" + list.toString());
        //定义新的集合
        List<NhLandType> categoriesList = new ArrayList<>();
        //先找到所有的一级分类
        for (NhLandType nhLandType : list) {
            System.out.println("+++++++++++++++++++++" + nhLandType.toString());
            //一级分类的父级农产品编号为0
            if (nhLandType.getLandTypeParentCode() == 0) {
                categoriesList.add(nhLandType);
            }
        }
        System.out.println("categoriesList" + categoriesList);
        // 为一级菜单设置子菜单，getChild是递归调用的
        for(NhLandType nhLandType : categoriesList){
            nhLandType.setChildren(getChilde(nhLandType.getLandTypeCode(), list));
        }
        return new PageInfo<>(categoriesList);
    }

    /**
     * 递归查找子菜单
     * @param landTypeCode 当前菜单编码
     * @param rootList 要查找的菜单列表
     * @return
     */
    private List<NhLandType> getChilde(Integer landTypeCode , List<NhLandType> rootList){
        //子菜单
        List<NhLandType> childList = new ArrayList<>();
        for(NhLandType category : rootList){
            // 遍历所有节点，将父菜单id与传过来的id比较
            if(category.getLandTypeParentCode().equals(landTypeCode)){
                childList.add(category);
            }
        }
        // 把子菜单的子菜单再循环一遍
        for(NhLandType category : childList){
            category.setChildren(getChilde(category.getLandTypeCode(), rootList));
        }
        // 递归退出条件
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }


}
