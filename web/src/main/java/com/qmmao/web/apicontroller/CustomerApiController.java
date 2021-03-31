package com.qmmao.web.apicontroller;

import com.qmmao.model.common.BaseApiResponse;
import com.qmmao.model.customer.CustomerVO;
import com.qmmao.util.ApiResponseUtil;
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
