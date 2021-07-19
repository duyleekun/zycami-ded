/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.zabm;

public final class zabn
implements Runnable {
    private final /* synthetic */ zabm zaja;

    public zabn(zabm zabm2) {
        this.zaja = zabm2;
    }

    public final void run() {
        GoogleApiManager$zaa.zag(this.zaja.zaiy).disconnect();
    }
}

