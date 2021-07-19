/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.client;

import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultConvert$FailPendingResult;
import com.huawei.hms.support.api.client.Status;

public abstract class ResultConvert {
    public final PendingResult newFailedPendingResult(Status status) {
        Preconditions.checkNotNull(status, "The input status cannot be null");
        Preconditions.checkArgument(status.isSuccess() ^ true, "The input status must be call with success status");
        ResultConvert$FailPendingResult resultConvert$FailPendingResult = new ResultConvert$FailPendingResult(this, status);
        return resultConvert$FailPendingResult;
    }

    public Status onFailed(Status status) {
        String string2 = "The input status cannot be null";
        Preconditions.checkNotNull(status, string2);
        int n10 = status.getStatusCode();
        if (n10 != 0) {
            return status;
        }
        return Status.CoreException;
    }

    public abstract PendingResult onSuccess(Result var1);
}

