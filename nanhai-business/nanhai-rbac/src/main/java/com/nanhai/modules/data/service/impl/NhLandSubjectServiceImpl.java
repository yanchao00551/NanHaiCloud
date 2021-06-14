package com.nanhai.modules.data.service.impl;


import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.LandSubject;
import com.nanhai.core.business.entity.LandSubjectRs;
import com.nanhai.core.business.exception.ApiException;
import com.nanhai.core.business.vo.LandSubjectConditionVO;
import com.nanhai.core.persistence.beans.NhLandInfo;
import com.nanhai.core.persistence.beans.NhLandSubject;
import com.nanhai.core.persistence.beans.NhSubjectInfo;
import com.nanhai.modules.data.mapper.NhLandInfoMapper;
import com.nanhai.modules.data.mapper.NhLandSubjectMapper;
import com.nanhai.modules.data.mapper.NhSubjectInfoMapper;
import com.nanhai.modules.data.service.NhLandSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;


/**
 * @author luobo
 * @create 2021/5/18
 */
@Service
public class NhLandSubjectServiceImpl implements NhLandSubjectService {
    @Autowired
    NhLandSubjectMapper landSubjectMapper;
    @Autowired
    NhLandInfoMapper landInfoMapper;
    @Autowired
    NhSubjectInfoMapper subjectInfoMapper;

    @Override
    public void add(LandSubject landSubject) {
        landSubject.setCreateTime(new Date());

        Example example1=new Example(NhLandInfo.class);
        Example.Criteria criteria1=example1.createCriteria();
        criteria1.andEqualTo("landCode",landSubject.getLsLandCode());
        if(landInfoMapper.selectCountByExample(example1)<=0){
            throw new ApiException("找不到相关地块");
        }

        Example example2=new Example(NhSubjectInfo.class);
        Example.Criteria criteria2=example2.createCriteria();
        criteria2.andEqualTo("subjectCode",landSubject.getLsSubjectCode());
        if(subjectInfoMapper.selectCountByExample(example2)<=0){
            throw new ApiException("找不到相关主体");
        }



        Example example=new Example(NhLandSubject.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("lsLandCode",landSubject.getLsLandCode());
        criteria.andEqualTo("lsSubjectCode",landSubject.getLsSubjectCode());
        if(landSubjectMapper.selectCountByExample(example)>0){
             throw new ApiException("该地块已经绑定该主体");
        }
        landSubjectMapper.insertSelective(landSubject.getNhLandSubject());
    }





    @Override
    public void delete(Long id) {
        isExitById(id);
        landSubjectMapper.deleteByPrimaryKey(id);
    }






    @Override
    public void updateLandSubject(LandSubject landSubject) {
        isExitById(landSubject.getId());
        landSubject.setUpdateTime(new Date());
        landSubjectMapper.updateByPrimaryKeySelective(landSubject.getNhLandSubject());
    }

    @Override
    public PageInfo<LandSubjectRs> selectLandSubject(LandSubjectConditionVO vo) {

        String landCode=null;
        String subjectCode = null;
        if (vo.getLandSubject() != null) {
            landCode = vo.getLandSubject().getLsLandCode();
            subjectCode = vo.getLandSubject().getLsSubjectCode();
        }
        return new PageInfo<>(landSubjectMapper.findLandSubject1(subjectCode, landCode));
    }


    private void isExitById(Object id) {
        if (null == landSubjectMapper.selectByPrimaryKey(id)) {
            throw new ApiException("找不到相关记录");
        }
    }
    /**
     * 根据地块编号查询主体与地块的关联信息
     *
     * @param landCode
     * @return
     */
    @Override
    public List<NhLandSubject> selectLandSubjectByLandCode(String landCode) {
        return landSubjectMapper.selectLandSubjectByLandCode(landCode);
    }

    /**
     * 根据地块编号查询主体与地块的关联信息
     *
     * @param
     * @return
     */
    @Override
    public int updateLandSubjectByLandCode(NhLandSubject nhLandSubject) {
        return landSubjectMapper.updateLandSubjectByLandCode(nhLandSubject);
    }


}
