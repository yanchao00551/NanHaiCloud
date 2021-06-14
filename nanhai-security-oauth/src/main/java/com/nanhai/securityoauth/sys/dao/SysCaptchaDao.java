
package com.nanhai.securityoauth.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.nanhai.securityoauth.sys.entity.SysCaptchaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 验证码
 * @author 悟空
 * @description //TODO
 * @date 15:33 2021/5/27
 * @param null
 * @return null
 */
@Mapper
@Repository
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {

}
