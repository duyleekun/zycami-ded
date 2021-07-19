/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zal;

public final class zaj$zaa
implements GoogleApiClient$OnConnectionFailedListener {
    public final int zacx;
    public final GoogleApiClient zacy;
    public final GoogleApiClient$OnConnectionFailedListener zacz;
    private final /* synthetic */ zaj zada;

    public zaj$zaa(zaj zaj2, int n10, GoogleApiClient googleApiClient, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        this.zada = zaj2;
        this.zacx = n10;
        this.zacy = googleApiClient;
        this.zacz = googleApiClient$OnConnectionFailedListener;
        googleApiClient.registerConnectionFailedListener(this);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Object object = String.valueOf(connectionResult);
        int n10 = String.valueOf(object).length() + 27;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("beginFailureResolution for ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        Log.d((String)"AutoManageHelper", (String)object);
        object = this.zada;
        n10 = this.zacx;
        ((zal)object).zab(connectionResult, n10);
    }
}

