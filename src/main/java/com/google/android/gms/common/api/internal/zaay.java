/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zaaw;
import java.util.concurrent.atomic.AtomicReference;

public final class zaay
implements GoogleApiClient$ConnectionCallbacks {
    private final /* synthetic */ zaaw zahh;
    private final /* synthetic */ AtomicReference zahi;
    private final /* synthetic */ StatusPendingResult zahj;

    public zaay(zaaw zaaw2, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.zahh = zaaw2;
        this.zahi = atomicReference;
        this.zahj = statusPendingResult;
    }

    public final void onConnected(Bundle object) {
        object = this.zahh;
        GoogleApiClient googleApiClient = (GoogleApiClient)this.zahi.get();
        StatusPendingResult statusPendingResult = this.zahj;
        zaaw.zaa((zaaw)object, googleApiClient, statusPendingResult, true);
    }

    public final void onConnectionSuspended(int n10) {
    }
}

