package com.qmmao.weiweischool.model.vo.login;

import com.qmmao.weiweischool.dao.teachingdb.entity.AuthorityGen;
import com.qmmao.weiweischool.dao.teachingdb.entity.RoleGen;
import com.qmmao.weiweischool.dao.teachingdb.entity.UserGen;

import java.util.List;

/**
 * @author maoqi
 */
public class UserInfo {
    private UserGen userInfo;

    private List<RoleGen> roles;

    private List<AuthorityGen> authorities;

    public UserGen getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserGen userInfo) {
        this.userInfo = userInfo;
    }

    public List<RoleGen> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleGen> roles) {
        this.roles = roles;
    }

    public List<AuthorityGen> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityGen> authorities) {
        this.authorities = authorities;
    }
}
