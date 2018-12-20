package com.masuguar.foolish.resposity.formatter;

import com.masuguar.foolish.format.Formatter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserTableForammter implements Formatter<Date> {
    @Override
    public String preffix(Date date) {
        return "";
    }

    @Override
    public String suffix(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
        return sdf.format(date);
    }
}
