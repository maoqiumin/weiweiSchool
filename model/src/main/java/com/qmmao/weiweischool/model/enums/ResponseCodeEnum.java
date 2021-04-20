package com.qmmao.weiweischool.model.enums;

/**
 * @author DELL
 */

public enum ResponseCodeEnum {
    /**
     * 验证码错误
     */
    CODEFAIL(10001, "验证码错误"),
    /**
     * 密码与账号不匹配
     */
    ACCOUNTFAIL(10002, "密码与账号不匹配"),
    /**
     * token无效
     */
    TOKENINVALID(10003, "token无效"),
    /**
     * token过期
     */
    TOKENEXPIRE(10004,"token过期");

    private ResponseCodeEnum(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    private String msg;

    private Integer code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
