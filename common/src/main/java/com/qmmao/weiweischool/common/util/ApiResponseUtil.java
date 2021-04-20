package com.qmmao.weiweischool.common.util;

import com.qmmao.weiweischool.model.BaseApiResponse;
import com.qmmao.weiweischool.model.enums.ResponseCodeEnum;

/**
 * @author maoqi
 */
public class ApiResponseUtil {

    public static <T> BaseApiResponse<T> getResult(T vo) {
        BaseApiResponse<T> response = new BaseApiResponse<>();
        if (vo == null) {
            response.setFail("数据为空");
            return response;
        }
        response.setData(vo);
        return response;
    }

    public static <T> BaseApiResponse<T> getFail(ResponseCodeEnum responseCodeEnum) {
        BaseApiResponse<T> response = new BaseApiResponse<>();
        response.setCode(responseCodeEnum.getCode());
        response.setMsg(responseCodeEnum.getMsg());
        return response;
    }
    public static <T> BaseApiResponse<T> getFail(String msg) {
        BaseApiResponse<T> response = new BaseApiResponse<>();
        response.setFail(msg);
        return response;
    }
}
