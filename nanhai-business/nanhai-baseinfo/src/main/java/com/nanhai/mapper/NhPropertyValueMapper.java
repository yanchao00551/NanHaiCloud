package com.nanhai.mapper;

import com.nanhai.core.business.vo.PropertyValueConditionVO;
import com.nanhai.core.persistence.beans.NhPropertyValue;
import com.nanhai.core.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 杨默
 * @date 2021/5/16 16:54
 * @Description
 */
@Repository
public interface NhPropertyValueMapper extends BaseMapper<NhPropertyValue> {


    /**
     * 根据属性类别id查询属性值
     * @param
     * @return
     */
    List<NhPropertyValue> selectPage(NhPropertyValue nhPropertyValue);

}
