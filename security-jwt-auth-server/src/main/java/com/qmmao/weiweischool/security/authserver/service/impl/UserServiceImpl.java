package com.qmmao.weiweischool.security.authserver.service.impl;

import com.qmmao.weiweischool.security.authserver.service.UserService;
import com.qmmao.weiweischool.security.common.domin.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author DELL
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserPojo user = new UserPojo();
        user.setUsername(userName);
        user.setId(1);
        user.setPassword(bCryptPasswordEncoder.encode("123456"));
        user.setStatus(1);
        return user;
    }
}
