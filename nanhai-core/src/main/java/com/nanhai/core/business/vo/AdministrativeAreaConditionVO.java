package com.nanhai.core.business.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nanhai.core.business.entity.AdministrativeArea;
import com.nanhai.core.framework.object.BaseConditionVO;
import com.nanhai.core.persistence.beans.NhAdministrativeArea;
import com.nanhai.core.persistence.beans.NhCollectTask;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @PackageName:com.nanhai.core.business.vo
 * @ClassName:AdministrativeAreaConditionVO
 * @Description:
 * @author: 悟空
 * @date: 2021/5/13 20:22
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdministrativeAreaConditionVO extends BaseConditionVO{
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private List<NhCollectTask> collectTaskList;

    @Getter
    @Setter
    private Integer planId;

    @JsonIgnore
    private AdministrativeArea administrativeArea;

    private NhAdministrativeArea nhAdministrativeArea;

    private List<AdministrativeAreaConditionVO> administrativeAreaConditionVoList;


}
