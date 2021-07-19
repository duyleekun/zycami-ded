/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

public final class zam {
    private final int zadh;
    private final ConnectionResult zadi;

    public zam(ConnectionResult connectionResult, int n10) {
        Preconditions.checkNotNull(connectionResult);
        this.zadi = connectionResult;
        this.zadh = n10;
    }

    public final ConnectionResult getConnectionResult() {
        return this.zadi;
    }

    public final int zar() {
        return this.zadh;
    }
}

