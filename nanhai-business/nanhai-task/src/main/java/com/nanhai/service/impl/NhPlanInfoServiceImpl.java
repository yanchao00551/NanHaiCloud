package com.nanhai.service.impl;


import cn.hutool.core.util.PinyinUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.AdministrativeArea;
import com.nanhai.core.business.entity.CollectTask;
import com.nanhai.core.business.entity.CollectTaskLandRs;
import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.core.framework.object.MyRestTemplate;
import com.nanhai.core.business.entity.PlanInfo;
import com.nanhai.core.business.vo.PlanInfoConditionVO;
import com.nanhai.core.persistence.beans.NhCollectTask;
import com.nanhai.core.persistence.beans.NhPlanInfo;
import com.nanhai.core.util.EmptyUtils;
import com.nanhai.core.util.R;
import com.nanhai.mapper.NhCollectTaskMapper;
import com.nanhai.mapper.NhPlanInfoMapper;
import com.nanhai.service.NhPlanInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @PackageName:com.nanhai.service.impl
 * @ClassName:NhPlanInfoServiceImpl
 * @Description:
 * @author: 悟空
 * @date: 2021/5/13 20:35
 * @email: 10947@163.com
 */
@Service
@Slf4j
public class NhPlanInfoServiceImpl implements NhPlanInfoService {

    @Autowired
    private NhCollectTaskMapper collectTaskMapper;
    @Autowired
    private NhPlanInfoMapper nhPlanInfoMapper;


    //将访问地址改为网关服务名称
    private static final String GATEWAY_SERVICE = "http://nanhai-zuul-gateway:8280/";


    @Autowired
    private NhPlanInfoMapper planInfoMapper;


    @Autowired
    private MyRestTemplate myRestTemplate;

    @Override
    public PageInfo<PlanInfo> findPageBreakByCondition(PlanInfoConditionVO vo) {
        //指定返回的分页数据格式
        PageInfo bean = new PageInfo<NhPlanInfo>();

        //详情单个 或 多个
        PlanInfo p = vo.getPlanInfo();
        if (EmptyUtils.isNotEmpty(p) || EmptyUtils.isNotEmpty(vo.getPlanInfoIds())) {

            NhPlanInfo nhPlanInfo = null;
            List<NhPlanInfo> nhPlanInfos = new ArrayList<>();

            List<AdministrativeArea> administrativeAreaList = null;
            //三级区域
            JSONObject treeData = null;
            //图片列表
            JSONArray arrObj = null;


            List<PlanInfo> boList = new LinkedList<>();
            String imgs = null;


            //TODO: 只有单个才返回 图片列表和三级区域
            if (EmptyUtils.isNotEmpty(p)) {
                Long id = vo.getPlanInfo().getId();
                nhPlanInfo = planInfoMapper.selectByPrimaryKey(id);

                //TODO: 递归获取采集区域,如果传来计划id，则将这个计划的所有区域标注以选中状态
                String str = myRestTemplate.getForObject(GATEWAY_SERVICE + "/baseinfo/v1.0/getSelectAreaData?planId=" + id, String.class);
                //TODO: 返回
                JSONObject jsonObject = JSONObject.parseObject(str);
                treeData = jsonObject.getJSONObject("data");
                log.info("树形区域列表，获取该计划的区、镇、村：{}", treeData);


                //TODO: 调用OSS服务获取对应计划id的服务
                if (EmptyUtils.isNotEmpty(nhPlanInfo.getPlanFiles())) {
                    try {
                        imgs = myRestTemplate.getForObject(GATEWAY_SERVICE + "/oss/file/getList?pictureIds=" + nhPlanInfo.getPlanFiles(), String.class);
                        JSONObject j1 = JSONObject.parseObject(imgs);
                        arrObj = j1.getJSONArray("data");
                    } catch (Exception e) {
                        arrObj = new JSONArray();
                    }
                    log.info("OSS图片列表：{}", arrObj);
                }
                nhPlanInfo = planInfoMapper.selectByPrimaryKey(id);
                nhPlanInfo.setTreeData(treeData);
                nhPlanInfo.setOssImgList(arrObj);
                boList.add(new PlanInfo(nhPlanInfo));

                //指定返回的分页数据格式
                bean = new PageInfo<NhPlanInfo>();
                bean.setList(boList);
                return bean;
            }

            //TODO: 只有单个才返回 图片列表和三级区域
            if (EmptyUtils.isNotEmpty(vo.getPlanInfoIds())) {
                Example example = new Example(NhPlanInfo.class);

                example.createCriteria().andIn("id", vo.getPlanInfoIds());
                nhPlanInfos = planInfoMapper.selectByExample(example);

                for (NhPlanInfo bizTask : nhPlanInfos) {
                    boList.add(new PlanInfo(bizTask));
                }

            }

            //指定返回的分页数据格式
            bean = new PageInfo<NhPlanInfo>();
            bean.setList(boList);
            return bean;
        }


        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<NhPlanInfo> list = planInfoMapper.findPageBreakByCondition(vo);

        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<Long> ids = list.stream().map(NhPlanInfo::getId).collect(Collectors.toList());


        List<PlanInfo> boList = new LinkedList<>();
        for (NhPlanInfo nhPlanInfo : list) {
            boList.add(new PlanInfo(nhPlanInfo));
        }


        //设置最终结果集合
        bean.setList(boList);

        return bean;
    }

    HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }


    @Override
    public PageInfo<PlanInfo> findPlanAccordingToTheTask(PlanInfoConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());

        List<NhPlanInfo> list = planInfoMapper.findPlanAccordingToTheTask(vo);
        if (CollectionUtils.isEmpty(list)) {
            return  new PageInfo<>();
        }
        List<Long> ids = list.stream().map(NhPlanInfo::getId).collect(Collectors.toList());

        List<NhPlanInfo> listPlan = planInfoMapper.listPlanInfosTaskByPlanId(ids);

        Map<Long, NhPlanInfo> tagMap = listPlan.stream().collect(Collectors.toMap(NhPlanInfo::getId, a -> a, (k1, k2) -> k1));

        List<PlanInfo> boList = new LinkedList<>();
        for (NhPlanInfo bizTask : list) {
            NhPlanInfo planInfo = tagMap.get(bizTask.getId());
            if (null == planInfo) {
                log.warn("计划[{},{}] 未绑定任务信息，或者已绑定的任务不存在！", bizTask.getPlanName(), bizTask.getId());
            } else {
                bizTask.setCollectTasks(planInfo.getCollectTasks());
            }
            boList.add(new PlanInfo(bizTask));
        }

        PageInfo bean = new PageInfo<NhPlanInfo>(list);
        bean.setList(boList);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int createPlan(PlanInfo planInfo) {
        Assert.notNull(planInfo, "PlanInfo不可为空！");

        //TODO: 计划状态 1:默认待发布 2:已发布 3:撤回发布 4:已启用 5：已停用
        //TODO: 插入计划表
        planInfo.setPlanStatus(1);
        planInfo.setCreateTime(new Date());
        String pym = PinyinUtil.getAllFirstLetter(planInfo.getPlanName());
        planInfo.setPlanCode(pym);
        int i = planInfoMapper.insertSelective(planInfo.getNhPlanInfo());
        int res = 0;

        if (i > 0) {
            res = planInfo.getNhPlanInfo().getId().intValue();
            //TODO: 取到回写插入主键对象
            NhPlanInfo nhPlanInfo = planInfo.getNhPlanInfo();

            //TODO: 解析json字符串创建任务列表
            JSONObject jsonObject = JSONObject.parseObject(planInfo.getArea());
            Set<String> keys = jsonObject.keySet();
            Iterator<String> itr = keys.iterator();
            List<String> villageCodeList = new LinkedList<>();
            while (itr.hasNext()) {
                //TODO: 获取 administrative_level为4 镇、街道行政编码 如：440605123
                String townId = itr.next();
                JSONArray jsonArray = jsonObject.getJSONArray(townId);
                NhCollectTask nhCollectTask = new NhCollectTask();
                for (int j = 0; j < jsonArray.size(); j++) {
                    //TODO: 获取 administrative_level为5 社区、村级行政编码 如：440605011002
                    String vallageId = (String) jsonArray.get(j);
                    villageCodeList.add(vallageId);
                    //TODO: 生成对应任务
                    nhCollectTask.setId(null);
                    nhCollectTask.setCollectTaskPlanId(nhPlanInfo.getId());
                    nhCollectTask.setCollectTaskTownId(townId);
                    nhCollectTask.setCollectTaskVillageId(vallageId);
                    nhCollectTask.setCreateTime(new Date());
                    collectTaskMapper.insertSelective(nhCollectTask);
                }
            }
            if (villageCodeList.size() > 0) {
                NhPlanInfo plan = new NhPlanInfo();
                plan.setVillageCode(villageCodeList);
                plan.setId(nhPlanInfo.getId());
                R r = myRestTemplate.postForObject(GATEWAY_SERVICE + " /rbac/data/CollectTaskLand/insert", plan, R.class);

            }

        } else {
            return 0;
        }
        return res;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updatePlan(PlanInfo planInfo) {
        Assert.notNull(planInfo.getId(), "Id不可为空！");

        //TODO: 计划状态 1:默认待发布 2:已发布 3:撤回发布 4:已启用 5：已停用
        //TODO: 修改计划表
        planInfo.setPlanStatus(1);
        planInfo.setUpdateTime(new Date());
        String pym = PinyinUtil.getAllFirstLetter(planInfo.getPlanName());
        planInfo.setPlanCode(pym);
        int i = planInfoMapper.updateByPrimaryKeySelective(planInfo.getNhPlanInfo());
        if (i > 0) {
            //TODO: 取到回写插入主键对象
            NhPlanInfo nhPlanInfo = planInfo.getNhPlanInfo();

            //TODO: 解析json字符串创建任务列表
            JSONObject jsonObject = JSONObject.parseObject(planInfo.getArea());
            Set<String> keys = jsonObject.keySet();
            Iterator<String> itr = keys.iterator();
            while (itr.hasNext()) {
                //TODO: 获取 administrative_level为4 镇、街道行政编码 如：440605123
                String townId = itr.next();
                JSONArray jsonArray = jsonObject.getJSONArray(townId);
                //TODO:先删除该计划所有的任务
                Example example = new Example(NhCollectTask.class);
                example.createCriteria().andEqualTo("collectTaskPlanId", planInfo.getId());
                int delNum = collectTaskMapper.deleteByExample(example);
                for (int j = 0; j < jsonArray.size(); j++) {
                    //TODO: 获取 administrative_level为5 社区、村级行政编码 如：440605011002
                    String vallageId = (String) jsonArray.get(j);
                    //TODO: 查询任务表，是否存在该条记录，如果存在则修改，不存在则新增
                    NhCollectTask nhNewInfo = new NhCollectTask();
                    nhNewInfo.setCollectTaskPlanId(nhPlanInfo.getId());
                    nhNewInfo.setCollectTaskTownId(townId);
                    nhNewInfo.setCollectTaskVillageId(vallageId);
                    nhNewInfo.setCreateTime(new Date());
                    collectTaskMapper.insertSelective(nhNewInfo);
                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean setStatus(Long id, Integer status, String username) {
        NhPlanInfo nhPlanInfo = new NhPlanInfo();
        NhPlanInfo obj = nhPlanInfoMapper.selectByPrimaryKey(id);
        if (EmptyUtils.isEmpty(obj)) {
            return false;
        }
        nhPlanInfo.setId(id);
        nhPlanInfo.setPlanStatus(status);
        nhPlanInfo.setUpdatePerson(username);
        nhPlanInfo.setUpdateTime(new Date());
        nhPlanInfoMapper.updateByPrimaryKeySelective(nhPlanInfo);
        return true;
    }


    @Override
    public PageInfo<PlanInfo> queryMyPlan(PlanInfoConditionVO vo) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        vo.setTime(df.format(new Date()));
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<NhPlanInfo> list = planInfoMapper.queryMyPlan(vo);
        if (CollectionUtils.isEmpty(list)) {
            return new PageInfo<>();
        }
        List<Long> ids = list.stream().map(NhPlanInfo::getId).collect(Collectors.toList());
        List<NhPlanInfo> listPlan = planInfoMapper.listPlanInfosTaskByPlanId(ids);
        Map<Long, NhPlanInfo> tagMap = listPlan.stream().collect(Collectors.toMap(NhPlanInfo::getId, a -> a, (k1, k2) -> k1));
        List<PlanInfo> boList = new LinkedList<>();
        for (NhPlanInfo bizTask : list) {


            if (!EmptyUtils.isEmpty(bizTask.getId())) {
                try {
                    Long planId = bizTask.getId();
                    String testList = myRestTemplate.getForObject(GATEWAY_SERVICE + "rbac/data/CollectPlanLand/Statistics?planId=" + planId, String.class);

                    JSONObject j1 = JSONObject.parseObject(testList);

                    bizTask.setCollectTaskLandRs(j1.getJSONArray("data"));

                } catch (Exception e) {
                    e.printStackTrace();
                    bizTask.setCollectTaskLandRs(new JSONArray());
                }

            }


            NhPlanInfo planInfo = tagMap.get(bizTask.getId());
            if (null == planInfo) {
            } else {
                bizTask.setCollectTasks(planInfo.getCollectTasks());
            }
            boList.add(new PlanInfo(bizTask));
        }

        PageInfo bean = new PageInfo<NhPlanInfo>(list);
        bean.setList(boList);
        return bean;
    }






    @Override
    public PlanInfo insert(PlanInfo entity) {
        return null;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(PlanInfo entity) {
        return false;
    }


    @Override
    public PlanInfo getByPrimaryKey(Long primaryKey) {
        return null;
    }
}
