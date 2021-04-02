package com.qmmao.weiweischool.dao.operatordb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qmmao.weiweischool.dao.operatordb.entity.OperCarrierOrderPO;
import com.qmmao.weiweischool.dao.operatordb.entity.OperCarrierOrderPOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OperCarrierOrderDAO extends BaseMapper<OperCarrierOrderPO> {
    long countByExample(OperCarrierOrderPOExample example);

    int deleteByExample(OperCarrierOrderPOExample example);

    List<OperCarrierOrderPO> selectByExample(OperCarrierOrderPOExample example);

    int updateByExampleSelective(@Param("record") OperCarrierOrderPO record, @Param("example") OperCarrierOrderPOExample example);

    int updateByExample(@Param("record") OperCarrierOrderPO record, @Param("example") OperCarrierOrderPOExample example);

    List<OperCarrierOrderPO> findByAll(OperCarrierOrderPO operCarrierOrderPO);

    int updateBatch(List<OperCarrierOrderPO> list);

    int batchInsert(@Param("list") List<OperCarrierOrderPO> list);

    int insertOrUpdate(OperCarrierOrderPO record);

    int insertOrUpdateSelective(OperCarrierOrderPO record);

    int deleteByPrimaryKey(Long id);

    int insert(OperCarrierOrderPO record);

    int insertSelective(OperCarrierOrderPO record);

    OperCarrierOrderPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OperCarrierOrderPO record);

    int updateByPrimaryKey(OperCarrierOrderPO record);
}