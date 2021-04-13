package com.qmmao.weiweischool.model.enums;

/**
 * @author DELL
 */

public enum RoleEnum {
    /**
     * 管理员
     */
    ADMIN("admin", "管理员"),
    /**
     * 店长
     */
    SHOPOWNER("shopowner", "店长"),
    /**
     * 老师
     */
    TEACHER("teacher", "老师");


    private RoleEnum(String roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    public static String getRoleName(String roleCode) {
        return "";
    }

    private String roleName;

    private String roleCode;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
