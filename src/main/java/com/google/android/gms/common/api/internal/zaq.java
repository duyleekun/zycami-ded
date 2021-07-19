/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.zar;
import com.google.android.gms.common.internal.Preconditions;

public final class zaq
implements GoogleApiClient$ConnectionCallbacks,
GoogleApiClient$OnConnectionFailedListener {
    public final Api mApi;
    private final boolean zaec;
    private zar zaed;

    public zaq(Api api, boolean bl2) {
        this.mApi = api;
        this.zaec = bl2;
    }

    private final void zav() {
        Preconditions.checkNotNull(this.zaed, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public final void onConnected(Bundle bundle) {
        this.zav();
        this.zaed.onConnected(bundle);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zav();
        zar zar2 = this.zaed;
        Api api = this.mApi;
        boolean bl2 = this.zaec;
        zar2.zaa(connectionResult, api, bl2);
    }

    public final void onConnectionSuspended(int n10) {
        this.zav();
        this.zaed.onConnectionSuspended(n10);
    }

    public final void zaa(zar zar2) {
        this.zaed = zar2;
    }
}

