/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

public final class PendingResults$zab
extends BasePendingResult {
    private final Result zacj;

    public PendingResults$zab(GoogleApiClient googleApiClient, Result result2) {
        super(googleApiClient);
        this.zacj = result2;
    }

    public final Result createFailedResult(Status status) {
        return this.zacj;
    }
}

