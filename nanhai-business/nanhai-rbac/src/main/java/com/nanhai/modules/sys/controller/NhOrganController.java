package com.nanhai.modules.sys.controller;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.Organ;
import com.nanhai.core.business.vo.OrganConditionVO;

import com.nanhai.core.persistence.beans.NhOrgan;
import com.nanhai.core.util.R;
import com.nanhai.modules.sys.service.NhOrganService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 组织机构维护
 *
 * @author luobo
 * @create 2021/5/20
 */
/*
@Slf4j
*/
@RestController
@RequestMapping("/sys/organ")
public class NhOrganController {
    private final NhOrganService organService;
    @Autowired
    public NhOrganController(NhOrganService organService) {
        this.organService = organService;
    }


    @PostMapping("/add")
    public R add(Organ organ) {
        organService.add(organ);
        return  R.ok();
    }
    @PostMapping("/delete")
    public R deleteOrganById( Long id) {
        organService.deleteOrganById(id);
        return  R.ok();
    }

    @PostMapping ("/put")
    public R putOrganById(Organ organ) {

        organService.putOrganById(organ);
        return  R.ok();
    }



    // 绑定变量名字和属性，参数封装进类
    @InitBinder("organ")
    public void initBinderAddr(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("organ.");
    }
    @GetMapping ("/get")
    public R getRoleList(OrganConditionVO vo) {
        PageInfo<NhOrgan> byCondition = organService.findByCondition(vo);
        return R.ok().put("data" , byCondition);
    }


}
