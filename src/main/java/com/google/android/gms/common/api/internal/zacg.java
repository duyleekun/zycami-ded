/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.signin.internal.zaj;

public final class zacg
implements Runnable {
    private final /* synthetic */ zaj zagr;
    private final /* synthetic */ zace zakk;

    public zacg(zace zace2, zaj zaj2) {
        this.zakk = zace2;
        this.zagr = zaj2;
    }

    public final void run() {
        zace zace2 = this.zakk;
        zaj zaj2 = this.zagr;
        zace.zaa(zace2, zaj2);
    }
}

