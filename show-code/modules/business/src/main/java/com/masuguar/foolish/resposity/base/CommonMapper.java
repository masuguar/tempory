package com.masuguar.foolish.resposity.base;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseInsertMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;
import tk.mybatis.mapper.common.base.select.SelectAllMapper;
import tk.mybatis.mapper.common.base.select.SelectByPrimaryKeyMapper;

public interface CommonMapper<T> extends BaseInsertMapper<T>,
        SelectAllMapper<T>,
        SelectByPrimaryKeyMapper<T>,
        BaseDeleteMapper<T>,
        BaseUpdateMapper<T>,
        ConditionMapper<T> {
}
