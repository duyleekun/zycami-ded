/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzgv;
import com.google.android.gms.internal.vision.zzhc;
import com.google.android.gms.internal.vision.zzhl;

public final class zzha {
    private final byte[] buffer;
    private final zzhl zztz;

    private zzha(int n10) {
        Object object = new byte[n10];
        this.buffer = object;
        object = zzhl.zze(object);
        this.zztz = object;
    }

    public /* synthetic */ zzha(int n10, zzgv zzgv2) {
        this(n10);
    }

    public final zzgs zzfp() {
        this.zztz.zzgb();
        byte[] byArray = this.buffer;
        zzhc zzhc2 = new zzhc(byArray);
        return zzhc2;
    }

    public final zzhl zzfq() {
        return this.zztz;
    }
}

