package com.nanhai.service.impl;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.AdministrativeArea;
import com.nanhai.core.business.exception.ApiException;
import com.nanhai.core.business.vo.AdministrativeAreaConditionVO;
import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.core.framework.object.MyRestTemplate;
import com.nanhai.core.framework.object.RestResponse;
import com.nanhai.core.persistence.beans.NhAdministrativeArea;
import com.nanhai.core.persistence.beans.NhCollectTask;
import com.nanhai.core.util.EmptyUtils;
import com.nanhai.mapper.NhAdministrativeAreaMapper;
import com.nanhai.service.NhAdminstrativeAreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @PackageName:com.nanhai.service.impl
 * @ClassName:NhAdminstrativeAreaServiceImpl
 * @Description:
 * @author: 悟空
 * @date: 2021/5/14 21:46
 * @email: 10947@163.com
 */
@Service
@Slf4j
public class NhAdminstrativeAreaServiceImpl implements NhAdminstrativeAreaService {

    @Autowired
    private NhAdministrativeAreaMapper administrativeAreaMapper;

    //将访问地址改为网关服务名称
    private static final String GATEWAY_SERVICE = "http://nanhai-zuul-gateway:8280/";


    @Autowired
    private MyRestTemplate myRestTemplate;


    @Override
    public PageInfo<AdministrativeArea> findPageBreakByCondition(AdministrativeAreaConditionVO vo) {
        return null;
    }

    @Override
    public List<AdministrativeArea> listWithTree(List<AdministrativeArea> lists,int level) {
        // 查找所有菜单数据 lists
        // 把数据组合成树形结构
        List<AdministrativeArea> result = lists.stream()
                // 查找第一级菜单
                .filter(meun -> meun.getAdministrativeLevel() == level)
                // 查找子菜单并放到第一级菜单中
                .map(menu -> {
                    menu.setChildren(getChildren(menu, lists));
                    return menu;
                })
                // 把处理结果收集成一个 List 集合
                .collect(Collectors.toList());
        return result;
    }

    /**
     * 递归获取子菜单
     *
     * @param root 当前菜单
     * @param all  总的数据
     * @return 子菜单
     */
    public List<AdministrativeArea> getChildren(AdministrativeArea root, List<AdministrativeArea> all) {
        List<AdministrativeArea> children = all.stream()
                // 根据 父菜单 ID 查找当前菜单 ID，以便于找到 当前菜单的子菜单
                .filter(menu -> menu.getAdministrativeHigh().equals(root.getAdministrativeCode()))
                // 递归查找子菜单的子菜单
                .map((menu) -> {
                    menu.setChildren(getChildren(menu, all));
                    return menu;
                })

                // 把处理结果收集成一个 List 集合
                .collect(Collectors.toList());
        return children;
    }


    @Override
    public Map<String, Object> findList(AdministrativeAreaConditionVO vo) {
        List<NhAdministrativeArea> entityList = administrativeAreaMapper.selectAll();
        if (CollectionUtils.isEmpty(entityList)) {
            return null;
        }

        //TODO:如果传来计划id，则将这个计划的所有区域标注以选中状态
        List<NhCollectTask> collectTaskList = null;
        if (vo.getPlanId() != null) {
            //TODO: 计划列表（含分页、单个计划的所有任务列表)
            String str = myRestTemplate.getForObject(GATEWAY_SERVICE + "/task/task/queryTasksAccordingToPlan?planInfoId=" + vo.getPlanId(), String.class);
            //TODO: 返回
            RestResponse<NhCollectTask> analysis = new RestResponse<NhCollectTask>();
            //collectTaskList = analysis.getList(str, NhCollectTask.class);

            //vo.setCollectTaskList(collectTaskList);
            log.info("获取该计划的任务列表：{}", collectTaskList);
        }

        List<AdministrativeArea> list = new LinkedList<>();
        List<AdministrativeArea> listTree = new LinkedList<>();

        for (NhAdministrativeArea entity : entityList) {
            //如果任务列表不为空，添加选中
            List<NhCollectTask> collectList = vo.getCollectTaskList();
            if (EmptyUtils.isNotEmpty(collectList)) {
                collectList.stream().forEach(item -> {
                    String temp = entity.getAdministrativeCode();
                    ;
                    if (item.getCollectTaskTownId().equals(temp) || item.getCollectTaskVillageId().equals(temp)) {
                        entity.setSelected("true");
                    }
                });
            }
            list.add(new AdministrativeArea(entity));
            listTree.add(new AdministrativeArea(entity));
        }

        List<AdministrativeArea> treeList = listWithTree(listTree,2);

        Map<String, Object> rst = new HashMap<>();


        rst.put("list", list);
        rst.put("treeList", treeList);
        return rst;
    }

    @Override
    public AdministrativeArea findByCode(String administrativeHigh) {
        Example example = new Example(NhAdministrativeArea.class);
        example.createCriteria().andEqualTo("administrativeCode", administrativeHigh);
        NhAdministrativeArea nhAdministrativeArea = administrativeAreaMapper.selectOneByExample(example);
        return new AdministrativeArea(nhAdministrativeArea);
    }

    @Override
    public void add(AdministrativeArea administrativeArea) {
        isCodeExit(administrativeArea, 1);


        isParentExit(administrativeArea);
        administrativeArea.getNhAdministrativeArea().setCreateTime(new Date());
        administrativeAreaMapper.insert(administrativeArea.getNhAdministrativeArea());
    }


    @Override
    public void put(AdministrativeArea administrativeArea) {
        isExit(administrativeArea.getId());
        //isCodeExit(administrativeArea, 2);
        //isParentExit(administrativeArea);
        administrativeArea.getNhAdministrativeArea().setUpdateTime(new Date());
        administrativeAreaMapper.updateByPrimaryKeySelective(administrativeArea.getNhAdministrativeArea());

    }

    @Override
    public void delete(Long id) {
        isExit(id);
        administrativeAreaMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Map<String, Object> findListSelect(AdministrativeAreaConditionVO vo) {
        Map<String, Object> rst = new HashMap<>();

        //TODO:如果传来计划id，则将这个计划的所有区域标注以选中状态
        List<NhCollectTask> collectTaskList = null;

        if (vo.getPlanId() != null) {
            //TODO: 计划列表（含分页、单个计划的所有任务列表)
            String str = myRestTemplate.getForObject(GATEWAY_SERVICE + "/task/task/queryTasksAccordingToPlan?planInfoId=" + vo.getPlanId(), String.class);
            //TODO: 返回
            RestResponse<NhCollectTask> analysis = new RestResponse<NhCollectTask>();
            collectTaskList = analysis.getList(str, NhCollectTask.class);

            vo.setCollectTaskList(collectTaskList);
            log.info("获取该计划的任务列表：{}", collectTaskList);

            List<String> townIds = collectTaskList.stream().map(NhCollectTask::getCollectTaskTownId).collect(Collectors.toList());
            List<String> villageIds = collectTaskList.stream().map(NhCollectTask::getCollectTaskVillageId).collect(Collectors.toList());

            List<NhAdministrativeArea> entityList = administrativeAreaMapper.selectAllSelect(townIds,villageIds);
            log.info("areaList:{}",entityList);
            List<AdministrativeArea> list = new LinkedList<>();

            List<AdministrativeArea> listTree = new LinkedList<>();

            for (NhAdministrativeArea entity : entityList) {
                //如果任务列表不为空，添加选中
                list.add(new AdministrativeArea(entity));
                listTree.add(new AdministrativeArea(entity));
            }
            List<AdministrativeArea> treeList = listWithTree(listTree,4);
            rst.put("list", list);
            rst.put("treeList", treeList);
        }

        return rst;
    }

    //type 1增加 2修改
    private void isCodeExit(AdministrativeArea administrativeArea, int type) {

        Example example = new Example(NhAdministrativeArea.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("administrativeCode", administrativeArea.getAdministrativeCode());
        if (type == 2) {
            criteria.andNotEqualTo("id", administrativeArea.getId());
        }
        int result = administrativeAreaMapper.selectCountByExample(example);
        if (result > 0) {
            throw new ApiException("该行政编码已经存在");
        }

    }


    private void isExit(Long id) {
        NhAdministrativeArea administrativeArea = administrativeAreaMapper.selectByPrimaryKey(id);
        if (null == administrativeArea) {
            throw new ApiException("找不到该条记录");
        }
    }


    private void isParentExit(AdministrativeArea administrativeArea){
        String parentCode = administrativeArea.getAdministrativeHigh();
        if (parentCode != null && !"".equals(parentCode)) {
            if(parentCode.equals(administrativeArea.getAdministrativeCode())){
                throw new ApiException("父级行政编码不能为自己");
            }
            Example example = new Example(NhAdministrativeArea.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("administrativeCode", administrativeArea.getAdministrativeHigh());
            int result = administrativeAreaMapper.selectCountByExample(example);
            if (result <= 0) {
                throw new ApiException("父级行政编码不存在");
            }
        }
    }
    @Override
    public AdministrativeArea insert(AdministrativeArea entity) {
        return null;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(AdministrativeArea entity) {
        return false;
    }


    @Override
    public AdministrativeArea getByPrimaryKey(Long primaryKey) {
        return null;
    }
    @Override
    public List<NhAdministrativeArea> getByPid(Long pid){
        if(pid!=null){
            Example example = new Example(NhAdministrativeArea.class);
            example.createCriteria().andEqualTo("administrativeHigh", pid);
            return administrativeAreaMapper.selectByExample(example);
        }else{
            return null;
        }
    }
}
