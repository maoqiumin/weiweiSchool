package com.qmmao.util;

import com.qmmao.model.common.BaseApiResponse;

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
}
