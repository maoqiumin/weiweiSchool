package com.qmmao.weiweischool.web.apicontroller;

import com.qmmao.weiweischool.dao.operatordb.entity.OperCarrierOrderPO;
import com.qmmao.weiweischool.model.BaseApiResponse;
import com.qmmao.weiweischool.service.servicemanger.operator.OperCarrierOrderService;
import com.qmmao.weiweischool.common.util.ApiResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qmmao
 */
@RestController
@RequestMapping("/operator")
public class OperatorApiController {
    @Autowired
    private OperCarrierOrderService operCarrierOrderService;

    @RequestMapping("/getAll")
    public BaseApiResponse<List<OperCarrierOrderPO>> getAll() {
        return ApiResponseUtil.getResult(operCarrierOrderService.findByAll());
    }
}
