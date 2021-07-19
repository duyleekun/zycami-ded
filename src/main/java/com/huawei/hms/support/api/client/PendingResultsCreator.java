/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.common.api.internal.OptionalPendingResultImpl;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.PendingResultsCreator$DiscardedPendingResult;
import com.huawei.hms.support.api.client.PendingResultsCreator$InstantPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;

public final class PendingResultsCreator {
    public static PendingResult discardedPendingResult() {
        PendingResultsCreator$DiscardedPendingResult pendingResultsCreator$DiscardedPendingResult = new PendingResultsCreator$DiscardedPendingResult();
        return pendingResultsCreator$DiscardedPendingResult;
    }

    public static PendingResult discardedPendingResult(Result result2) {
        PendingResultsCreator$DiscardedPendingResult pendingResultsCreator$DiscardedPendingResult = new PendingResultsCreator$DiscardedPendingResult(result2);
        return pendingResultsCreator$DiscardedPendingResult;
    }

    public static OptionalPendingResult instantPendingResult(Result object) {
        PendingResultsCreator$InstantPendingResult pendingResultsCreator$InstantPendingResult = new PendingResultsCreator$InstantPendingResult((Result)object);
        object = new OptionalPendingResultImpl(pendingResultsCreator$InstantPendingResult);
        return object;
    }

    public static PendingResult instantPendingResult(Status status) {
        PendingResultsCreator$InstantPendingResult pendingResultsCreator$InstantPendingResult = new PendingResultsCreator$InstantPendingResult(status);
        return pendingResultsCreator$InstantPendingResult;
    }
}

