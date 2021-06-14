package com.nanhai.file.mapper;

import com.nanhai.core.persistence.beans.NhPicture;
import com.nanhai.core.plugin.BaseMapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luobo
 * @create 2021/5/14
 */
@Resource
public interface NhPictureMapper  extends BaseMapper<NhPicture> {
    Long insertPicture(NhPicture nhPicture);
}
