package com.happyjey.entity;

public class AdminRole {
    private String adminName;

    private String roleName;

    public AdminRole(String adminName, String roleName) {
        this.adminName = adminName;
        this.roleName = roleName;
    }

    public AdminRole() {
        super();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}