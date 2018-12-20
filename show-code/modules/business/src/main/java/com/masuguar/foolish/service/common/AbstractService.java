package com.masuguar.foolish.service.common;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masuguar.foolish.resposity.base.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

public class AbstractService<T> implements CommonService<T> {

    @Autowired
    private CommonMapper<T> commonMapper;

    private Class<T> modelClass;

    @Override
    public int insert(T record) {
        return commonMapper.insert(record);
    }

    public T findById(Long id ) {
        return commonMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAll() {
        return commonMapper.selectAll();
    }

    public List<T> findByCondition(Condition condition) {
        return commonMapper.selectByCondition(condition);
    }

    @Override
    public PageInfo<T> pageQueryByCondition(int pageNo, int pageSize, Condition condition) {
        PageHelper.startPage(pageNo,pageSize);
        List<T> list = commonMapper.selectByCondition(condition);
        return new PageInfo<T>(list);
    }
}
