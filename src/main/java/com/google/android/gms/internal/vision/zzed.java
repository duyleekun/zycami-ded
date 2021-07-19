/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzdm;
import com.google.android.gms.internal.vision.zzee;

public final class zzed
extends zzdm {
    private final zzee zzmv;

    public zzed(zzee zzee2, int n10) {
        int n11 = zzee2.size();
        super(n11, n10);
        this.zzmv = zzee2;
    }

    public final Object get(int n10) {
        return this.zzmv.get(n10);
    }
}

