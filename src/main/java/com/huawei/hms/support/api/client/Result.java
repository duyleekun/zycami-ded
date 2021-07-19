/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.client;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;

public abstract class Result
implements IMessageEntity {
    private Status status;

    public Result() {
        Status status;
        this.status = status = Status.FAILURE;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        if (status == null) {
            return;
        }
        this.status = status;
    }
}

