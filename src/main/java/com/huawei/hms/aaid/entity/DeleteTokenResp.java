/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;

public class DeleteTokenResp
implements IMessageEntity {
    public int retCode = 0;

    public int getRetCode() {
        return this.retCode;
    }

    public void setRetCode(int n10) {
        this.retCode = n10;
    }
}

