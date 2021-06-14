package com.nanhai.core.persistence.beans;

import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图片资源
 * @author luobo
 * @create 2021/5/14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhPicture extends AbstractDO {

    /**
     * 图片地址
     */
    private String imgUrl;

}
