/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

public final class PendingResults$zaa
extends BasePendingResult {
    private final Result zaci;

    public PendingResults$zaa(Result result2) {
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.zaci = result2;
    }

    public final Result createFailedResult(Status object) {
        Status status;
        int n10;
        int n11 = ((Status)object).getStatusCode();
        if (n11 == (n10 = (status = this.zaci.getStatus()).getStatusCode())) {
            return this.zaci;
        }
        object = new UnsupportedOperationException("Creating failed results is not supported");
        throw object;
    }
}

