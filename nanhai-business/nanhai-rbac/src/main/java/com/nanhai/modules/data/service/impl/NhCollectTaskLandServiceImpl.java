package com.nanhai.modules.data.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.CollectTaskLand;
import com.nanhai.core.business.entity.CollectTaskLandRs;
import com.nanhai.core.business.entity.CollectTaskLandUser;

import com.nanhai.core.business.vo.CollectTaskLandConditionVO;
import com.nanhai.core.framework.object.MyRestTemplate;
import com.nanhai.core.persistence.beans.NhCollectTaskLand;
import com.nanhai.core.persistence.beans.NhLandInfo;
import com.nanhai.core.persistence.beans.NhPlanInfo;
import com.nanhai.modules.data.mapper.NhCollectTaskLandMapper;
import com.nanhai.modules.data.mapper.NhLandInfoMapper;
import com.nanhai.modules.data.service.NhCollectTaskLandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;


import java.util.*;

/**
 * @author luobo
 * @create 2021/5/29
 */
@Service
public class NhCollectTaskLandServiceImpl implements NhCollectTaskLandService {
    @Autowired
    NhCollectTaskLandMapper nhCollectTaskLandMapper;

    @Autowired
    NhLandInfoMapper nhLandInfoMapper;
    private static final String GATEWAY_SERVICE = "http://nanhai-zuul-gateway:8280/";
    private String imgs = null;
    @Autowired
    private MyRestTemplate myRestTemplate;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertCollectTaskLand(NhPlanInfo nhPlanInfo) {
        List<String> list = nhPlanInfo.getVillageCode();
        Example example = new Example(NhLandInfo.class);
        example.createCriteria().andIn("landVillageCode", list);
        List<NhLandInfo> nhLandInfoList = nhLandInfoMapper.selectByExample(example);
        List<NhCollectTaskLand> nhCollectTaskList = new ArrayList<>();
        for (NhLandInfo nhLandInfo : nhLandInfoList) {
            NhCollectTaskLand nhCollectTaskLand = new NhCollectTaskLand();
            nhCollectTaskLand.setPlanId(nhPlanInfo.getId());
            nhCollectTaskLand.setLandId(nhLandInfo.getLandCode());
            nhCollectTaskLand.setCreateTime(new Date());
            nhCollectTaskLand.setCreatePerson(nhPlanInfo.getCreatePerson());
            nhCollectTaskLand.setAuditStatus(0);
            nhCollectTaskLand.setCollectStatus(1);
            nhCollectTaskLand.setLandVillageCode(nhLandInfo.getLandVillageCode());
            nhCollectTaskLand.setLandName(nhLandInfo.getLandName());
            nhCollectTaskLand.setLandOtherType(nhLandInfo.getLandOtherType());
            nhCollectTaskLand.setImgUrl(nhLandInfo.getImgUrl());
            nhCollectTaskLand.setLandTownCode(nhLandInfo.getLandTownCode());
            nhCollectTaskLand.setLandYearOutput(nhLandInfo.getLandYearOutput());
            nhCollectTaskLand.setLandOutputUnit(nhLandInfo.getLandOutputUnit());
            nhCollectTaskLand.setLandType(nhLandInfo.getLandType());
            nhCollectTaskLand.setLandTypeName(nhLandInfo.getLandTypeName());
            nhCollectTaskLand.setLandProductArea(nhLandInfo.getMu());
            nhCollectTaskLand.setLandProduce(nhLandInfo.getLandProduce());
            nhCollectTaskLand.setLandProduct(nhLandInfo.getLandProduct());
            nhCollectTaskLand.setLandTownName(nhLandInfo.getLandTownName());
            nhCollectTaskLand.setLandVillageName(nhLandInfo.getLandVillageName());
            nhCollectTaskList.add(nhCollectTaskLand);

        }
        System.out.println(nhCollectTaskList);
        nhCollectTaskLandMapper.insertList(nhCollectTaskList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAudit(Long[] landIds, String username, String auditMemo, Integer auditStatus) {
        Example example = new Example(NhCollectTaskLand.class);
        example.createCriteria().andIn("id", Arrays.asList(landIds));

        List<NhCollectTaskLand> nhCollectTaskLands = nhCollectTaskLandMapper.selectByExample(example);
        nhCollectTaskLands.stream().forEach((value) -> {
            value.setAuditStatus(auditStatus);
            value.setAuditPerson(username);
            value.setAuditDate(new Date());
            value.setAuditMemo(auditMemo);
            value.setUpdateTime(new Date());

            nhCollectTaskLandMapper.updateByPrimaryKeySelective(value);
            if (auditStatus == 2) {
                System.out.println(value.getLandYearValue());
                NhLandInfo nhLandInfo = new NhLandInfo();
                nhLandInfo.setAuditStatus(value.getAuditStatus());
                nhLandInfo.setAuditDate(value.getAuditDate());
                nhLandInfo.setAuditMemo(value.getAuditMemo());
                nhLandInfo.setAuditPerson(value.getAuditPerson());
                nhLandInfo.setLandPlanId(value.getPlanId());
                nhLandInfo.setLandType(value.getLandType());
                nhLandInfo.setLandTypeName(value.getLandTypeName());
                nhLandInfo.setLandName(value.getLandName());
                nhLandInfo.setLandOtherType(value.getLandOtherType());
                nhLandInfo.setLandProduct(value.getLandProduct());
                nhLandInfo.setLandYearValue(value.getLandYearValue());
                nhLandInfo.setMu(value.getLandProductArea());
                nhLandInfo.setLandProduce(value.getLandProduce());
                nhLandInfo.setLandVillageCode(value.getLandVillageCode());
                nhLandInfo.setLandTownCode(value.getLandTownCode());
                nhLandInfo.setImgUrl(value.getImgUrl());
                nhLandInfo.setUpdatePerson(value.getUpdatePerson());
                nhLandInfo.setLandYearOutput(value.getLandYearOutput());
                nhLandInfo.setLandOutputUnit(value.getLandOutputUnit());
                nhLandInfo.setLandTownName(value.getLandTownName());
                nhLandInfo.setLandVillageName(value.getLandVillageName());
                nhLandInfo.setUpdateTime(new Date());
                Example example1 = new Example(NhLandInfo.class);
                example1.createCriteria().andEqualTo("landCode", value.getLandId());
                nhLandInfoMapper.updateByExampleSelective(nhLandInfo, example1);
               /* System.out.println("nhLandInfos"+nhLandInfos);
                nhLandInfos.stream().forEach((item) -> {
                    System.out.println(item.getLandCode());
                    System.out.println(value.getLandId());
                    if (item.getLandCode().equals(value.getLandId())) {
                        System.out.println("1234");
                        item.setAuditStatus(value.getAuditStatus());
                        item.setAuditDate(value.getAuditDate());
                        item.setAuditMemo(value.getAuditMemo());
                        item.setAuditPerson(value.getAuditPerson());
                        item.setLandPlanId(value.getPlanId());
                        item.setLandType(value.getLandType());
                        item.setLandTypeName(value.getLandTypeName());
                        item.setLandOtherType(value.getLandOtherType());
                        item.setLandProduct(value.getLandProduct());
                        item.setLandYearValue(value.getLandYearValue());
                        item.setMu(value.getLandProductArea());
                        item.setLandProduce(value.getLandProduce());
                        item.setImgUrl(value.getImgUrl());
                        item.setUpdatePerson(value.getUpdatePerson());
                        item.setUpdateTime(new Date());
                        nhLandInfoMapper.updateByPrimaryKeySelective(item);
                    }
                });*/
            }
        });


    }


    @Override
    public PageInfo<NhCollectTaskLand> selectCollectTaskLandList(CollectTaskLandConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());

      List<NhCollectTaskLand> collectTaskLand= nhCollectTaskLandMapper.findPageBreakByCondition(vo);
        for (NhCollectTaskLand nhCollectTaskLand : collectTaskLand) {
            if (nhCollectTaskLand.getImgUrl() != null && !"".equals(nhCollectTaskLand.getImgUrl())) {
                try {
                    imgs = myRestTemplate.getForObject(GATEWAY_SERVICE + "/oss/file/getList?pictureIds=" + nhCollectTaskLand.getImgUrl(), String.class);
                    JSONObject j1 = JSONObject.parseObject(imgs);
                    nhCollectTaskLand.setOssImgList(j1.getJSONArray("data"));
                }catch (Exception e){
                    nhCollectTaskLand.setOssImgList(new JSONArray());
                }
            }
        }
        return new PageInfo<>(collectTaskLand);
    }

    /**
     * 地块任务关联信息列表
     */
    @Override
    public List<CollectTaskLandRs> getCollectPlanLandStatistics(Long planId) {
        List<CollectTaskLandRs> list = new ArrayList<>();
        CollectTaskLandRs collectTaskLandRs;
        collectTaskLandRs = nhCollectTaskLandMapper.getCollectPlanLandStatistics(planId);
        if (collectTaskLandRs != null) {
            collectTaskLandRs.setTotal(collectTaskLandRs.getCollectNum() + collectTaskLandRs.getNoCollectNum());
        }
        list.add(collectTaskLandRs);
        return list;
    }

    /**
     * 查看计划任务详情 详细人员执行情况
     */
    @Override
    public PageInfo<CollectTaskLandUser> selectCollectLandUserList(CollectTaskLandConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        return new PageInfo<>(nhCollectTaskLandMapper.findPageBreakByUserList(vo.getCollectTaskLand().getPlanId(), vo.getKeywords(), vo.getAreaCode()));
    }


    @Override
    public List<CollectTaskLandRs> getCollectPlanLandCondition(CollectTaskLandConditionVO collectTaskLandConditionVO) {
        collectTaskLandConditionVO.setUserLevel(4);
        List<CollectTaskLandRs> list1 = res(collectTaskLandConditionVO);

        for (CollectTaskLandRs collectTaskLandRs : list1) {
            collectTaskLandConditionVO.getCollectTaskLand().setAuditStatus(0);
            collectTaskLandConditionVO.getCollectTaskLand().setCollectStatus(0);
            collectTaskLandConditionVO.setUserLevel(5);

            List<CollectTaskLandRs> list2 = res(collectTaskLandConditionVO);
            collectTaskLandRs.setChildren(list2);
        }

        return list1;
    }


    private List<CollectTaskLandRs> res(CollectTaskLandConditionVO collectTaskLandConditionVO) {

        List<CollectTaskLandRs> list1 = nhCollectTaskLandMapper.getCollectPlanLandCondition(collectTaskLandConditionVO);
        collectTaskLandConditionVO.getCollectTaskLand().setCollectStatus(2);
        List<CollectTaskLandRs> list2 = nhCollectTaskLandMapper.getCollectPlanLandCondition(collectTaskLandConditionVO);
        CollectTaskLand collectTaskLand = new CollectTaskLand();
        collectTaskLand.setPlanId(collectTaskLandConditionVO.getCollectTaskLand().getPlanId());
        collectTaskLand.setAuditStatus(2);
        collectTaskLandConditionVO.setCollectTaskLand(collectTaskLand);
        List<CollectTaskLandRs> list3 = nhCollectTaskLandMapper.getCollectPlanLandCondition(collectTaskLandConditionVO);
        List<String> categoties = new ArrayList<>();
        for (CollectTaskLandRs item : list1) {
            categoties.add(item.getAreaName());
            for (CollectTaskLandRs item2 : list2) {
                if (item.getAreaCode().equals(item2.getAreaCode())) {
                    item.setCount2(item2.getCount());
                }
            }
            for (CollectTaskLandRs item3 : list3) {
                if (item.getAreaCode().equals(item3.getAreaCode())) {
                    item.setCount3(item3.getCount());
                }
            }
        }
        return list1;
    }

}

    /*@Override
    public  Map<String,Object>  getCollectPlanLandCondition2(CollectTaskLandConditionVO collectTaskLandConditionVO) {

        Map<String,Object> map=new HashMap<>();
        List<CollectTaskLandRs> list1 = res(collectTaskLandConditionVO);

      //  collectTaskLandConditionVO.getCollectTaskLand().setAuditStatus(0);
       // collectTaskLandConditionVO.getCollectTaskLand().setCollectStatus(2);
        collectTaskLandConditionVO.setUserLevel(4);
        List<CollectTaskLandRs> list2 = res(collectTaskLandConditionVO);
        list1.addAll(list2);
        map.put("list1",list1);

        return map;
    }

    @Override
    public PageInfo<CollectTaskLandUser> selectCollectLandUserList(CollectTaskLandConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        return new PageInfo<CollectTaskLandUser>(nhCollectTaskLandMapper.findPageBreakByUserList(vo.getCollectTaskLand().getPlanId(),vo.getKeywords()));
    }


}
*/
