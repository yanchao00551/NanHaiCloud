package com.nanhai.api;


import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.vo.LandTypeConditionVO;
import com.nanhai.core.persistence.beans.NhLandType;
import com.nanhai.core.util.R;
import com.nanhai.service.NhLandTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/v1.0/fishing/landType"})
@Slf4j
public class LandTypeController {
    @Autowired
    private NhLandTypeService nhLandTypeService;

    @GetMapping("/list")
    public R list(){
        List<NhLandType> landTypes = nhLandTypeService.listAll();
        return R.ok().put("data",landTypes);
    }

    @PostMapping("/add")
    public R add(NhLandType landType){
        //新增
        landType=nhLandTypeService.insert(landType);
        return R.ok().put("data",landType);
    }

    @PostMapping("/edit")
    public R edit(NhLandType landType){
        //修改
        boolean res = nhLandTypeService.updateSelective(landType);
        return R.ok().put("data",res);
    }




    @GetMapping("/getById/{id}")
    public R getById(@PathVariable("id") Long id){
        NhLandType landType = nhLandTypeService.getByPrimaryKey(id);
        return R.ok().put("data",landType);
    }

    @GetMapping("/delete/{id}")
    public R delete(@PathVariable("id") Long id){
        boolean res = nhLandTypeService.removeByPrimaryKey(id);
        return R.ok().put("data",res);
    }


    @GetMapping("/selectAll")
    public R selectAll(LandTypeConditionVO vo){
        PageInfo<NhLandType> byCondition = nhLandTypeService.findByCondition(vo);
        return R.ok().put("data",byCondition);
    }


}
