/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks;

public final class zaf
implements BaseGmsClient$BaseConnectionCallbacks {
    private final /* synthetic */ GoogleApiClient$ConnectionCallbacks zaoj;

    public zaf(GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks) {
        this.zaoj = googleApiClient$ConnectionCallbacks;
    }

    public final void onConnected(Bundle bundle) {
        this.zaoj.onConnected(bundle);
    }

    public final void onConnectionSuspended(int n10) {
        this.zaoj.onConnectionSuspended(n10);
    }
}

