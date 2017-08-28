package com.happyjey.entity;

import java.util.Date;

public class ActivityIn {
    private Integer inUid;

    private Integer inAid;

    private Byte inStatus;

    private Date inAtime;

    public ActivityIn(Integer inUid, Integer inAid, Byte inStatus, Date inAtime) {
        this.inUid = inUid;
        this.inAid = inAid;
        this.inStatus = inStatus;
        this.inAtime = inAtime;
    }

    public ActivityIn() {
        super();
    }

    public Integer getInUid() {
        return inUid;
    }

    public void setInUid(Integer inUid) {
        this.inUid = inUid;
    }

    public Integer getInAid() {
        return inAid;
    }

    public void setInAid(Integer inAid) {
        this.inAid = inAid;
    }

    public Byte getInStatus() {
        return inStatus;
    }

    public void setInStatus(Byte inStatus) {
        this.inStatus = inStatus;
    }

    public Date getInAtime() {
        return inAtime;
    }

    public void setInAtime(Date inAtime) {
        this.inAtime = inAtime;
    }
}