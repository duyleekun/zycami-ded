/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.client;

import com.huawei.hms.support.api.client.EmptyPendingResult;
import com.huawei.hms.support.api.client.Result;

public class PendingResultsCreator$DiscardedPendingResult
extends EmptyPendingResult {
    public PendingResultsCreator$DiscardedPendingResult() {
    }

    public PendingResultsCreator$DiscardedPendingResult(Result result2) {
        this.setResult(result2);
    }

    public boolean isCanceled() {
        return true;
    }
}

