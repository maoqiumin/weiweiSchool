package com.qmmao.weiweischool.service.servicemanger.user;

import com.qmmao.weiweischool.dao.teachingdb.entity.AuthorityGen;
import com.qmmao.weiweischool.dao.teachingdb.entity.RoleGen;
import com.qmmao.weiweischool.dao.teachingdb.entity.UserGen;
import com.qmmao.weiweischool.model.vo.login.UserInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author DELL
 */
@Service
public class UserService {

    /**
     * 根据登陆名获取用户信息
     *
     * @param userName
     * @return
     */
    public UserInfo findUserByUsername(String userName) {
        //todo 访问数据库
        UserInfo tempInfo = new UserInfo();
        tempInfo.setUserInfo(new UserGen());
        tempInfo.setRoles(new ArrayList<>());
        tempInfo.setAuthorities(new ArrayList<>());
        tempInfo.getUserInfo().setName("admin");
        tempInfo.getUserInfo().setPassword("admin");
        tempInfo.getRoles().add(new RoleGen());
        AuthorityGen authorityGen = new AuthorityGen();
        authorityGen.setAuthorityCode("admin");
        authorityGen.setAuthorityName("管理员");
        tempInfo.getAuthorities().add(authorityGen);
        List<UserInfo> tempData = Collections.singletonList(tempInfo);
        return tempData.stream().filter(x -> x.getUserInfo().getName().equals(userName)).findFirst().orElse(new UserInfo());
    }
}
