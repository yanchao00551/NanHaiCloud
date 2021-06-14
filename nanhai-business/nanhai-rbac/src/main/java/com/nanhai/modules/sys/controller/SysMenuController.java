package com.nanhai.modules.sys.controller;

import com.nanhai.core.business.entity.SysMenu;
import com.nanhai.core.framework.object.AbstractController;
import com.nanhai.core.util.R;
import com.nanhai.modules.sys.service.NhSysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @PackageName:com.nanhai.modules.sys.controller
 * @ClassName:SysMenuController
 * @Description:
 * @author: 悟空
 * @date: 2021/5/23 9:15
 * @email: 10947@163.com
 */
@Slf4j
@RestController
@RequestMapping(value = "/menu")
public class SysMenuController extends AbstractController {

    @Autowired
    private NhSysMenuService sysMenuService;

    /**
     * 所有菜单列表
     */
    @GetMapping("/list")
    public R list(){
        List<SysMenu> menuList = sysMenuService.selectList(null);
        return R.ok().put("data",menuList);
    }






}
