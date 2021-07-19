/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.client;

import com.huawei.hms.support.api.client.EmptyPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;

public class PendingResultsCreator$InstantPendingResult
extends EmptyPendingResult {
    public PendingResultsCreator$InstantPendingResult(Result result2) {
        this.setResult(result2);
    }

    public void cancel() {
        IllegalStateException illegalStateException = new IllegalStateException("cancel() is not available.");
        throw illegalStateException;
    }

    public void setResultCallback(ResultCallback resultCallback) {
        Result result2 = this.getResult();
        resultCallback.onResult(result2);
    }
}

