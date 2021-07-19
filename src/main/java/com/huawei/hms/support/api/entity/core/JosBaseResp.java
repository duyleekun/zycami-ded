/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;

public class JosBaseResp
implements IMessageEntity {
    private int statusCode;

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int n10) {
        this.statusCode = n10;
    }
}

