package com.qmmao.weiweischool.model;

import com.qmmao.weiweischool.model.constvar.ConstVar;

import java.io.Serializable;

/**
 * @author maoqi
 */
public class BaseApiResponse<T> implements Serializable {
    /**
     * 返回code，成功为1，-1为失败
     */
    private Integer code;

    /**
     * 请求返回信息
     */
    private String msg;

    /**
     * 返回实体
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseApiResponse() {
        setCode(ConstVar.NUM_1);
        setMsg(ConstVar.EMPTY);
    }

    public void setFail(String msg) {
        setCode(ConstVar.NUM_0);
        setMsg(msg);
    }
}
