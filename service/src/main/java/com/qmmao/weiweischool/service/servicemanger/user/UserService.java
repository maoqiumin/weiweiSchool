package com.qmmao.weiweischool.service.servicemanger.user;

import com.qmmao.weiweischool.model.auth.dto.AccountInfoDTO;
import com.qmmao.weiweischool.model.enums.AccountStatusEnum;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    public AccountInfoDTO findUserByUsername(String userName) {
        //todo 访问数据库 userName
        AccountInfoDTO accountInfoDTO=new AccountInfoDTO();
        accountInfoDTO.setAccountCode("ww123456");
        accountInfoDTO.setAccountId(1L);
        accountInfoDTO.setBindEmail("1136@qq.com");
        accountInfoDTO.setBindPhone("18296160000");
        accountInfoDTO.setExpireTime(LocalDateTime.now().plusDays(1));
        accountInfoDTO.setPassword("123456");
        accountInfoDTO.setRealName("杨卫");
        accountInfoDTO.setStatus(AccountStatusEnum.VALID.getCode());
        return accountInfoDTO;
    }
}
