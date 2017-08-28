package com.happyjey.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPwd;

    private String userNickname;

    private String userAvatar;

    private Date userAtime;

    private Date userLoginTime;

    private String userLoginIp;

    public User(Integer userId, String userName, String userPwd, String userNickname, String userAvatar, Date userAtime, Date userLoginTime, String userLoginIp) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userNickname = userNickname;
        this.userAvatar = userAvatar;
        this.userAtime = userAtime;
        this.userLoginTime = userLoginTime;
        this.userLoginIp = userLoginIp;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public Date getUserAtime() {
        return userAtime;
    }

    public void setUserAtime(Date userAtime) {
        this.userAtime = userAtime;
    }

    public Date getUserLoginTime() {
        return userLoginTime;
    }

    public void setUserLoginTime(Date userLoginTime) {
        this.userLoginTime = userLoginTime;
    }

    public String getUserLoginIp() {
        return userLoginIp;
    }

    public void setUserLoginIp(String userLoginIp) {
        this.userLoginIp = userLoginIp == null ? null : userLoginIp.trim();
    }
}