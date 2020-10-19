package kr.ko.ym.common.security;

public enum AppUserPermission {

    USER_READ("user:read"),
    USER_WRITE("user:write"),
    MANAGER_READ("manager:read"),
    MANAGER_WRITE("manager:write");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
