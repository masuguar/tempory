package com.masuguar.foolish.resposity.formatter;

import com.masuguar.foolish.format.Formatter;
import com.masuguar.foolish.resposity.entity.UserInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserTableForammter implements Formatter<UserInfo> {
    @Override
    public String preffix(UserInfo userInfo) {
        return "";
    }

    @Override
    public String suffix(UserInfo userInfo) {
        Date date = userInfo.getCtime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }
}
