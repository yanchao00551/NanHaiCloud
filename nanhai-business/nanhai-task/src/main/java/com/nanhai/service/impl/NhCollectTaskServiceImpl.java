package com.nanhai.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.CollectTask;
import com.nanhai.core.business.exception.ApiException;
import com.nanhai.core.business.vo.CollectTaskConditionVO;
import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.core.framework.object.SsoUser;
import com.nanhai.core.persistence.beans.NhCollectTask;
import com.nanhai.mapper.NhCollectTaskMapper;
import com.nanhai.mapper.NhPlanInfoMapper;
import com.nanhai.service.NhCollectTaskService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Slf4j
@Service
public class NhCollectTaskServiceImpl implements NhCollectTaskService {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(NhCollectTaskServiceImpl.class);

    @Autowired
    private NhCollectTaskMapper collectTaskMapper;
    @Autowired
    private NhPlanInfoMapper nhPlanInfoMapper;

    @Override
    public PageInfo<CollectTask> findPageBreakByCondition(CollectTaskConditionVO vo) {
        return null;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
    @Override
    public PageInfo<CollectTask> findTasksAccordingToPlan(CollectTaskConditionVO vo) {
       PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());


        //TODO: 不同的级别查看的数据是不一样的
        List<NhCollectTask> list = collectTaskMapper.findPageBreakByCondition(vo);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<Long> ids = list.stream().map(NhCollectTask::getCollectTaskPlanId).collect(Collectors.toList());

        List<Long> listWithoutDuplicates = ids.stream().distinct().collect(Collectors.toList());

        List<NhCollectTask> listPlan = collectTaskMapper.listTaskPlanInfosByPlanId(listWithoutDuplicates);

        Map<Long, NhCollectTask> tagMap = listPlan.stream().collect(Collectors.toMap(NhCollectTask::getId, a -> a, (k1, k2) -> k1));

        List<NhCollectTask> boList = new LinkedList<>();
        for (NhCollectTask bizTask : list) {
            NhCollectTask collectTask = tagMap.get(bizTask.getId());
            if (null == collectTask) {
                log.warn("任务[{}] 未绑定计划信息，或者已绑定的计划不存在！", bizTask.getId());
            } else {
                bizTask.setPlanInfos(collectTask.getPlanInfos());
            }
            boList.add(bizTask);
        }
        PageInfo bean = new PageInfo<NhCollectTask>(boList);
        boList=pagination(boList,vo.getPageNumber(), vo.getPageSize());
        bean.setList(boList);
        return bean;
    }


    /**
     * 镇村 访问数据数据
     */










    private static <T> List<T> pagination(List<T> records, int pageNum, int pageSize) {
        if (CollectionUtils.isEmpty(records)) {
            return Collections.emptyList();
        }
        int totalCount = records.size();
        int remainder = totalCount % pageSize;
        int pageCount = (remainder > 0) ? totalCount/pageSize + 1 : totalCount/pageSize;
        if (remainder == 0) {
            return records.stream().skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        } else {
            if (pageNum == pageCount) {
                return records.stream().skip((pageNum - 1) * pageSize).limit(totalCount).collect(Collectors.toList());
            } else {
                return records.stream().skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
            }
        }
    }









    @Override
    public void updateTask(CollectTask collectTask) {
        if (null == collectTaskMapper.selectByPrimaryKey(collectTask.getId())) {
            throw new ApiException("找不到相关任务记录");
        }
        collectTaskMapper.updateByPrimaryKey(collectTask.getNhCollectTask());
    }

    @Override
    public CollectTask insert(CollectTask entity) {
        return null;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(CollectTask entity) {
        return false;
    }


    @Override
    public CollectTask getByPrimaryKey(Long primaryKey) {
        return null;
    }
}