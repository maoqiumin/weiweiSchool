package com.qmmao.weiweischool.model.enums;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * @author DELL
 */

public enum AccountStatusEnum {
    /**
     * 生效中
     */
    VALID("valid", "生效中"),
    /**
     * 封禁中
     */
    CLOSE("close", "封禁中"),
    /**
     * 已过期
     */
    EXPIRE("expire", "已过期"),
    /**
     * 未认证
     */
    UNAUTHORIZED("unauthorized", "未认证");

    //普通方法
    public static String getMsg(String code) {
        for (AccountStatusEnum a : AccountStatusEnum.values()) {
            if (code.equals(a.getCode())) {
                return a.getMsg();
            }
        }
        return StringUtils.EMPTY;
    }

    public static AccountStatusEnum getAccountStatus(String code) {
        for (AccountStatusEnum a : AccountStatusEnum.values()) {
            if (code.equals(a.getCode())) {
                return a;
            }
        }
        return UNAUTHORIZED;
    }

    private AccountStatusEnum(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
