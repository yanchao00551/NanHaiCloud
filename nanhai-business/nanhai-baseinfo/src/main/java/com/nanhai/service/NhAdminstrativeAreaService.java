package com.nanhai.service;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.AdministrativeArea;
import com.nanhai.core.business.vo.AdministrativeAreaConditionVO;
import com.nanhai.core.framework.object.AbstractService;
import com.nanhai.core.persistence.beans.NhAdministrativeArea;
import com.nanhai.core.persistence.beans.NhCollectTask;

import java.util.List;
import java.util.Map;

public interface NhAdminstrativeAreaService  extends AbstractService<AdministrativeArea,Long> {
    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<AdministrativeArea> findPageBreakByCondition(AdministrativeAreaConditionVO vo);


    /**
     * 查询数据库数据，并处理后返回 树形数据
     * @return 树形数据
     */
    List<AdministrativeArea> listWithTree(List<AdministrativeArea> lists,int level);

    /**
     * 获取所有 element-ui通用返回，tree数据
     * @author 悟空
     * @description //TODO 
     * @date 9:27 2021/5/15
     * @param vo
     * @return java.util.List<com.nanhai.core.persistence.beans.NhAdministrativeArea>
     */
    Map<String,Object> findList(AdministrativeAreaConditionVO vo);

    /**
     * 根据查询单个父节点
     * @author 悟空
     * @description //TODO
     * @date 13:07 2021/5/15
     * @param administrativeHigh
     * @return com.nanhai.core.business.entity.AdministrativeArea
     */
    AdministrativeArea findByCode(String administrativeHigh);

    void add(AdministrativeArea administrativeArea);

    void put(AdministrativeArea administrativeArea);

    void delete(Long id);

    Map<String, Object> findListSelect(AdministrativeAreaConditionVO vo);

    List<NhAdministrativeArea> getByPid(Long pid);
}
