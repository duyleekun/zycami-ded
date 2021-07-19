/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.BatchResultToken;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.TimeUnit;

public final class BatchResult
implements Result {
    private final Status mStatus;
    private final PendingResult[] zabc;

    public BatchResult(Status status, PendingResult[] pendingResultArray) {
        this.mStatus = status;
        this.zabc = pendingResultArray;
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final Result take(BatchResultToken object) {
        PendingResult[] pendingResultArray;
        int n10 = ((BatchResultToken)object).mId;
        PendingResult[] pendingResultArray2 = this.zabc;
        int n11 = pendingResultArray2.length;
        if (n10 < n11) {
            n10 = 1;
        } else {
            n10 = 0;
            pendingResultArray = null;
        }
        Preconditions.checkArgument(n10 != 0, "The result token does not belong to this batch");
        pendingResultArray = this.zabc;
        int n12 = ((BatchResultToken)object).mId;
        object = pendingResultArray[n12];
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return ((PendingResult)object).await(0L, timeUnit);
    }
}

