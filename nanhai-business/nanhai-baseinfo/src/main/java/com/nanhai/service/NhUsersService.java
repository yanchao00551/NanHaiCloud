package com.nanhai.service;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.framework.object.AbstractService;
import com.nanhai.core.persistence.beans.NhUsers;

/**
 * NhUsersService
 *
 * @author Damon
 * @date 2021/5/15
 */
public interface NhUsersService extends AbstractService<NhUsers,Long> {

    /**
     * 一般查询
     * @param user
     * @return
     */
    public PageInfo<NhUsers> selectByPage(NhUsers user);
    /**
     * 支持条件查询
     * @param user
     * @return
     */
    public PageInfo<NhUsers> selectPage(NhUsers user);
}
