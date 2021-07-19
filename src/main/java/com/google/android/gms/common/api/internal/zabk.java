/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;

public final class zabk
implements Runnable {
    private final /* synthetic */ GoogleApiManager$zaa zaiy;

    public zabk(GoogleApiManager$zaa googleApiManager$zaa) {
        this.zaiy = googleApiManager$zaa;
    }

    public final void run() {
        GoogleApiManager$zaa.zaf(this.zaiy);
    }
}

