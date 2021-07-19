/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdt;
import com.google.android.gms.internal.mlkit_vision_common.zzdu;
import com.google.android.gms.internal.mlkit_vision_common.zzer;

public abstract class zzdr {
    private int zza = 100;
    private int zzb = -1 >>> 1;
    private boolean zzc = false;

    private zzdr() {
    }

    public /* synthetic */ zzdr(zzdu zzdu2) {
        this();
    }

    public static zzdr zza(byte[] byArray, int n10, int n11, boolean bl2) {
        Object object = new zzdt(byArray, 0, n11, false, null);
        try {
            ((zzdr)object).zza(n11);
            return object;
        }
        catch (zzer zzer2) {
            object = new IllegalArgumentException(zzer2);
            throw object;
        }
    }

    public abstract int zza();

    public abstract int zza(int var1);
}

