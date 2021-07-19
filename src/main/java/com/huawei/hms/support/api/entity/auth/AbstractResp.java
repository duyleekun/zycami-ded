/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;

public abstract class AbstractResp
implements IMessageEntity {
    private String errorReason;
    private int rtnCode = 0;

    public String getErrorReason() {
        return this.errorReason;
    }

    public int getRtnCode() {
        return this.rtnCode;
    }

    public void setErrorReason(String string2) {
        this.errorReason = string2;
    }

    public void setRtnCode(int n10) {
        this.rtnCode = n10;
    }
}

