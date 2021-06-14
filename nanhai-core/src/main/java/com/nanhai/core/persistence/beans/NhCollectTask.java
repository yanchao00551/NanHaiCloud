package com.nanhai.core.persistence.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;
import java.util.List;
import java.util.Date;


/**
 * @PackageName:com.nanhai.core.persistence.beans
 * @ClassName:NhCollectTask
 * @Description:
 * @author: 悟空
 * @date: 2021/5/13 17:26
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhCollectTask extends AbstractDO {
    @Transient
    private List<NhPlanInfo> planInfos;
    @Transient
    private String planName;
    @Transient
    private String administrativeName;

    @Transient
    private String collectTaskVillageName;
    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planStartTime;
    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planEndTime;

    /**
     * 所属计划主键
     * @author 悟空
     * @description //TODO
     * @date 16:51 2021/5/13
     * @param null
     * @return null
     */
    private Long collectTaskPlanId;

    /**
     * 采集镇/街道的行政编码
     * @author 悟空
     * @description //TODO
     * @date 16:51 2021/5/13
     * @param null
     * @return null
     */
    private String collectTaskTownId;

    /**
     * 村行政编码
     * @author 悟空
     * @description //TODO
     * @date 16:52 2021/5/13
     * @param null
     * @return null
     */
    private String collectTaskVillageId;
}
