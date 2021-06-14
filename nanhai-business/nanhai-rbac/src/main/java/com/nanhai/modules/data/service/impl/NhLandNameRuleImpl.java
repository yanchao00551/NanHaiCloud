package com.nanhai.modules.data.service.impl;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.LandInfo;
import com.nanhai.core.business.entity.LandNameRule;
import com.nanhai.core.business.exception.ApiException;
import com.nanhai.core.persistence.beans.NhLandInfo;
import com.nanhai.core.persistence.beans.NhLandNameRule;
import com.nanhai.modules.data.mapper.NhLandInfoMapper;
import com.nanhai.modules.data.mapper.NhLandNameRuleMapper;
import com.nanhai.modules.data.service.NhLandNameRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author luobo
 * @create 2021/5/20
 */
@Service
public class NhLandNameRuleImpl implements NhLandNameRuleService {
    @Autowired
    NhLandNameRuleMapper nhLandNameRuleMapper;
    @Autowired
    NhLandInfoMapper nhLandInfoMapper;

    @Override
    public PageInfo<NhLandNameRule> getLandNameRuleList() {
        List<NhLandNameRule> list = nhLandNameRuleMapper.selectAll();
        return new PageInfo<>(list);
    }

    @Override
    public void updateLandNameRuleById(LandNameRule landNameRule) {
        isExit(landNameRule);
        landNameRule.setUpdateTime(new Date());
        nhLandNameRuleMapper.updateByPrimaryKey(landNameRule.getNhLandNameRule());
    }


    @Override
    public String getLandNameAuto(Long landId, String town, String village, String landType) {
        NhLandInfo landInfoRes = nhLandInfoMapper.selectByPrimaryKey(landId);
        if (null == landInfoRes) {
            throw new ApiException("找不到相关记录");
        }
        Example example = new Example(NhLandNameRule.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ruleNameStatus", 1);
        NhLandNameRule landNameRule = nhLandNameRuleMapper.selectOneByExample(example);
        if (null == landNameRule) {
            throw new ApiException("找不到地块命名规则");
        }
        String landName = "";
        if (landNameRule.getTown() == 1) {
            landName = landName + town + "-";
        }
        if (landNameRule.getVillage() == 1) {
            landName = landName + village + "-";
        }
        if (landNameRule.getLandType() == 1) {
            landName = landName + landType + "-";
        }
        int LandNameTailType = 1;
        //后缀数字
        if (landNameRule.getNum() == 1) {
            landName = landName + this.getLandInfoByLandName(landName, 1, landId);

        } else {
            //后缀英文
            int ascii = 64 + this.getLandInfoByLandName(landName, 2, landId);
            System.out.println(ascii);
            if (90 <= ascii) {
                ascii = ascii + 7;
            }
            System.out.println(ascii);
            landName = landName + (char) ascii;
            LandNameTailType = 2;
        }
        NhLandInfo landInfo = new NhLandInfo();
        landInfo.setId( landId);
        landInfo.setLandNameTailType(LandNameTailType);
        landInfo.setUpdateTime(new Date());
        nhLandInfoMapper.updateByPrimaryKeySelective(landInfo);
        return landName;
    }


    private int getLandInfoByLandName(String landName, Integer landNameTailType, Long landId) {
        return nhLandNameRuleMapper.getLandInfoByLandName(landName, landNameTailType, landId) + 1;

    }


    private void isExit(LandNameRule landNameRule) {
        Example example = new Example(NhLandNameRule.class);
        Example.Criteria criteria3 = example.createCriteria();
        criteria3.andEqualTo("id", landNameRule.getId());
        int res = nhLandNameRuleMapper.selectCountByExample(example);
        if (res <= 0) {
            throw new ApiException("组织编码或者统一信用编码已经存在");
        }
    }
}
