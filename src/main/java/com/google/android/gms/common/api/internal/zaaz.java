/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zaaw;

public final class zaaz
implements GoogleApiClient$OnConnectionFailedListener {
    private final /* synthetic */ StatusPendingResult zahj;

    public zaaz(zaaw zaaw2, StatusPendingResult statusPendingResult) {
        this.zahj = statusPendingResult;
    }

    public final void onConnectionFailed(ConnectionResult object) {
        object = this.zahj;
        Status status = new Status(8);
        ((BasePendingResult)object).setResult(status);
    }
}

