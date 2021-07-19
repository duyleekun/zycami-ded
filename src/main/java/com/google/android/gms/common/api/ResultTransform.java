/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zacd;

public abstract class ResultTransform {
    public final PendingResult createFailedResult(Status status) {
        zacd zacd2 = new zacd(status);
        return zacd2;
    }

    public Status onFailure(Status status) {
        return status;
    }

    public abstract PendingResult onSuccess(Result var1);
}

