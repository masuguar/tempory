package com.masuguar.foolish.service.common;

import com.masuguar.foolish.resposity.base.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

public class AbstractService<T> implements CommonService<T> {

    @Autowired
    private CommonMapper<T> commonMapper;

    private Class<T> modelClass;

    public T findById( Long id ) {
        return commonMapper.selectByPrimaryKey(id);
    }

    public List<T> findByCondition(Condition condition) {
        return null;
    }
}
