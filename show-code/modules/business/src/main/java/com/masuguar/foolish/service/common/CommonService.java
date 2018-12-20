package com.masuguar.foolish.service.common;

import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

public interface CommonService<T> {

    int insert( T record );
    T findById( Long id );
    List<T> findAll();
    List<T> findByCondition(Condition condition );

    PageInfo<T> pageQueryByCondition( int pageNo, int pageSize, Condition condition );
}
