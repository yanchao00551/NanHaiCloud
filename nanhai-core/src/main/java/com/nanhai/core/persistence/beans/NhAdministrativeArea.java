package com.nanhai.core.persistence.beans;

import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @PackageName:com.nanhai.core.persistence.beans
 * @ClassName:NhAdministrativeArea
 * @Description:
 * @author: 悟空
 * @date: 2021/5/13 17:25
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "nh_administrative_area")
public class NhAdministrativeArea extends AbstractDO {
    /**
     * tree组件是否被选中 tree或false
     * @author 悟空
     * @description //TODO
     * @date 22:25 2021/5/15
     * @param null
     * @return null
     */
    @Transient
    private String selected;

    /**
     * 行政区划编号
     * @author 悟空
     * @description //TODO
     * @date 16:38 2021/5/13
     * @param null
     * @return null
     */
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

}
