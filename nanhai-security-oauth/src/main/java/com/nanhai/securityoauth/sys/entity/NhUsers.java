package com.nanhai.securityoauth.sys.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


@TableName("nh_users")
@Data
@ToString
public class NhUsers {

    @TableId
    private Long id;

    private Long userId;

    private Integer userLevel;

    private String userLoginName;

    private String userName;

    private String userAdministrativeCode;

    private String registerCard;

    private String registerCode;

    private String registerTele;

    private Integer registerAuditStatus;

    private Date createTime;

    private Date updateTime;

    private Long organId;

    private String registerMemo;

    private String userHead;

    @TableField(exist=false)
    private Integer pageNumber;
    @TableField(exist=false)
    private Integer pageSize;
    @TableField(exist=false)
    private String administrativeName;
}