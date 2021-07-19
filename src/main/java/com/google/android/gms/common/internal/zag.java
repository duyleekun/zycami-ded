/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener;

public final class zag
implements BaseGmsClient$BaseOnConnectionFailedListener {
    private final /* synthetic */ GoogleApiClient$OnConnectionFailedListener zaok;

    public zag(GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        this.zaok = googleApiClient$OnConnectionFailedListener;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zaok.onConnectionFailed(connectionResult);
    }
}

