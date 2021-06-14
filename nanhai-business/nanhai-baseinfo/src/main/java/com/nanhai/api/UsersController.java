package com.nanhai.api;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.framework.object.AbstractController;
import com.nanhai.core.framework.object.SsoUser;
import com.nanhai.core.persistence.beans.NhUsers;
import com.nanhai.core.util.R;
import com.nanhai.service.NhUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UsersController
 *
 * @author Damon
 * @date 2021/5/15
 */
@RestController
@RequestMapping(value = {"/api/v1.0/fishing/user"})
@Slf4j
public class UsersController extends AbstractController {

    @Autowired
    private NhUsersService nhUsersService;


    @GetMapping("/selecByPage")
    public R selectByPage(NhUsers user, Authentication authentication){
        PageInfo<NhUsers> pageInfo = nhUsersService.selectPage(user);
        SsoUser ssoUser = parse(authentication);
        System.out.println("*****"+ssoUser);
        return R.ok().put("data",pageInfo);
    }


    @GetMapping("/list")
    public R list(){
        List<NhUsers> collectUsers = nhUsersService.listAll();
        return R.ok().put("data",collectUsers);
    }

    @PostMapping("/add")
    public R add(NhUsers user){
        //新增
        user=nhUsersService.insert(user);
        return R.ok().put("data",user);
    }

    @PostMapping("/edit")
    public R edit(NhUsers user){
        //修改
        boolean res = nhUsersService.updateSelective(user);
        return R.ok().put("data",res);
    }




    @GetMapping("/getById/{id}")
    public R getById(@PathVariable("id") Long id){
        NhUsers user = nhUsersService.getByPrimaryKey(id);
        return R.ok().put("data",user);
    }

    @GetMapping("/delete/{id}")
    public R delete(@PathVariable("id") Long id){
        boolean res = nhUsersService.removeByPrimaryKey(id);
        return R.ok().put("data",res);
    }


}
