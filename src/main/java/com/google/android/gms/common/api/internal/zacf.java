/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zach;

public final class zacf
implements Runnable {
    private final /* synthetic */ zace zakk;

    public zacf(zace zace2) {
        this.zakk = zace2;
    }

    public final void run() {
        zach zach2 = zace.zaa(this.zakk);
        ConnectionResult connectionResult = new ConnectionResult(4);
        zach2.zag(connectionResult);
    }
}

