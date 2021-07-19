/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

public class SubscribeStateEntity$SubScribeState {
    private int autoRenewing;
    private String platform;
    private int productId;
    private String subProductName;

    public int getAutoRenewing() {
        return this.autoRenewing;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int getProductId() {
        return this.productId;
    }

    public String getSubProductName() {
        return this.subProductName;
    }

    public void setAutoRenewing(int n10) {
        this.autoRenewing = n10;
    }

    public void setPlatform(String string2) {
        this.platform = string2;
    }

    public void setProductId(int n10) {
        this.productId = n10;
    }

    public void setSubProductName(String string2) {
        this.subProductName = string2;
    }
}

