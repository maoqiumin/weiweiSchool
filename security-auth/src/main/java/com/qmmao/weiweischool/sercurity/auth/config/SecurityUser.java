package com.qmmao.weiweischool.sercurity.auth.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qmmao.weiweischool.dao.teachingdb.entity.AuthorityGen;
import com.qmmao.weiweischool.model.vo.login.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author DELL
 */
public class SecurityUser implements UserDetails {

    private UserInfo userInfo;

    SecurityUser(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    private static final Logger log = LoggerFactory.getLogger(SecurityUser.class);

    /**
     * 权限集合
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (userInfo == null || CollectionUtils.isEmpty(userInfo.getAuthorities())) {
            log.info("获取登录用户已具有的权限：{}", authorities.toString());
            return authorities;
        }
        List<AuthorityGen> authorityGenList = userInfo.getAuthorities();
        for (AuthorityGen authorityGen : authorityGenList) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(authorityGen.getAuthorityCode());
            authorities.add(authority);
        }
        log.info("获取登录用户已具有的权限：{}", authorities.toString());
        return authorities;
    }

    @Override
    public String getPassword() {
        if (userInfo != null && userInfo.getUserInfo() != null) {
            return userInfo.getUserInfo().getPassword();
        }
        return StringUtils.EMPTY;
    }

    @Override
    public String getUsername() {
        if (userInfo != null && userInfo.getUserInfo() != null) {
            return userInfo.getUserInfo().getName();
        }
        return StringUtils.EMPTY;
    }

    /**
     * 指示用户的账户是否已过期。无法验证过期的账户。
     *
     * @return 如果用户的账户有效（即未过期），则返回true，如果不在有效就返回false
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指示用户是锁定还是解锁。无法对锁定的用户进行身份验证。
     *
     * @return 如果用户未被锁定，则返回true，否则返回false
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示用户的凭证（密码）是否已过期。过期的凭证阻止身份验证
     *
     * @return 如果用户的凭证有效（即未过期），则返回true
     * 如果不在有效（即过期），则返回false
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 指示用户是启用还是禁用。无法对禁用的用户进行身份验证
     *
     * @return 如果启用了用户，则返回true，否则返回false
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
