package com.nanhai.mapper;

import com.nanhai.core.persistence.beans.NhLandType;
import com.nanhai.core.persistence.beans.NhPropertyValue;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface NhLandTypeMapper extends Mapper<NhLandType> {
}
