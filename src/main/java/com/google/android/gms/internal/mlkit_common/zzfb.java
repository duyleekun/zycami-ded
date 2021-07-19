/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfa;
import com.google.android.gms.internal.mlkit_common.zzfd;
import com.google.android.gms.internal.mlkit_common.zzgb;

public abstract class zzfb {
    private int zza = 100;
    private int zzb = -1 >>> 1;
    private boolean zzc = false;

    private zzfb() {
    }

    public /* synthetic */ zzfb(zzfa zzfa2) {
        this();
    }

    public static zzfb zza(byte[] byArray, int n10, int n11, boolean bl2) {
        Object object = new zzfd(byArray, 0, n11, false, null);
        try {
            ((zzfb)object).zza(n11);
            return object;
        }
        catch (zzgb zzgb2) {
            object = new IllegalArgumentException(zzgb2);
            throw object;
        }
    }

    public abstract int zza();

    public abstract int zza(int var1);
}

