package com.qmmao.mybatis.controller;

import com.qmmao.weiweischool.model.common.BaseApiResponse;
import com.qmmao.mybatis.mapper.CustomerMapper;
import com.qmmao.weiweischool.util.ApiResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qmmao.weiweischool.dao.teachingdb.entity.CustomerGen;

/**
 * @author maoqi
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private CustomerMapper customerMapper;

    @RequestMapping("/getByCustomerId")
    public BaseApiResponse<CustomerGen> getByCustomerId() {
        CustomerGen customer = customerMapper.queryByPk(1L);

        return ApiResponseUtil.getResult(customer);
    }
}
