package com.masuguar.foolish.resposity.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CITY")
public class CityInfo {
    @Id
    @Column(name = "CITY_ID")
    private Integer cityId;

    @Column(name = "CITY_CODE")
    private String cityCode;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "MTIME")
    private Date mtime;

    @Column(name = "CTIME")
    private Date ctime;

    /**
     * @return CITY_ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * @param cityId
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * @return CITY_CODE
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * @return CITY_NAME
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
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