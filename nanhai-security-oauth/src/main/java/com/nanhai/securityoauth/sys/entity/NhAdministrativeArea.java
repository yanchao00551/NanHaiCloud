package com.nanhai.securityoauth.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.ToString;

import java.sql.Date;


@TableName("nh_administrative_area")
@Data
@ToString
public class NhAdministrativeArea {
    @TableId
    private Long id;

    private String administrativeCode;


    /**
     * 行政区划名称
     * @author 悟空
     * @description //TODO
     * @date 16:38 2021/5/13
     * @param null
     * @return null
     */
    private String administrativeName;

    /**
     * 父类行政区划编码
     * @author 悟空
     * @description //TODO
     * @date 16:38 2021/5/13
     * @param null
     * @return null
     */
    private String administrativeHigh;

    /**
     * 层级深度
     * @author 悟空
     * @description //TODO
     * @date 16:40 2021/5/13
     * @param null
     * @return null
     */
    private Integer administrativeLevel;


    private String administrativeLat;
    private String administrativeLon;
    private String administrativePcode;

    private Date createTime;
    private Date updateTime;
}
