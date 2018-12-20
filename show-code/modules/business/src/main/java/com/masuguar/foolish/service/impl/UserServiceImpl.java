package com.masuguar.foolish.service.impl;

import com.masuguar.foolish.resposity.entity.UserInfo;
import com.masuguar.foolish.resposity.mapper.UserInfoMapper;
import com.masuguar.foolish.service.UserInfoService;
import com.masuguar.foolish.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int insertByCreateTable(UserInfo userInfo) {
        return userInfoMapper.insertByCreateTable(userInfo);
    }
}
