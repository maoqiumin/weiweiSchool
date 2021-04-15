package com.qmmao.weiweischool.service.servicemanger.user;

import com.qmmao.weiweischool.dao.teachingdb.entity.AuthorityGen;
import com.qmmao.weiweischool.dao.teachingdb.entity.RoleGen;
import com.qmmao.weiweischool.dao.teachingdb.entity.UserGen;
import com.qmmao.weiweischool.model.vo.login.RoleDTO;
import com.qmmao.weiweischool.model.vo.login.UserInfoDTO;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public UserInfoDTO findUserByUsername(String userName) {
        //todo 访问数据库 userName
        UserGen userGen = new UserGen();
        userGen.setName("admin");
        userGen.setPassword("admin");
        List<RoleGen> roleGens = Lists.newArrayList();
        RoleGen roleGen = new RoleGen();
        roleGen.setId(11L);
        roleGen.setRoleCode("admin");
        roleGen.setRoleName("管理员角色");
        roleGens.add(roleGen);
        List<AuthorityGen> authorityGens = Lists.newArrayList();
        AuthorityGen authorityGen = new AuthorityGen();
        authorityGen.setAuthorityName("所有操作权限");
        authorityGen.setAuthorityCode("all");
        authorityGen.setId(333L);
        authorityGen.setRoleId(11L);
        authorityGens.add(authorityGen);
        return convert(userGen, roleGens, authorityGens);
    }

    private UserInfoDTO convert(UserGen userGen, List<RoleGen> roleGens, List<AuthorityGen> authorityGens) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setDelete(userGen.getDelete());
        userInfoDTO.setId(userGen.getId());
        userInfoDTO.setPassword(userGen.getPassword());
        userInfoDTO.setStatus(userGen.getStatus());
        userInfoDTO.setUserName(userGen.getName());
        List<RoleDTO> roles = new ArrayList<>(roleGens.size());
        for (RoleGen roleGen : roleGens) {
            RoleDTO tempRole = new RoleDTO();
            tempRole.setRoleCode(roleGen.getRoleCode());
            tempRole.setRoleName(roleGen.getRoleName());
            tempRole.setRoleId(roleGen.getId());
            List<String> authCodes = authorityGens.stream().filter(x -> x.getRoleId().equals(roleGen.getId()))
                    .map(AuthorityGen::getAuthorityCode).distinct().collect(Collectors.toList());
            tempRole.setAuthorityCodes(authCodes);
            roles.add(tempRole);
        }
        userInfoDTO.setRoles(roles);
        return userInfoDTO;
    }
}
