/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults$zaa;
import com.google.android.gms.common.api.PendingResults$zab;
import com.google.android.gms.common.api.PendingResults$zac;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

public final class PendingResults {
    private PendingResults() {
    }

    public static PendingResult canceledPendingResult() {
        Looper looper = Looper.getMainLooper();
        StatusPendingResult statusPendingResult = new StatusPendingResult(looper);
        ((PendingResult)statusPendingResult).cancel();
        return statusPendingResult;
    }

    /*
     * WARNING - void declaration
     */
    public static PendingResult canceledPendingResult(Result result2) {
        void var2_5;
        Preconditions.checkNotNull(result2, "Result must not be null");
        Object object = result2.getStatus();
        int bl2 = ((Status)object).getStatusCode();
        int n10 = 16;
        if (bl2 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            object = null;
        }
        Preconditions.checkArgument((boolean)var2_5, "Status code must be CommonStatusCodes.CANCELED");
        object = new PendingResults$zaa(result2);
        ((PendingResult)object).cancel();
        return object;
    }

    public static PendingResult immediateFailedResult(Result result2, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(result2, "Result must not be null");
        Preconditions.checkArgument(result2.getStatus().isSuccess() ^ true, "Status code must not be SUCCESS");
        PendingResults$zab pendingResults$zab = new PendingResults$zab(googleApiClient, result2);
        pendingResults$zab.setResult(result2);
        return pendingResults$zab;
    }

    public static OptionalPendingResult immediatePendingResult(Result object) {
        Preconditions.checkNotNull(object, "Result must not be null");
        PendingResults$zac pendingResults$zac = new PendingResults$zac(null);
        pendingResults$zac.setResult((Result)object);
        object = new OptionalPendingResultImpl(pendingResults$zac);
        return object;
    }

    public static OptionalPendingResult immediatePendingResult(Result object, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(object, "Result must not be null");
        PendingResults$zac pendingResults$zac = new PendingResults$zac(googleApiClient);
        pendingResults$zac.setResult((Result)object);
        object = new OptionalPendingResultImpl(pendingResults$zac);
        return object;
    }

    public static PendingResult immediatePendingResult(Status status) {
        Preconditions.checkNotNull(status, "Result must not be null");
        Looper looper = Looper.getMainLooper();
        StatusPendingResult statusPendingResult = new StatusPendingResult(looper);
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }

    public static PendingResult immediatePendingResult(Status status, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }
}

