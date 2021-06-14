package com.nanhai.api;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.CollectTask;
import com.nanhai.core.business.entity.PlanInfo;
import com.nanhai.core.business.vo.CollectTaskConditionVO;
import com.nanhai.core.business.vo.PlanInfoConditionVO;
import com.nanhai.core.framework.object.AbstractController;
import com.nanhai.core.framework.object.ResponseVO;
import com.nanhai.core.framework.object.SsoUser;
import com.nanhai.core.util.R;
import com.nanhai.service.NhCollectTaskService;
import com.nanhai.service.NhPlanInfoService;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 计划、任务 微服务接口
 * @PackageName:com.nanhai.api
 * @ClassName:RestController
 * @Description:
 * @author: 悟空
 * @date: 2021/5/13 19:42
 * @email: 10947@163.com
 */
@Slf4j
@RestController
@RequestMapping(value = "/task")
public class ApiController extends AbstractController {

    @Autowired
    private NhPlanInfoService planInfoService;
    @Autowired
    private NhCollectTaskService collectTaskService;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable String id, Authentication authentication) {
        SsoUser user = parse(authentication);
        return "user: " + id +user;
    }

    /**
     * 获取计划列表/获取详情或多个 同时获得oss图片列表
     * @author 悟空
     * @description //TODO
     * @date 16:14 2021/5/14
     * @param vo
     * @return com.nanhai.core.util.R
     */
    @GetMapping(value = "/getAListOfPlans")
    public R getAListOfPlans(PlanInfoConditionVO vo){
        log.info("VO:{}",vo);
        PageInfo<PlanInfo> pageInfo = planInfoService.findPageBreakByCondition(vo);
        return R.ok().put("data",pageInfo);
    }



    /**
     * 根据计划查询多个任务（支持多个计划id）
     * @author 悟空
     * @description //TODO
     * @date 13:59 2021/5/15
     * @param
     * @return com.nanhai.core.util.R
     */
    @GetMapping(value = "/queryTasksAccordingToPlan")
    public R queryTasksAccordingToPlan(CollectTaskConditionVO vo,Authentication authentication){
        log.info("VO:{}",vo);
        SsoUser ssoUser = parse(authentication);
        vo.setUserLevel(ssoUser.getUserLevel().toString());
        vo.setAdministrativeCode(ssoUser.getAdministrativeCode());
        PageInfo<CollectTask> collectTaskList = collectTaskService.findTasksAccordingToPlan(vo);
        return R.ok().put("data",collectTaskList);
    }



    @PostMapping(value = "/putTask")
    public R putTask(CollectTask collectTask){
        collectTaskService.updateTask(collectTask);

        return  R.ok();
    }


    /**
     * 根据计划单个或多个查询多个任务（支持多个任务id)
     * @author 悟空
     * @description //TODO
     * @date 16:31 2021/5/15
     * @param vo
     * @return com.nanhai.core.util.R
     */
    @GetMapping(value = "queryPlanAccordingToTheTask")
    public R queryPlanAccordingToTheTask(PlanInfoConditionVO vo){
        log.info("VO:{}",vo);
        PageInfo<PlanInfo> planInfoPageInfo = planInfoService.findPlanAccordingToTheTask(vo);
        return R.ok().put("data",planInfoPageInfo);
    }


    /**
     * 根据计划单个或多个查询多个任务（支持多个任务id)
     * @author 悟空
     * @description //TODO
     * @date 16:31 2021/5/15
     * @param vo
     * @return com.nanhai.core.util.R
     */
    @GetMapping(value = "queryMyPlan")
    public R queryMyPlan(PlanInfoConditionVO vo,Authentication authentication){
        log.info("VO:{}",vo);
        //TODO: 设置任务创建者
        SsoUser ssoUser = parse(authentication);
        vo.setUserLevel(ssoUser.getUserLevel().toString());
        vo.setAdministrativeCode(ssoUser.getAdministrativeCode());
        PageInfo<PlanInfo> planInfoPageInfo = planInfoService.queryMyPlan(vo);

        return R.ok().put("data",planInfoPageInfo);
    }

    /**
     * 创建计划 只有区级才可以创建计划
     * @author 悟空
     * @description //TODO
     * @date 20:46 2021/5/16
     * @param planInfo
     * @return com.nanhai.core.util.R
     */
    @PostMapping(value = "/add")
    public R add(PlanInfo planInfo,Authentication authentication){
        //TODO: 还未增加其他逻辑
        log.info("PlanInfo:{}",planInfo);
        SsoUser ssoUser = parse(authentication);
        //TODO: 设置任务创建者
        planInfo.setCreatePerson(ssoUser.getUsername());
       int res= planInfoService.createPlan(planInfo);
        if(res<=0){
            return R.error(-99998,"计划创建失败").put("result","fail");
        }
        return R.ok("创建计划成功，默认未发布状态").put("data",res);
    }

    /**
     * 修改计划
     * @author 悟空
     * @description //TODO
     * @date 9:24 2021/5/21
     * @param authentication
     * @param planInfo
     * @return com.nanhai.core.util.R
     */
    @PostMapping(value = "/update")
    public R update(Authentication authentication,PlanInfo planInfo){
        log.info("PlanInfo:{}",planInfo);
        SsoUser ssoUser = parse(authentication);
        //TODO: 设置任务修改者
        planInfo.setCreatePerson(ssoUser.getUsername());
        Boolean rsp = planInfoService.updatePlan(planInfo);
        if(!rsp){
            return R.error(-99998,"计划任务修改失败").put("result","fail");
        }
        return R.ok("修改计划任务成功");
    }


    /**
     * 修改计划状态 1:默认待发布 2:已发布 3:撤回发布 4:已启用 5：已停用 6:已结束
     * @author 悟空
     * @description //TODO
     * @date 9:13 2021/5/21
     * @param
     * @return com.nanhai.core.util.R
     */
    @PostMapping(value = "/updateStatus")
    public R pubPlan(PlanInfo planInfo, Authentication authentication){
        Integer status = planInfo.getPlanStatus();
        Long id = planInfo.getId();
        SsoUser ssoUser = parse(authentication);


        if(status == null ){
            return R.error(-99997,"缺少参数：status").put("result","fail");
        }
        if(id == null){
            return R.error(-99996,"缺少参数：id").put("result","fail");
        }

        if(status == 3){
            status = 1;
        }

        boolean rsp = planInfoService.setStatus(id,status,ssoUser.getUsername());
        if(!rsp){
            return R.error(-99995,"不存在的id").put("result","fail");
        }

        return R.ok().put("data",status);
    }









}
