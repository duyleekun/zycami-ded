/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;

public final class zabl
implements Runnable {
    private final /* synthetic */ GoogleApiManager$zaa zaiy;
    private final /* synthetic */ ConnectionResult zaiz;

    public zabl(GoogleApiManager$zaa googleApiManager$zaa, ConnectionResult connectionResult) {
        this.zaiy = googleApiManager$zaa;
        this.zaiz = connectionResult;
    }

    public final void run() {
        GoogleApiManager$zaa googleApiManager$zaa = this.zaiy;
        ConnectionResult connectionResult = this.zaiz;
        googleApiManager$zaa.onConnectionFailed(connectionResult);
    }
}

