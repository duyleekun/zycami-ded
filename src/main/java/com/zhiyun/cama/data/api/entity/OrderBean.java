/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.cama.data.api.entity.OrderBean$WXPayParams;
import com.zhiyun.net.BaseEntity;

public class OrderBean
extends BaseEntity {
    private String orderSN;
    private String thirdProductId;
    private String thirdProductType;
    private String ts;
    private OrderBean$WXPayParams wxPayParams;

    public String getOrderSN() {
        return this.orderSN;
    }

    public String getThirdProductId() {
        return this.thirdProductId;
    }

    public String getThirdProductType() {
        return this.thirdProductType;
    }

    public String getTs() {
        return this.ts;
    }

    public OrderBean$WXPayParams getWxPayParams() {
        return this.wxPayParams;
    }

    public void setOrderSN(String string2) {
        this.orderSN = string2;
    }

    public void setThirdProductId(String string2) {
        this.thirdProductId = string2;
    }

    public void setThirdProductType(String string2) {
        this.thirdProductType = string2;
    }

    public void setTs(String string2) {
        this.ts = string2;
    }

    public void setWxPayParams(OrderBean$WXPayParams orderBean$WXPayParams) {
        this.wxPayParams = orderBean$WXPayParams;
    }
}

