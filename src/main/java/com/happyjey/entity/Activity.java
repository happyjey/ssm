package com.happyjey.entity;

import java.util.Date;

public class Activity {
    private Integer actId;

    private Integer actUid;

    private String actPic;

    private Date actStime;

    private String actAddress;

    private Short actLimitNum;

    private Integer actFee;

    private Double actLat;

    private Double actLon;

    private Byte actStatus;

    private Date actAtime;

    private Date actUtime;

    private String actDesc;

    public Activity(Integer actId, Integer actUid, String actPic, Date actStime, String actAddress, Short actLimitNum, Integer actFee, Double actLat, Double actLon, Byte actStatus, Date actAtime, Date actUtime, String actDesc) {
        this.actId = actId;
        this.actUid = actUid;
        this.actPic = actPic;
        this.actStime = actStime;
        this.actAddress = actAddress;
        this.actLimitNum = actLimitNum;
        this.actFee = actFee;
        this.actLat = actLat;
        this.actLon = actLon;
        this.actStatus = actStatus;
        this.actAtime = actAtime;
        this.actUtime = actUtime;
        this.actDesc = actDesc;
    }

    public Activity() {
        super();
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public Integer getActUid() {
        return actUid;
    }

    public void setActUid(Integer actUid) {
        this.actUid = actUid;
    }

    public String getActPic() {
        return actPic;
    }

    public void setActPic(String actPic) {
        this.actPic = actPic == null ? null : actPic.trim();
    }

    public Date getActStime() {
        return actStime;
    }

    public void setActStime(Date actStime) {
        this.actStime = actStime;
    }

    public String getActAddress() {
        return actAddress;
    }

    public void setActAddress(String actAddress) {
        this.actAddress = actAddress == null ? null : actAddress.trim();
    }

    public Short getActLimitNum() {
        return actLimitNum;
    }

    public void setActLimitNum(Short actLimitNum) {
        this.actLimitNum = actLimitNum;
    }

    public Integer getActFee() {
        return actFee;
    }

    public void setActFee(Integer actFee) {
        this.actFee = actFee;
    }

    public Double getActLat() {
        return actLat;
    }

    public void setActLat(Double actLat) {
        this.actLat = actLat;
    }

    public Double getActLon() {
        return actLon;
    }

    public void setActLon(Double actLon) {
        this.actLon = actLon;
    }

    public Byte getActStatus() {
        return actStatus;
    }

    public void setActStatus(Byte actStatus) {
        this.actStatus = actStatus;
    }

    public Date getActAtime() {
        return actAtime;
    }

    public void setActAtime(Date actAtime) {
        this.actAtime = actAtime;
    }

    public Date getActUtime() {
        return actUtime;
    }

    public void setActUtime(Date actUtime) {
        this.actUtime = actUtime;
    }

    public String getActDesc() {
        return actDesc;
    }

    public void setActDesc(String actDesc) {
        this.actDesc = actDesc == null ? null : actDesc.trim();
    }

    @Override
    public String toString() {
        return "Activity{" +
                "actId=" + actId +
                ", actUid=" + actUid +
                ", actPic='" + actPic + '\'' +
                ", actStime=" + actStime +
                ", actAddress='" + actAddress + '\'' +
                ", actLimitNum=" + actLimitNum +
                ", actFee=" + actFee +
                ", actLat=" + actLat +
                ", actLon=" + actLon +
                ", actStatus=" + actStatus +
                ", actAtime=" + actAtime +
                ", actUtime=" + actUtime +
                ", actDesc='" + actDesc + '\'' +
                '}';
    }
}