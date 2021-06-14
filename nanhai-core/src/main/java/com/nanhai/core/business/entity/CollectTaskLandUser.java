package com.nanhai.core.business.entity;

import lombok.Data;

/**
 * @PackageName:com.nanhai.core.business.entity
 * @ClassName:CollectTaskLandUser
 * @Description:
 * @author: 悟空
 * @date: 2021/6/7 12:04
 * @email: 10947@163.com
 */
@Data
public class CollectTaskLandUser {
    private String userName;
    private String villageName;
    private String townName;
    private Long collectNum;
    private Long collectFailNum;
    private String realName;
}
