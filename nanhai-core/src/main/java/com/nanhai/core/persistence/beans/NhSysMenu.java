package com.nanhai.core.persistence.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @PackageName:com.nanhai.core.persistence.beans
 * @ClassName:SysMenu
 * @Description:
 * @author: 悟空
 * @date: 2021/5/23 9:18
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "nh_sys_menu")
public class NhSysMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long menuId;

    /**
     * 父菜单ID，一级菜单为0
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 父菜单名称
     */
    @Transient
    @Column(name = "parent_name")
    private String parentName;

    /**
     * 菜单名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 菜单URL
     */
    @Column(name = "url")
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    @Column(name = "perms")
    private String perms;

    /**
     * 类型     0：目录   1：菜单   2：按钮
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 菜单图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 排序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * ztree属性
     */
    @Transient
    private Boolean open;


    @Transient
    private List<?> list;


}
