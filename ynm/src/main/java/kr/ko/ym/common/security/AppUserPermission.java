package kr.ko.ym.common.security;

public enum AppUserPermission {

    USER_READ("user:read"),
    USER_WRITE("user:write"),
    GUEST_READ("guest:read");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
