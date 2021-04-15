package com.qmmao.weiweischool.model.vo.login;

import java.util.List;

/**
 * @author DELL
 */
public class RoleDTO {
    private Long roleId;

    private String roleCode;

    private String roleName;

    private List<String> authorityCodes;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<String> getAuthorityCodes() {
        return authorityCodes;
    }

    public void setAuthorityCodes(List<String> authorityCodes) {
        this.authorityCodes = authorityCodes;
    }
}
