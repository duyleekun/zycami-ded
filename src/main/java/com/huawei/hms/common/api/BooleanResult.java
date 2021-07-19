/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.api;

import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;

public class BooleanResult
extends Result {
    private final Status myStatus;
    private final boolean resultValue;

    public BooleanResult(Status status, boolean bl2) {
        Preconditions.checkNotNull(status, "status cannot be null");
        this.myStatus = status;
        this.resultValue = bl2;
    }

    public final boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof BooleanResult;
        if (bl3) {
            Status status;
            boolean bl4;
            bl3 = this.resultValue;
            boolean bl5 = ((BooleanResult)(object = (BooleanResult)object)).getValue();
            if (bl3 != bl5 || !(bl4 = (status = this.myStatus).equals(object = ((BooleanResult)object).getStatus()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Status getStatus() {
        return this.myStatus;
    }

    public boolean getValue() {
        return this.resultValue;
    }

    public final int hashCode() {
        int n10 = this.resultValue;
        int n11 = (this.myStatus.hashCode() + 127) * 77;
        return n10 + n11;
    }
}

