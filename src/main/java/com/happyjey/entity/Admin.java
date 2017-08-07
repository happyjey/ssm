package com.happyjey.entity;

import java.util.Date;

public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminPwd;

    private Date adminAtime;

    private Date adminLtime;

    public Admin(Integer adminId, String adminName, String adminPwd, Date adminAtime, Date adminLtime) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.adminAtime = adminAtime;
        this.adminLtime = adminLtime;
    }

    public Admin() {
        super();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd == null ? null : adminPwd.trim();
    }

    public Date getAdminAtime() {
        return adminAtime;
    }

    public void setAdminAtime(Date adminAtime) {
        this.adminAtime = adminAtime;
    }

    public Date getAdminLtime() {
        return adminLtime;
    }

    public void setAdminLtime(Date adminLtime) {
        this.adminLtime = adminLtime;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminAtime=" + adminAtime +
                ", adminLtime=" + adminLtime +
                '}';
    }
}