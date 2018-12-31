package com.masuguar.foolish.resposity.entity;

import com.masuguar.foolish.resposity.formatter.UserTableForammter;
import tk.mybatis.mapper.annotation.InheritTable;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Table(name = "USER_INFO")
@InheritTable( formatter = UserTableForammter.class)
public class UserInfo {
    @Id
    @KeySql(useGeneratedKeys = false, sql = "select nextval('s_user_info')")
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "USER_CODE")
    private String userCode;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MTIME")
    private Date mtime;

    @Column(name = "CTIME")
    private Date ctime;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userCode='" + userCode + '\'' +
                ", name='" + name + '\'' +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }

    /**
     * @return USER_ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return USER_CODE
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * @param userCode
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return MTIME
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * @param mtime
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * @return CTIME
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * @param ctime
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}