package com.nanhai.core.persistence.beans;

import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * NhCollectUser
 *
 * @author Damon
 * @date 2021/5/15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "nh_collect_user")
public class NhCollectUser extends AbstractDO {
    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 身份证号
     */
    @Column(name = "user_card")
    private String userCard;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 电话号码
     */
    @Column(name = "user_tele")
    private String userTele;

    /**
     * 所属行政区划编号0
     */
    @Column(name = "user_administrative_id")
    private Long userAdministrativeId;

    /**
     * 所属镇编号
     */
    @Column(name = "user_town")
    private Long userTown;

    /**
     * 所属村编号
     */
    @Column(name = "user_village")
    private Long userVillage;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;



}