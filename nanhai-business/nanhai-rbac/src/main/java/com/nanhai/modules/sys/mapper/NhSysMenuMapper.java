package com.nanhai.modules.sys.mapper;

import com.nanhai.core.persistence.beans.NhSysMenu;
import com.nanhai.core.plugin.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NhSysMenuMapper extends BaseMapper<NhSysMenu> {
}
