package com.nanhai.core.persistence.beans;


import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "nh_users")
public class NhUsers extends AbstractDO {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_level")
    private Integer userLevel;

    @Column(name = "user_login_name")
    private String userLoginName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_administrative_code")
    private String userAdministrativeCode;

    @Column(name = "register_card")
    private String registerCard;

    @Column(name = "register_code")
    private String registerCode;

    @Column(name = "register_tele")
    private String registerTele;

    /**
     * 审核状态
     */
    @Column(name = "register_audit_status")
    private Integer registerAuditStatus;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "organ_id")
    private Long organId;

    @Column(name = "user_head")
    private String userHead;


    @Transient
    private Integer pageNumber;
    @Transient
    private Integer pageSize;
    @Transient
    private String administrativeName;
    @Transient
    private String status;
}