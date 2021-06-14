package com.nanhai.core.framework.object;

import com.nanhai.core.business.vo.SysRoleConditionVO;

import java.util.List;


public interface AbstractService<T, PK> {

    T insert(T entity);

    default void insertList(List<T> entities) {

    }

    boolean removeByPrimaryKey(PK primaryKey);

    boolean updateSelective(T entity);

    T getByPrimaryKey(PK primaryKey);

    default List<T> listAll() {
        return null;
    }
}
