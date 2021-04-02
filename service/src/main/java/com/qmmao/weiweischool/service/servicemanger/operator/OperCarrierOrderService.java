package com.qmmao.weiweischool.service.servicemanger.operator;

import com.qmmao.weiweischool.constvar.ConstVar;
import com.qmmao.weiweischool.dao.operatordb.entity.OperCarrierOrderPO;
import com.qmmao.weiweischool.dao.operatordb.mapper.OperCarrierOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qmmao
 */
@Service
public class OperCarrierOrderService {
    @Autowired
    private OperCarrierOrderDAO operCarrierOrderDAO;

    public List<OperCarrierOrderPO> findByAll() {
        OperCarrierOrderPO orderCondition = new OperCarrierOrderPO();
        orderCondition.setEnabled(ConstVar.BOOLEAN_TRUE);
        orderCondition.setSaleId(1377198465221845015L);
        return operCarrierOrderDAO.findByAll(orderCondition);
    }
}
