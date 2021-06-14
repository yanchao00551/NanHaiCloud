package com.nanhai.core.persistence.beans;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nanhai.core.business.entity.CollectTask;
import com.nanhai.core.business.entity.CollectTaskLandRs;
import com.nanhai.core.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @PackageName:com.nanhai.core.persistence.beans
 * @ClassName:NhPlanInfo
 * @Description:
 * @author: 悟空
 * @date: 2021/5/13 17:26
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NhPlanInfo extends AbstractDO {

    @Transient
    private List<NhCollectTask>  collectTasks;

    @Transient
    private JSONArray  collectTaskLandRs;
    @Transient
    private JSONObject treeData;

    @Transient
    private JSONArray ossImgList;

    @Transient
    private List<String> villageCode;

    /**
     * 采集要求
     * @author 悟空
     * @description //TODO
     * @date 16:56 2021/5/13
     * @param null
     * @return null
     */
    private String planRequire;


    /**
     * 计划编号
     * @author 悟空
     * @description //TODO
     * @date 16:56 2021/5/13
     * @param null
     * @return null
     */
    private String planCode;


    /**
     * 计划开始时间
     * @author 悟空
     * @description //TODO
     * @date 16:57 2021/5/13
     * @param null
     * @return null
     */
    private Date planStartTime;


    /**
     * 结束时间
     * @author 悟空
     * @description //TODO
     * @date 16:57 2021/5/13
     * @param null
     * @return null
     */
    private Date planEndTime;


    /**
     * 计划名称
     * @author 悟空
     * @description //TODO
     * @date 16:57 2021/5/13
     * @param null
     * @return null
     */
    private String planName;


    /**
     * 计划状态 1:默认待发布 2:已发布 3:撤回发布 4:已启用 5：已停用
     * @author 悟空
     * @description //TODO
     * @date 16:58 2021/5/13
     * @param null
     * @return null
     */
    private Integer planStatus;


    /**
     * 创建人的真实姓名
     * @author 悟空
     * @description //TODO
     * @date 16:59 2021/5/13
     * @param null
     * @return null
     */
    private String createPerson;

    /**
     * 更新人的真实姓名
     * @author 悟空
     * @description //TODO
     * @date 17:00 2021/5/13
     * @param null
     * @return null
     */
    private String updatePerson;


    /**
     * oss附件地址 格式:1,2,3
     * @author 悟空
     * @description //TODO
     * @date 17:01 2021/5/13
     * @param null
     * @return null
     */
    private String planFiles;

}
