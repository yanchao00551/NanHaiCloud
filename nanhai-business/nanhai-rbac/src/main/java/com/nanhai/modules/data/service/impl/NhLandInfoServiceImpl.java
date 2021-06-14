package com.nanhai.modules.data.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.LandInfo;
import com.nanhai.core.business.exception.ApiException;
import com.nanhai.core.business.vo.LandSubjectConditionVO;
import com.nanhai.core.framework.object.MyRestTemplate;
import com.nanhai.core.persistence.beans.NhCollectTaskLand;
import com.nanhai.core.persistence.beans.NhLandInfo;
import com.nanhai.modules.data.mapper.NhCollectTaskLandMapper;
import com.nanhai.modules.data.mapper.NhLandInfoMapper;
import com.nanhai.modules.data.mapper.NhLandSubjectMapper;
import com.nanhai.modules.data.service.NhLandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author luobo
 * @create 2021/5/18
 */
@Service
public class NhLandInfoServiceImpl implements NhLandInfoService {

    @Autowired
    NhLandInfoMapper nhLandInfoMapper;
    @Autowired
    NhLandSubjectMapper nhLandSubjectMapper;
    @Autowired
    NhCollectTaskLandMapper nhCollectTaskLandMapper;

    @Autowired
    private MyRestTemplate myRestTemplate;
    private static final String GATEWAY_SERVICE = "http://nanhai-zuul-gateway:8280/";
    private String imgs = null;

    @Override
    public PageInfo<NhLandInfo> findPageBreakByCondition(LandSubjectConditionVO landSubjectConditionVO) {

        PageHelper.startPage(landSubjectConditionVO.getPageNumber(), landSubjectConditionVO.getPageSize());
        List<NhLandInfo> list = nhLandInfoMapper.findPageBreakByCondition(landSubjectConditionVO);
        for (NhLandInfo nhLandInfo : list) {
            if (nhLandInfo.getImgUrl() != null && !"".equals(nhLandInfo.getImgUrl())) {
                try {
                    imgs = myRestTemplate.getForObject(GATEWAY_SERVICE + "/oss/file/getList?pictureIds=" + nhLandInfo.getImgUrl(), String.class);
                    JSONObject j1 = JSONObject.parseObject(imgs);
                    nhLandInfo.setOssImgList(j1.getJSONArray("data"));
                }catch (Exception e){
                    nhLandInfo.setOssImgList(new JSONArray());
                }
            }
        }

        return new PageInfo<>(list);
    }

    @Override
    public void auditLandInfo(LandInfo landInfo) {
        nhLandInfoMapper.updateByPrimaryKeySelective(landInfo.getNhLandInfo());
    }

    @Override
    public void updateLandInfo(LandInfo landInfo) {
        isExit(landInfo);
        landInfo.setUpdatePerson("张三");
        landInfo.setUpdateTime(new Date());

        nhLandInfoMapper.updateByPrimaryKeySelective(landInfo.getNhLandInfo());
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void collectLandInfo(LandInfo landInfo) {
        NhCollectTaskLand nhCollectTaskLand = new NhCollectTaskLand();
        System.out.println(landInfo);
        Example example = new Example(NhCollectTaskLand.class);
        nhCollectTaskLand.setLandType(landInfo.getLandType());
        nhCollectTaskLand.setLandTypeName(landInfo.getLandTypeName());
        nhCollectTaskLand.setLandProductArea(landInfo.getMu());
        nhCollectTaskLand.setLandProduce(landInfo.getLandProduce());
        nhCollectTaskLand.setLandProduct(landInfo.getLandProduct());
        nhCollectTaskLand.setLandYearValue(landInfo.getLandYearValue());
        nhCollectTaskLand.setLandOtherType(landInfo.getLandOtherType());
        nhCollectTaskLand.setImgUrl(landInfo.getImgUrl());
        nhCollectTaskLand.setUpdateTime(new Date());
        nhCollectTaskLand.setLandName(landInfo.getLandName());
        nhCollectTaskLand.setLandYearOutput(landInfo.getLandYearOutput());
        nhCollectTaskLand.setLandOutputUnit(landInfo.getLandOutputUnit());
        nhCollectTaskLand.setLandVillageCode(landInfo.getLandVillageCode());
        nhCollectTaskLand.setLandTownCode(landInfo.getLandTownCode());
        nhCollectTaskLand.setLandTownName(landInfo.getLandTownName());
        nhCollectTaskLand.setLandVillageName(landInfo.getLandVillageName());
        nhCollectTaskLand.setImgUrl(landInfo.getImgUrl());
        nhCollectTaskLand.setAuditStatus(1);
        nhCollectTaskLand.setCollectStatus(2);
        nhCollectTaskLand.setUpdatePerson(landInfo.getUpdatePerson());
        example.setOrderByClause("create_time DESC");
        example.createCriteria().andEqualTo("landId",landInfo.getLandCode()).andEqualTo("planId",landInfo.getLandPlanId());
        NhCollectTaskLand res = nhCollectTaskLandMapper.selectOneByExample(example);
        if(res==null){
            throw new ApiException("找不到相关记录");
        }
        Example example2 = new Example(NhCollectTaskLand.class);
        example2.createCriteria().andEqualTo("id", res.getId());
        nhCollectTaskLandMapper.updateByExampleSelective(nhCollectTaskLand, example2);




        /* 采集状态更改到 采集地块关系表
        NhLandInfo nhLandInfo = new NhLandInfo();
        nhLandInfo.setId(res.getLandId());
        nhLandInfo.setCollectStatus(1);
        nhLandInfoMapper.updateByPrimaryKeySelective(nhLandInfo);*/
    }


    private void isExit(LandInfo landInfo) {

        NhLandInfo landInfo1 = nhLandInfoMapper.selectByPrimaryKey(landInfo.getId());
        if (null == landInfo1) {
            throw new ApiException("找不到相关地块记录");

        }

    }


}
