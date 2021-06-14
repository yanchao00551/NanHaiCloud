package com.nanhai.api;


import com.nanhai.core.business.entity.AdministrativeArea;
import com.nanhai.core.business.vo.AdministrativeAreaConditionVO;
import com.nanhai.core.framework.object.AbstractController;
import com.nanhai.core.framework.object.MyRestTemplate;
import com.nanhai.core.framework.object.RestResponse;
import com.nanhai.core.persistence.beans.NhAdministrativeArea;
import com.nanhai.core.persistence.beans.NhCollectTask;
import com.nanhai.core.util.R;
import com.nanhai.service.NhAdminstrativeAreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @PackageName:com.nanhai.api
 * @ClassName:ApiController
 * @Description:
 * @author: 悟空
 * @date: 2021/5/14 19:19
 * @email: 10947@163.com
 */
@RestController
@RequestMapping(value = {"/v1.0"})
@Slf4j
public class ApiController extends AbstractController {


    @Autowired
    private NhAdminstrativeAreaService adminstrativeAreaService;

    @GetMapping(value = {"/getSelectAreaData"})
    public R getSelectAreaData(AdministrativeAreaConditionVO vo){
        Map<String, Object> map = adminstrativeAreaService.findListSelect(vo);
        Set<Map.Entry<String, Object>> set = map.entrySet();
        Iterator<Map.Entry<String, Object>> itr = set.iterator();
        List<AdministrativeArea> listArea = new LinkedList<>();
        List<AdministrativeArea> listTree = new LinkedList<>();

        Object list = null;
        Object treeList = null;

        while (itr.hasNext()) {
            Map.Entry<String, Object> entry = itr.next();
            if (entry.getKey().equals("list")) {
                list = entry.getValue();
            }
            if (entry.getKey().equals("treeList")) {
                treeList = entry.getValue();
            }
        }

        if (list instanceof List<?> && treeList instanceof List<?>) {
            for (Object o : (List<?>) list) {
                listArea.add(AdministrativeArea.class.cast(o));
            }
            for (Object o1 : (List<?>) treeList) {
                listTree.add(AdministrativeArea.class.cast(o1));
            }
        }
        for (AdministrativeArea administrativeArea : listArea) {
            AdministrativeArea parentEntity = adminstrativeAreaService.findByCode(administrativeArea.getAdministrativeHigh());
            if (parentEntity.getNhAdministrativeArea() != null) {
                administrativeArea.setParentName(parentEntity.getAdministrativeName());
            }
        }
        Map<String, Object> rst = new HashMap<>();
        rst.put("treeItem", listTree);
        rst.put("list", listArea);
        return R.ok().put("data", rst);
    }

    /**
     * 所有区划列表- element-ui Tree组件返回格式
     *
     * @param vo
     * @return com.nanhai.core.util.R
     * @author 悟空
     * @description //TODO
     * @date 9:22 2021/5/15
     */
    @GetMapping(value = {"/getTreeData"})
    public R getTreeData(AdministrativeAreaConditionVO vo) {
        Map<String, Object> map = adminstrativeAreaService.findList(vo);
        Set<Map.Entry<String, Object>> set = map.entrySet();
        Iterator<Map.Entry<String, Object>> itr = set.iterator();
        List<AdministrativeArea> listArea = new LinkedList<>();
        List<AdministrativeArea> listTree = new LinkedList<>();

        Object list = null;
        Object treeList = null;

        while (itr.hasNext()) {
            Map.Entry<String, Object> entry = itr.next();
            if (entry.getKey().equals("list")) {
                list = entry.getValue();
            }
            if (entry.getKey().equals("treeList")) {
                treeList = entry.getValue();
            }
        }

        if (list instanceof List<?> && treeList instanceof List<?>) {
            for (Object o : (List<?>) list) {
                listArea.add(AdministrativeArea.class.cast(o));
            }
            for (Object o1 : (List<?>) treeList) {
                listTree.add(AdministrativeArea.class.cast(o1));
            }
        }
        for (AdministrativeArea administrativeArea : listArea) {
            AdministrativeArea parentEntity = adminstrativeAreaService.findByCode(administrativeArea.getAdministrativeHigh());
            if (parentEntity.getNhAdministrativeArea() != null) {
                administrativeArea.setParentName(parentEntity.getAdministrativeName());
            }
        }
        Map<String, Object> rst = new HashMap<>();
        rst.put("treeItem", listTree);
        rst.put("list", listArea);
        return R.ok().put("data", rst);
    }


    @PostMapping("/adminstrative/add")
    public R administrativeAdd(AdministrativeArea administrativeArea) {
        System.out.println("administrativeArea"+administrativeArea);
        adminstrativeAreaService.add(administrativeArea);
        return R.ok();
    }

    @PostMapping("/adminstrative/delete")
    public R administrativeDelete(Long id) {
        adminstrativeAreaService.delete(id);
        return R.ok();
    }
    @PostMapping("/adminstrative/put")
    public R administrativePut(AdministrativeArea administrativeArea) {
        adminstrativeAreaService.put(administrativeArea);
        return R.ok();
    }

    @GetMapping("/adminstrative/getByPid")
    public R getByPid(Long pid){
        List<NhAdministrativeArea> list=adminstrativeAreaService.getByPid(pid);
        return R.ok().put("data", list);
    }
}
