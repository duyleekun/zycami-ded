/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.cama.data.api.entity.GooglePlayVerifyResultEntity;

public class GooglePlayVerifyResultEntity$Result {
    private String autoRenewState;
    private String googlePlayOrderId;
    private boolean hasNewGrant;
    private boolean isNewPay;
    private String orderSN;
    private String paymentState;
    private String thirdProductId;
    private String thirdProductType;
    public final /* synthetic */ GooglePlayVerifyResultEntity this$0;
    private String userId;

    public GooglePlayVerifyResultEntity$Result(GooglePlayVerifyResultEntity googlePlayVerifyResultEntity) {
        this.this$0 = googlePlayVerifyResultEntity;
    }

    public String getAutoRenewState() {
        return this.autoRenewState;
    }

    public String getGooglePlayOrderId() {
        return this.googlePlayOrderId;
    }

    public String getOrderSN() {
        return this.orderSN;
    }

    public String getPaymentState() {
        return this.paymentState;
    }

    public String getThirdProductId() {
        return this.thirdProductId;
    }

    public String getThirdProductType() {
        return this.thirdProductType;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isHasNewGrant() {
        return this.hasNewGrant;
    }

    public boolean isNewPay() {
        return this.isNewPay;
    }

    public void setAutoRenewState(String string2) {
        this.autoRenewState = string2;
    }

    public void setGooglePlayOrderId(String string2) {
        this.googlePlayOrderId = string2;
    }

    public void setHasNewGrant(boolean bl2) {
        this.hasNewGrant = bl2;
    }

    public void setNewPay(boolean bl2) {
        this.isNewPay = bl2;
    }

    public void setOrderSN(String string2) {
        this.orderSN = string2;
    }

    public void setPaymentState(String string2) {
        this.paymentState = string2;
    }

    public void setThirdProductId(String string2) {
        this.thirdProductId = string2;
    }

    public void setThirdProductType(String string2) {
        this.thirdProductType = string2;
    }

    public void setUserId(String string2) {
        this.userId = string2;
    }
}

