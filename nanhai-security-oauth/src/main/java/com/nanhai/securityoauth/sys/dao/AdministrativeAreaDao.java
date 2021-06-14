package com.nanhai.securityoauth.sys.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.nanhai.securityoauth.sys.entity.NhAdministrativeArea;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdministrativeAreaDao extends BaseMapper<NhAdministrativeArea> {
}
