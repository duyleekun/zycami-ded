/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zacp;
import com.google.android.gms.common.api.internal.zacs;

public final class zacq
implements zacs {
    private final /* synthetic */ zacp zalb;

    public zacq(zacp zacp2) {
        this.zalb = zacp2;
    }

    public final void zac(BasePendingResult basePendingResult) {
        this.zalb.zakz.remove(basePendingResult);
    }
}

