package com.nanhai.securityoauth.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.nanhai.securityoauth.sys.entity.NhUsers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDao extends BaseMapper<NhUsers> {

}
