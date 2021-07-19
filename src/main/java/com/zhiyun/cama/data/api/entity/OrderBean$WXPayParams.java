/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

public class OrderBean$WXPayParams {
    private String appId;
    private String nonceStr;
    private String packageValue;
    private String partnerId;
    private String prepayId;
    private String sign;
    private String timeStamp;

    public String getAppId() {
        return this.appId;
    }

    public String getNonceStr() {
        return this.nonceStr;
    }

    public String getPackageValue() {
        return this.packageValue;
    }

    public String getPartnerId() {
        return this.partnerId;
    }

    public String getPrepayId() {
        return this.prepayId;
    }

    public String getSign() {
        return this.sign;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setAppId(String string2) {
        this.appId = string2;
    }

    public void setNonceStr(String string2) {
        this.nonceStr = string2;
    }

    public void setPackageValue(String string2) {
        this.packageValue = string2;
    }

    public void setPartnerId(String string2) {
        this.partnerId = string2;
    }

    public void setPrepayId(String string2) {
        this.prepayId = string2;
    }

    public void setSign(String string2) {
        this.sign = string2;
    }

    public void setTimeStamp(String string2) {
        this.timeStamp = string2;
    }
}

