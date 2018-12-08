package com.masuguar.foolish.service.common;

import tk.mybatis.mapper.entity.Condition;

import java.util.List;

public interface CommonService<T> {
    T findById( Long id );
    List<T> findByCondition(Condition condition );
}
