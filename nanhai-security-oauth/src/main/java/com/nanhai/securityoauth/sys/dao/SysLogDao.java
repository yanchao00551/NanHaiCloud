
package com.nanhai.securityoauth.sys.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.nanhai.securityoauth.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 系统日志
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-08 10:40:56
 */
@Mapper
@Repository
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}
