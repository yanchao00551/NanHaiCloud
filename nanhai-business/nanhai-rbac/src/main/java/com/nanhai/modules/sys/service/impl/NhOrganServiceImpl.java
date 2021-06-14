package com.nanhai.modules.sys.service.impl;

import cn.hutool.core.text.StrSpliter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.nanhai.core.business.entity.Organ;
import com.nanhai.core.business.exception.ApiException;
import com.nanhai.core.business.vo.OrganConditionVO;
import com.nanhai.core.persistence.beans.NhOrgan;
import com.nanhai.modules.sys.mapper.NhOrganMapper;
import com.nanhai.modules.sys.service.NhOrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author luobo
 * @create 2021/5/8
 */
@Service
public class NhOrganServiceImpl implements NhOrganService {

    @Autowired
    private NhOrganMapper nhOrganMapper;

    @Override
    public void putOrganById(Organ organ) {
        NhOrgan nhOrgan = this.nhOrganMapper.selectByPrimaryKey(organ.getId());
        if (null == nhOrgan) {
            throw new ApiException("找不到相关记录");
        }
        Example example = new Example(NhOrgan.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andNotEqualTo("id", organ.getId());
        criteria.andEqualTo("organCode", organ.getOrganCode());
        if (nhOrganMapper.selectCountByExample(example) > 0) {
            throw new ApiException("该机构编码已经存在");

        }
        organ.getNhOrgan().setUpdateTime(new Date());
        nhOrganMapper.updateByPrimaryKey(organ.getNhOrgan());
    }

    @Override
    public void deleteOrganById(Long id) {
        NhOrgan nhOrgan = nhOrganMapper.selectByPrimaryKey(id);
        if (null == nhOrgan) {
            throw new ApiException("找不到相关记录");
        }
        nhOrganMapper.deleteByPrimaryKey(id);

    }


    @Override
    public void add(Organ organ) {
        Example example = new Example(NhOrgan.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("organCode", organ.getOrganCode());
        int res = nhOrganMapper.selectCountByExample(example);
        if (res > 0) {
            throw new ApiException("该机构编码已经存在");
        }

        if (organ.getNhOrgan().getOrganParent() != null) {
            Example example1 = new Example(NhOrgan.class);
            example1.createCriteria().andEqualTo("organCode",organ.getNhOrgan().getOrganParent());
            NhOrgan result = nhOrganMapper.selectOneByExample(example1);
            if (result == null) {
                throw new ApiException("请输入正确上级机构id");
            }else{
                organ.setOrganParent(result.getId());
            }
        }else{
            organ.setOrganParent(0L);
        }
        organ.getNhOrgan().setCreateTime(new Date());
        nhOrganMapper.insert(organ.getNhOrgan());

    }

    @Override
    public PageInfo<NhOrgan> findByCondition(OrganConditionVO vo) {

        List<NhOrgan> list ;
        System.out.println(vo);
        if (null!=vo.getOrgan()) {
            Organ organ=vo.getOrgan();
            Example example = new Example(NhOrgan.class);
            Example.Criteria criteria = example.createCriteria();
            if(organ.getOrganCode()!=null&&!"".equals(organ.getOrganCode())){
                criteria.andEqualTo("organCode", organ.getOrganCode());
            }
            if(organ.getOrganName()!=null&&!"".equals(organ.getOrganName())){
                criteria.andLike("organName","%"+organ.getOrganName()+"%");
            }
            if(organ.getOrganAddress()!=null&&!"".equals(organ.getOrganAddress())){
                criteria.andLike("organAddress", "%"+organ.getOrganAddress()+"%");
            }
            if(organ.getLinkMan()!=null&&!"".equals(organ.getLinkMan())){
                criteria.andEqualTo("linkMan", organ.getLinkMan());
            }
            if(organ.getLinkPhone()!=null&&!"".equals(organ.getLinkPhone())){
                criteria.andEqualTo("linkPhone", organ.getLinkPhone());
            }
            PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
            list = nhOrganMapper.selectByExample(example);
        } else {
            PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
            list = nhOrganMapper.selectAll();
        }
        System.out.println("list"+list.toString());
        //定义新的list
        List<NhOrgan> categoriesList = new ArrayList<>();
        //先找到所有的一级分类
        for(NhOrgan nhOrgan : list){
            System.out.println("AAAAA"+nhOrgan.toString());
            // 一级菜单的parentId是0
            if(nhOrgan.getOrganParent() == 0){
                categoriesList.add(nhOrgan);
            }
            //TODO: 解析省、市、区和详细地址
            String organAddress = nhOrgan.getOrganAddress();
            String[] split = organAddress.split("\\|");
            if(split.length > 0){
                String[] codes = split[0].split(",");
                int i = codes.length;
                if(i == 1){
                    nhOrgan.setProvinceCode(Integer.parseInt(codes[0]));
                }
                if(i == 2){
                    nhOrgan.setProvinceCode(Integer.parseInt(codes[0]));
                    nhOrgan.setCityCode(Integer.parseInt(codes[1]));
                }
                if(i == 3){
                    nhOrgan.setProvinceCode(Integer.parseInt(codes[0]));
                    nhOrgan.setCityCode(Integer.parseInt(codes[1]));
                    nhOrgan.setAreaCode(Integer.parseInt(codes[2]));
                }
                nhOrgan.setDetailAddress(split[1]);
            }else{
                String[] sp = organAddress.split(",");
                int j = sp.length;
                if(j == 1){
                    nhOrgan.setProvinceCode(Integer.parseInt(sp[0]));
                }
                if(j == 2){
                    nhOrgan.setProvinceCode(Integer.parseInt(sp[0]));
                    nhOrgan.setCityCode(Integer.parseInt(sp[1]));
                }
                if(j == 3){
                    nhOrgan.setProvinceCode(Integer.parseInt(sp[0]));
                    nhOrgan.setCityCode(Integer.parseInt(sp[1]));
                    nhOrgan.setAreaCode(Integer.parseInt(sp[2]));
                }
            }
        }
        System.out.println("categoriesList"+categoriesList);
        // 为一级菜单设置子菜单，getChild是递归调用的
        for(NhOrgan nhOrgan : categoriesList){
            nhOrgan.setChildren(getChilde(nhOrgan.getId(), list));
        }

        return new PageInfo<>(categoriesList);
    }

    /**
     * 递归查找子菜单
     *
     * @param id 当前菜单id
     * @param rootList 要查找的列表
     * @return
     */
    private List<NhOrgan> getChilde(Long id, List<NhOrgan> rootList){
        //子菜单
        List<NhOrgan> childList = new ArrayList<>();
        for(NhOrgan category : rootList){
            // 遍历所有节点，将父菜单id与传过来的id比较
            if(category.getOrganParent().equals(id)){
                childList.add(category);
            }
        }
        // 把子菜单的子菜单再循环一遍
        for(NhOrgan category : childList){
            category.setChildren(getChilde(category.getId(), rootList));
        }
        // 递归退出条件
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }









}
