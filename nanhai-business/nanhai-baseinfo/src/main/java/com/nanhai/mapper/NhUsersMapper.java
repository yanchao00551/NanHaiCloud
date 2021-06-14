package com.nanhai.mapper;

import com.nanhai.core.persistence.beans.NhUsers;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NhUsersMapper extends Mapper<NhUsers> {

    /**
     * 支持条件查询
     * @param user
     * @return
     */
    public List<NhUsers> selectPage(NhUsers user);

}