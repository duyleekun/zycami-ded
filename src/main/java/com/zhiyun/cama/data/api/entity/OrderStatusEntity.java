/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.net.BaseEntity;

public class OrderStatusEntity
extends BaseEntity {
    private int hasGrant;
    private int state;
    private String tradeState;
    private String ts;

    public int getHasGrant() {
        return this.hasGrant;
    }

    public int getState() {
        return this.state;
    }

    public String getTradeState() {
        return this.tradeState;
    }

    public String getTs() {
        return this.ts;
    }

    public void setHasGrant(int n10) {
        this.hasGrant = n10;
    }

    public void setState(int n10) {
        this.state = n10;
    }

    public void setTradeState(String string2) {
        this.tradeState = string2;
    }

    public void setTs(String string2) {
        this.ts = string2;
    }
}

