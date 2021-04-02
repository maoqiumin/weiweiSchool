package com.qmmao.weiweischool.dao.operatordb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 运营商订单
 */
@TableName(value = "oper_carrier_order")
public class OperCarrierOrderPO implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 销售单编码
     */
    @TableField(value = "order_code")
    private String orderCode;

    /**
     * 门店ID
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 运营商类型
     */
    @TableField(value = "operator_type")
    private Integer operatorType;

    /**
     * 下单时间
     */
    @TableField(value = "order_date")
    private LocalDateTime orderDate;

    /**
     * 配送方式
     */
    @TableField(value = "ship_type")
    private Integer shipType;

    /**
     * 校验状态
     */
    @TableField(value = "check_status")
    private Integer checkStatus;

    /**
     * 订单状态
     */
    @TableField(value = "order_status")
    private Integer orderStatus;

    @TableField(value = "created_by")
    private Long createdBy;

    @TableField(value = "created_date")
    private LocalDateTime createdDate;

    @TableField(value = "last_modified_by")
    private Long lastModifiedBy;

    @TableField(value = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @TableField(value = "remarks")
    private String remarks;

    @TableField(value = "enabled")
    private Boolean enabled;

    @TableField(value = "tenant_code")
    private String tenantCode;

    @TableField(value = "application_id")
    private Long applicationId;

    @TableField(value = "version")
    private Integer version;

    @TableField(value = "carrier_code")
    private String carrierCode;

    /**
     * 销售订单ID
     */
    @TableField(value = "sale_id")
    private Long saleId;

    /**
     * 销售订单编号
     */
    @TableField(value = "sale_no")
    private String saleNo;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取销售单编码
     *
     * @return order_code - 销售单编码
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 设置销售单编码
     *
     * @param orderCode 销售单编码
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * 获取门店ID
     *
     * @return shop_id - 门店ID
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * 设置门店ID
     *
     * @param shopId 门店ID
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取运营商类型
     *
     * @return operator_type - 运营商类型
     */
    public Integer getOperatorType() {
        return operatorType;
    }

    /**
     * 设置运营商类型
     *
     * @param operatorType 运营商类型
     */
    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    /**
     * 获取下单时间
     *
     * @return order_date - 下单时间
     */
    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    /**
     * 设置下单时间
     *
     * @param orderDate 下单时间
     */
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * 获取配送方式
     *
     * @return ship_type - 配送方式
     */
    public Integer getShipType() {
        return shipType;
    }

    /**
     * 设置配送方式
     *
     * @param shipType 配送方式
     */
    public void setShipType(Integer shipType) {
        this.shipType = shipType;
    }

    /**
     * 获取校验状态
     *
     * @return check_status - 校验状态
     */
    public Integer getCheckStatus() {
        return checkStatus;
    }

    /**
     * 设置校验状态
     *
     * @param checkStatus 校验状态
     */
    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * 获取订单状态
     *
     * @return order_status - 订单状态
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态
     *
     * @param orderStatus 订单状态
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return created_by
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return created_date
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return last_modified_by
     */
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * @return last_modified_date
     */
    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @param lastModifiedDate
     */
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return tenant_code
     */
    public String getTenantCode() {
        return tenantCode;
    }

    /**
     * @param tenantCode
     */
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    /**
     * @return application_id
     */
    public Long getApplicationId() {
        return applicationId;
    }

    /**
     * @param applicationId
     */
    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return carrier_code
     */
    public String getCarrierCode() {
        return carrierCode;
    }

    /**
     * @param carrierCode
     */
    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    /**
     * 获取销售订单ID
     *
     * @return sale_id - 销售订单ID
     */
    public Long getSaleId() {
        return saleId;
    }

    /**
     * 设置销售订单ID
     *
     * @param saleId 销售订单ID
     */
    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    /**
     * 获取销售订单编号
     *
     * @return sale_no - 销售订单编号
     */
    public String getSaleNo() {
        return saleNo;
    }

    /**
     * 设置销售订单编号
     *
     * @param saleNo 销售订单编号
     */
    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo;
    }
}