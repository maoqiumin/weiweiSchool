package com.qmmao.weiweischool.web.apicontroller;

import com.qmmao.weiweischool.model.BaseApiResponse;
import com.qmmao.weiweischool.model.customer.CustomerVO;
import com.qmmao.weiweischool.common.util.ApiResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maoqi
 */
@RestController
@RequestMapping("/customer")
public class CustomerApiController {
    @RequestMapping("/getByCustomerId")
    public BaseApiResponse<CustomerVO> getByCustomerId() {
        CustomerVO customer = new CustomerVO();
        customer.setCustomerId("test");
        customer.setCustomerName("毛秋民");
        return ApiResponseUtil.getResult(customer);
    }
}
