package org.example.model;

import java.io.Serializable;

public class ShoppingOrderItem implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer buycount;

    private Double subMoney;

    private Integer orderId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBuycount() {
        return buycount;
    }

    public void setBuycount(Integer buycount) {
        this.buycount = buycount;
    }

    public Double getSubMoney() {
        return subMoney;
    }

    public void setSubMoney(Double subMoney) {
        this.subMoney = subMoney;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}