package com.nanhai.modules.data.service.impl;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.SubjectYearTotalValue;
import com.nanhai.core.business.exception.ApiException;
import com.nanhai.core.business.vo.SubjectInfoConditionVO;
import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.core.persistence.beans.NhSubjectInfo;
import com.nanhai.core.persistence.beans.NhSubjectYearTotalValue;

import com.nanhai.modules.data.mapper.NhSubjectInfoMapper;
import com.nanhai.modules.data.mapper.NhSubjectYearTotalValueMapper;
import com.nanhai.modules.data.service.NhSubjectYearTotalValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author luobo
 * @create 2021/5/15
 */
@Service
public class NhSubjectYearTotalValueServiceImpl implements NhSubjectYearTotalValueService {

    @Autowired
    NhSubjectYearTotalValueMapper nhSubjectYearTotalValueMapper;
    @Autowired
    private NhSubjectInfoMapper subjectInfoMapper;


    @Override
    public NhSubjectYearTotalValue insert(NhSubjectYearTotalValue entity) {
        return null;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(NhSubjectYearTotalValue entity) {
        return false;
    }

    @Override
    public NhSubjectYearTotalValue getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public void insertSubjectYearTotalValue(SubjectYearTotalValue subjectYearTotalValue) {
        isExitSubject(subjectYearTotalValue.getSytvSubjectCode());

        Example example = new Example(NhSubjectYearTotalValue.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sytvYear", subjectYearTotalValue.getSytvYear());
        criteria.andEqualTo("sytvSubjectCode", subjectYearTotalValue.getSytvSubjectCode());
        if (nhSubjectYearTotalValueMapper.selectCountByExample(example) > 0) {
            throw new ApiException("该年份已经存在");
        }
        subjectYearTotalValue.getNhSubjectYearTotalValue().setCreateTime(new Date());
        nhSubjectYearTotalValueMapper.insert(subjectYearTotalValue.getNhSubjectYearTotalValue());
    }

    @Override
    public void deleteSubjectYearTotalValue(Long subjectYearTotalValueId) {
        isExit(subjectYearTotalValueId);
        nhSubjectYearTotalValueMapper.deleteByPrimaryKey(subjectYearTotalValueId);
    }

    @Override
    public void putSubjectYearTotalValue(SubjectYearTotalValue subjectYearTotalValue) {

        NhSubjectYearTotalValue nhSubjectYearTotalValue = nhSubjectYearTotalValueMapper.selectByPrimaryKey(subjectYearTotalValue.getId());

        if (null == nhSubjectYearTotalValue) {
            throw new ApiException("找不到相关记录");
        }
        Example example = new Example(NhSubjectYearTotalValue.class);

        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("sytvYear", subjectYearTotalValue.getSytvYear()).andNotEqualTo("id", subjectYearTotalValue.getId()).andEqualTo("sytvSubjectCode", subjectYearTotalValue.getSytvSubjectCode());
        if (nhSubjectYearTotalValueMapper.selectCountByExample(example) > 0) {
            throw new ApiException("该年份已经存在");
        }
        subjectYearTotalValue.setSytvSubjectCode(nhSubjectYearTotalValue.getSytvSubjectCode());
        subjectYearTotalValue.getNhSubjectYearTotalValue().setUpdateTime(new Date());
        nhSubjectYearTotalValueMapper.updateByPrimaryKey(subjectYearTotalValue.getNhSubjectYearTotalValue());
    }

    @Override
    public PageInfo<NhSubjectYearTotalValue> findSubjectYearTotalValues(SubjectInfoConditionVO subjectInfoConditionVO) {
        NhSubjectYearTotalValue nhSubjectYearTotalValue = new NhSubjectYearTotalValue();
        List<NhSubjectYearTotalValue> res = nhSubjectYearTotalValueMapper.select(nhSubjectYearTotalValue);
        return new PageInfo<>(res);

    }

    private void isExitSubject(String sytvSubjectCode) {
        NhSubjectInfo nhSubjectInfo = new NhSubjectInfo();
        nhSubjectInfo.setSubjectCode(sytvSubjectCode);
        if (subjectInfoMapper.selectCount(nhSubjectInfo) <= 0) {
            throw new ApiException("相关主体不存在");
        }
    }

    private void isExit(Long id) {
        if (null == nhSubjectYearTotalValueMapper.selectByPrimaryKey(id)) {
            throw new ApiException("找不到相关记录");
        }
    }
}
