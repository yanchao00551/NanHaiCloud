package com.nanhai.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.persistence.beans.NhUsers;
import com.nanhai.mapper.NhUsersMapper;
import com.nanhai.service.NhUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * NhUsersServiceImpl
 *
 * @author Damon
 * @date 2021/5/15
 */
@Service("nhUsersService")
public class NhUsersServiceImpl implements NhUsersService {

    @Autowired(required = false)
    private NhUsersMapper usersMapper;


    @Override
    public PageInfo<NhUsers> selectPage(NhUsers user) {
        //条件查询+分页
        PageHelper.startPage(user.getPageNumber(), user.getPageSize());
        List<NhUsers> users = usersMapper.selectPage(user);
        PageInfo<NhUsers> pageInfo = new PageInfo<NhUsers>(users);
        return pageInfo;
    }

    @Override
    public PageInfo<NhUsers> selectByPage(NhUsers user) {
        //条件查询+分页
        Example ex = new Example(NhUsers.class);
        Example.Criteria criteria = ex.createCriteria();
        if(!"".equals(user.getUserName())){
            criteria.andLike("userName","%"+user.getUserName().trim()+"%");
        }
        if(!"".equals(user.getUserAdministrativeCode())){
            criteria.andEqualTo("userAdministrativeCode",user.getUserAdministrativeCode());
        }
        criteria.orEqualTo("userLevel",4);
        criteria.orEqualTo("userLevel",5);

        PageHelper.startPage(user.getPageNumber(), user.getPageSize());
        List<NhUsers> users = usersMapper.selectByExample(ex);
        PageInfo<NhUsers> pageInfo = new PageInfo<NhUsers>(users);
        return pageInfo;
    }


    @Override
    public List<NhUsers> listAll() {
        List<NhUsers> users=usersMapper.selectAll();
        return users;
    }

    @Override
    public NhUsers insert(NhUsers user) {
        int res = usersMapper.insertSelective(user);
        return user;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        int res = usersMapper.deleteByPrimaryKey(primaryKey);
        if(res==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateSelective(NhUsers user) {
        int res = usersMapper.updateByPrimaryKeySelective(user);
        if(res==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public NhUsers getByPrimaryKey(Long primaryKey) {
        NhUsers user = usersMapper.selectByPrimaryKey(primaryKey);
        return user;
    }



}
