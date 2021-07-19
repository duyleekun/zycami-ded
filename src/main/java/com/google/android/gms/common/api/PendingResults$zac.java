/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

public final class PendingResults$zac
extends BasePendingResult {
    public PendingResults$zac(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final Result createFailedResult(Status object) {
        object = new UnsupportedOperationException("Creating failed results is not supported");
        throw object;
    }
}

