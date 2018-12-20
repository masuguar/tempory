package com.masuguar.foolish.resposity.mapper;

import com.masuguar.foolish.resposity.base.CommonMapper;
import com.masuguar.foolish.resposity.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends CommonMapper<UserInfo> {
    int insertByCreateTable(  UserInfo user );
}