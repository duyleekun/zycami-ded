/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzad;
import com.google.android.gms.internal.mlkit_common.zzy;

public final class zzah
extends zzad {
    public static final zzad zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    static {
        Object[] objectArray = new Object[]{};
        zzah zzah2 = new zzah(objectArray, 0);
        zza = zzah2;
    }

    public zzah(Object[] objectArray, int n10) {
        this.zzb = objectArray;
        this.zzc = n10;
    }

    public final Object get(int n10) {
        int n11 = this.zzc;
        zzy.zza(n10, n11);
        return this.zzb[n10];
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objectArray, int n10) {
        Object[] objectArray2 = this.zzb;
        int n11 = this.zzc;
        System.arraycopy(objectArray2, 0, objectArray, 0, n11);
        return this.zzc + 0;
    }

    public final Object[] zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzc;
    }
}

