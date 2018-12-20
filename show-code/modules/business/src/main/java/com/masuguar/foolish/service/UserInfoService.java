package com.masuguar.foolish.service;

import com.masuguar.foolish.resposity.entity.UserInfo;
import com.masuguar.foolish.service.common.CommonService;
import org.apache.catalina.User;

public interface UserInfoService  extends CommonService<UserInfo> {
    int insertByCreateTable(UserInfo userInfo);
}
