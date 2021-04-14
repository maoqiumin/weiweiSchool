package com.qmmao.weiweischool.sercurity.auth.config;

import com.qmmao.weiweischool.model.vo.login.UserInfo;
import com.qmmao.weiweischool.service.servicemanger.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author DELL
 */
@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        LOGGER.info("对用户 [{}] 进行信息加载...", userName);
        /* 从数据库里面查出用户 */
        UserInfo user = userService.findUserByUsername(userName);
        if (user == null) {
            LOGGER.error("用户 [{}] 未找到", userName);
            throw new UsernameNotFoundException("Username：[" + userName + "] not found");
        }
        LOGGER.info("用户 [{}] 信息加载完成", user);
        user.getUserInfo().setPassword(bCryptPasswordEncoder.encode(user.getUserInfo().getPassword()));

        // SecurityUser 实现UserDetails
        return new SecurityUser(user);
    }
}
