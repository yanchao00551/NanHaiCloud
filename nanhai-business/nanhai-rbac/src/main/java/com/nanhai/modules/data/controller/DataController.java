package com.nanhai.modules.data.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.*;

import com.nanhai.core.business.vo.CollectTaskLandConditionVO;
import com.nanhai.core.business.vo.LandSubjectConditionVO;
import com.nanhai.core.business.vo.StatisticsConditionVO;
import com.nanhai.core.business.vo.SubjectInfoConditionVO;
import com.nanhai.core.framework.object.AbstractController;
import com.nanhai.core.framework.object.SsoUser;
import com.nanhai.core.persistence.beans.*;
import com.nanhai.core.util.R;

import com.nanhai.modules.data.service.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * 数据资源
 *
 * @author luobo
 * @create 2021/5/14
 */
@Slf4j
@RestController
@RequestMapping("/data")
@Validated

public class DataController extends AbstractController {

    @Autowired
    private NhSubjectInfoService nhSubjectInfoService;

    @Autowired
    private NhSubjectYearTotalValueService subjectYearTotalValueService;
    @Autowired
    private NhLandSubjectService nhLandSubjectService;
    @Autowired
    private NhLandInfoService nhLandInfoService;
    @Autowired
    private NhLandNameRuleService nhLandNameRuleService;
    @Autowired
    private NhCollectTaskLandService nhCollectTaskLandService;
    @Autowired
    private StatisticsService statisticsService;
    //TODO 生产主体信息---------------

    /**
     * 新增主体信息
     *
     * @param
     * @return
     */
    @PostMapping("/subject/create")
    public R insertSubjectInfo(SubjectInfo subjectInfo, Authentication authentication) {
        //权限写完
        SsoUser user = parse(authentication);
        subjectInfo.setCreatePerson(user.getUsername());
        nhSubjectInfoService.insertSubjectInfo(subjectInfo);
        return R.ok();
    }

    /**
     * 新增主体和关系信息
     *
     * @param
     * @return
     */
    @PostMapping("/subject/createInfo")
    public R insertSubjectInfo2(SubjectInfo subjectInfo, LandSubject landSubject, Authentication authentication) {
        SsoUser user = parse(authentication);
        subjectInfo.setCreatePerson(user.getUsername());
        //新增主体
        nhSubjectInfoService.insertSubjectInfo(subjectInfo);
        //新增关系信息
        String subjectC = subjectInfo.getNhSubjectInfo().getSubjectCode();
        landSubject.getNhLandSubject().setLsSubjectCode(subjectC);
        nhLandSubjectService.add(landSubject);

        return R.ok();
    }

    /**
     * 修改主体和生产信息
     *
     * @param
     * @param authentication
     * @return
     */
    @PostMapping("/subject/updateInfo")
    public R putSubjectInfo2(SubjectInfo subjectInfo, LandSubject landSubject, Authentication authentication) {
        //权限写完
        SsoUser user = parse(authentication);
        subjectInfo.setCreatePerson(user.getUsername());
        //修改关系信息
        nhLandSubjectService.updateLandSubject(landSubject);
        return R.ok();
    }


    /**
     * 修改主体信息
     *
     * @param subjectInfo
     * @param authentication
     * @return
     */
    @PostMapping("/subject/put")
    public R putSubjectInfo(SubjectInfo subjectInfo, Authentication authentication) {
        //权限写完
        SsoUser user = parse(authentication);
        subjectInfo.setCreatePerson(user.getUsername());
        nhSubjectInfoService.updateSubjectInfo(subjectInfo);
        return R.ok();
    }


    /**
     * 分页获取主体信息
     *
     * @param vo
     * @param authentication
     * @return
     */
    @GetMapping("/subject/getSubjectInfoList")

    public R getSubjectInfoList(@ModelAttribute SubjectInfoConditionVO vo, Authentication authentication) {
        System.out.println("aaaa");
        System.out.println(vo);

        //获取主体信息
        PageInfo<NhSubjectInfo> page = nhSubjectInfoService.findPageBreakByCondition(vo, parse(authentication));
        return R.ok().put("data", page);
    }





//TODO 主体年产值 ---------------

    /**
     * 增加主体年产值
     *
     * @param subjectYearTotalValue
     * @return
     */

    @PostMapping(value = "SubjectYearTotalValue/insert")

    public R insertSubjectYearTotalValue(SubjectYearTotalValue subjectYearTotalValue) {


        subjectYearTotalValueService.insertSubjectYearTotalValue(subjectYearTotalValue);
        return R.ok("");
    }


    /**
     * 删除主体年产值
     */
    @PostMapping(value = "SubjectYearTotalValue/delete")

    public R deleteSubjectYearTotalValue(Long id) {
        subjectYearTotalValueService.deleteSubjectYearTotalValue(id);
        return R.ok("");
    }

    /**
     * 修改主体年产值
     */
    @PostMapping("SubjectYearTotalValue/put")
    public R putSubjectYearTotalValue(SubjectYearTotalValue subjectYearTotalValue) {

        subjectYearTotalValueService.putSubjectYearTotalValue(subjectYearTotalValue);

        return R.ok("");
    }

    /**
     * 通过主体code 获取主体年产值列表
     *
     * @param subjectInfoConditionVO
     * @return
     */
    @GetMapping("SubjectYearTotalValue/get")
    public R getSubjectYearTotalValueList(@NotNull(message = "缺少参数:subjectCode") SubjectInfoConditionVO subjectInfoConditionVO) {
        PageInfo<NhSubjectYearTotalValue> pageInfo = subjectYearTotalValueService.findSubjectYearTotalValues(subjectInfoConditionVO);
        return R.ok().put("data", pageInfo);
    }


    //TODO 地块信息 ---------------

    /**
     * 获取地块列表
     */
    @GetMapping("LandInfo/getList")
    public R getLandInfoList(LandSubjectConditionVO landInfoConditionVO, Authentication authentication) {
        SsoUser user = parse(authentication);
        landInfoConditionVO.setUserLevel(user.getUserLevel());
        landInfoConditionVO.setAdministrativeCode(user.getAdministrativeCode());
        System.out.println("landInfoConditionVO" + landInfoConditionVO);
        PageInfo<NhLandInfo> page = nhLandInfoService.findPageBreakByCondition(landInfoConditionVO);
        return R.ok().put("data", page);
    }

    /**
     * 修改地块信息（信息采集）
     *
     * @param landInfo @Validated ({Group.One.class})
     * @return
     */

    @PostMapping("LandInfo/put")
    public R updateLandInfo(LandInfo landInfo) {
        System.out.println("landInfo" + landInfo);
        nhLandInfoService.updateLandInfo(landInfo);
        return R.ok();
    }


    /**
     * 修改地块信息（信息采集） 插入中间表
     *
     * @param landInfo @Validated ({Group.One.class})
     * @return
     */
    @PostMapping("LandInfo/collect")
    public R collectLandInfo(LandInfo landInfo, Authentication authentication) {
        SsoUser ssoUser = parse(authentication);
        landInfo.setUpdatePerson(ssoUser.getUsername());
        nhLandInfoService.collectLandInfo(landInfo);
        return R.ok();
    }


    //TODO 地块命名规则 ---------------

    /**
     * 地块命名规则获取
     */
    @GetMapping("LandInfoRule/get")
    public R getLandNameRuleList() {
        PageInfo<NhLandNameRule> res = nhLandNameRuleService.getLandNameRuleList();
        return R.ok().put("data", res);
    }

    /**
     * 地块命名规则修改
     */
    @PostMapping("LandInfoRule/put")
    public R updateLandNameRuleById(@NotNull(message = "缺少必要参数") LandNameRule landNameRule) {
        nhLandNameRuleService.updateLandNameRuleById(landNameRule);
        return R.ok().put("data", "");
    }

    @PostMapping("LandInfoRule/getLandNameAuto")
    public R getLandNameAuto(@NotNull(message = "缺少必要参数:landId") Long landId, @NotNull(message = "缺少必要参数:town") String town, @NotNull(message = "缺少必要参数:village") String village, @NotNull(message = "缺少必要参数:landType") String landType) {

        String landName = nhLandNameRuleService.getLandNameAuto(landId, town, village, landType);
        return R.ok().put("data", landName);
    }


    //TODO 主体地块关闭表

    /**
     * 添加主体 地块关系表
     */
    @PostMapping("LandSubject/add")
    public R insertLandSubject(LandSubject landSubject) {
        nhLandSubjectService.add(landSubject);
        return R.ok();
    }

    /**
     * 删除 主体地块关系表
     */
    @PostMapping("LandSubject/delete")
    public R deleteLandSubject(@NotNull(message = "缺少必要参数") Long id) {
        nhLandSubjectService.delete(id);
        return R.ok();
    }

    @PostMapping("LandSubject/put")
    public R updateLandSubject(@NotNull(message = "缺少必要参数") LandSubject landSubject) {
        nhLandSubjectService.updateLandSubject(landSubject);
        return R.ok();
    }

    @GetMapping("LandSubject/get")
    public R getLandSubject(@NotNull(message = "缺少必要参数") LandSubjectConditionVO vo) {
        PageInfo<LandSubjectRs> page = nhLandSubjectService.selectLandSubject(vo);
        return R.ok().put("data", page);
    }

    //TODO 地块任务关联信息 ---------------

    /**
     * 增加地块任务关联信息
     * 供微服务调用
     */
    @PostMapping(value = {"/CollectTaskLand/insert"})
    public R insertCollectTaskLand(@RequestBody NhPlanInfo planInfo, Authentication authentication) {
        SsoUser user = parse(authentication);
        planInfo.setCreatePerson(user.getUsername());
        nhCollectTaskLandService.insertCollectTaskLand(planInfo);
        return R.ok();
    }


    /**
     * 地块任务关联信息列表
     */
    @PostMapping("CollectPlanLand/Condition")
    public R getCollectPlanLandCondition(@NotNull CollectTaskLandConditionVO collectTaskLandConditionVO,Authentication authentication) {
        SsoUser user =parse(authentication);
        collectTaskLandConditionVO.setUserLevel(user.getUserLevel());
        collectTaskLandConditionVO.setAdministrativeCode(user.getAdministrativeCode());

        List<CollectTaskLandRs> res = nhCollectTaskLandService.getCollectPlanLandCondition(collectTaskLandConditionVO);
        return R.ok().put("data", res);
    }







    @GetMapping("CollectTaskLand/list")
    public R selectCollectTaskLandList(CollectTaskLandConditionVO vo, Authentication authentication) {
        SsoUser user = parse(authentication);
        vo.setUserLevel(user.getUserLevel());
        vo.setAdministrativeCode(user.getAdministrativeCode());
        PageInfo<NhCollectTaskLand> page = nhCollectTaskLandService.selectCollectTaskLandList(vo);
        return R.ok().put("data", page);
    }


    /**
     * 批量修改接口
     * @author 萝卜
     */
    @PostMapping(value = "/auditLand")
    public R auditLand(Long[] landIds,  @NotNull(message = "地块类型") Integer landType,@NotNull(message = "地块类型")Integer landTroduct){


   //     nhCollectTaskLandService.updateAudit();
        return R.ok();
    }








    //TODO  统计数据
    @GetMapping("statistics/get")
    public R getStatistics(StatisticsConditionVO vo,Authentication authentication) {
        SsoUser sysUser=parse(authentication);
        vo.setUserLevel(sysUser.getUserLevel());
        vo.setAdministrativeCode(sysUser.getAdministrativeCode());
        Map<String ,Object> list=statisticsService.getStatistics(vo);
        return R.ok().put("data",list);
    }


    //TODO: 查看计划任务详情 详细人员执行情况
    @GetMapping("CollectTaskLand/userList")
    public R getCollectLandUserList(CollectTaskLandConditionVO vo){
        PageInfo<CollectTaskLandUser> page = nhCollectTaskLandService.selectCollectLandUserList(vo);
        return R.ok().put("data",page);
    }

    /**
     * 地块任务关联信息列表
     */
    @GetMapping("CollectPlanLand/Statistics")
    public R getCollectPlanLandStatistics(@NotNull Long planId) {
        List<CollectTaskLandRs> res = nhCollectTaskLandService.getCollectPlanLandStatistics(planId);
        return R.ok().put("data", res);
    }





}
