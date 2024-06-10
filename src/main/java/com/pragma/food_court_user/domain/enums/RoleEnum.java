package com.pragma.food_court_user.domain.enums;

public enum RoleEnum {
    ADMIN("ADMIN"),
    OWNER("OWNER"),
    EMPLOYEE("EMPLOYEE"),
    CUSTOMER("CUSTOMER");

    private String roleName;

    RoleEnum(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
