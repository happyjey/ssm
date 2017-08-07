package com.happyjey.entity;

public class RolePermission {
    private String roleName;

    private String permission;

    public RolePermission(String roleName, String permission) {
        this.roleName = roleName;
        this.permission = permission;
    }

    public RolePermission() {
        super();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }
}