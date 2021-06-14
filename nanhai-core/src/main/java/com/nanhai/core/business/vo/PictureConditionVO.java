package com.nanhai.core.business.vo;

import com.nanhai.core.business.entity.Picture;
import com.nanhai.core.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @PackageName:com.nanhai.core.business.vo
 * @ClassName:PictureConditionVO
 * @Description:
 * @author: 悟空
 * @date: 2021/5/16 18:38
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PictureConditionVO extends BaseConditionVO {
    private Picture picture;
    private List<Long> pictureIds;
}
