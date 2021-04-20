package com.qmmao.weiweischool.model.auth.vo;

import com.qmmao.weiweischool.model.auth.dto.AccountInfoDTO;

import java.time.LocalDateTime;

/**
 * @author DELL
 */
public class UserVO {

    private Long accountId;

    private String realName;

    private LocalDateTime expireTime;

    private String status;

    public UserVO() {

    }

    public UserVO(AccountInfoDTO accountInfoDTO) {
        this.accountId = accountInfoDTO.getAccountId();
        this.expireTime = accountInfoDTO.getExpireTime();
        this.realName = accountInfoDTO.getRealName();
        this.status = accountInfoDTO.getStatus();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
