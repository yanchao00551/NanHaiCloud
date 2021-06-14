package com.nanhai.modules.data.controller;

import com.nanhai.core.business.entity.LandInfo;
import com.nanhai.core.framework.object.AbstractController;
import com.nanhai.core.framework.object.SsoUser;
import com.nanhai.core.persistence.beans.NhLandSubject;
import com.nanhai.core.persistence.beans.NhPlanInfo;
import com.nanhai.core.util.R;
import com.nanhai.modules.data.service.NhCollectTaskLandService;
import com.nanhai.modules.data.service.NhLandInfoService;
import com.nanhai.modules.data.service.NhLandSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 杨默
 * @date 2021/4/29 9:18
 */
@RestController
@RequestMapping("/LandSubject")
public class NhAuditSubjectController  extends AbstractController {
    @Autowired
    private NhLandInfoService nhLandInfoService;

    @Autowired
    private NhLandSubjectService nhLandSubjectService;

    @Autowired
    private NhCollectTaskLandService nhCollectTaskLandService;


    /**
     * 审核接口
     * @author 悟空
     * @description //TODO
     * @date 19:16 2021/5/29
     * @param landIds  批量审核id
     * @param auditMemo 审核说明
     * @param authentication
     * @return com.nanhai.core.util.R
     */
    @PostMapping(value = "/auditLand")
    public R auditLand(Long[] landIds, String auditMemo,Integer auditStatus,Authentication authentication){
        SsoUser ssoUser = parse(authentication);
        String person = ssoUser.getUsername();
        nhCollectTaskLandService.updateAudit(landIds,person,auditMemo,auditStatus);
        return R.ok();
    }






    @PostMapping(value = "/audit")
    public String auditSubject(LandInfo landInfo, Integer auditStatus, String auditName, String auditMemo, Authentication authentication) {

         SsoUser ssoUser = parse(authentication);
         landInfo.setAuditPerson(ssoUser.getUsername());
         landInfo.setAuditDate(new Date());
         nhLandInfoService.auditLandInfo(landInfo);

        List<NhLandSubject> list = nhLandSubjectService.selectLandSubjectByLandCode(landInfo.getLandCode());

        for (NhLandSubject landSubject : list) {
            landSubject.setAuditStatus(auditStatus);
            int index = nhLandSubjectService.updateLandSubjectByLandCode(landSubject);
        }

        Date date = new Date();
        if (auditStatus == 1) {
            landInfo.setAuditStatus(auditStatus);
            landInfo.setAuditPerson(auditName);
            landInfo.setAuditDate(date);
            landInfo.setAuditMemo(auditMemo);
            return "审核通过";
        }
        landInfo.setAuditStatus(auditStatus);
        landInfo.setAuditPerson(auditName);
        landInfo.setAuditDate(date);
        landInfo.setAuditMemo(auditMemo);
        return "审核不通过";
    }



}