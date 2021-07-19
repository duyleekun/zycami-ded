/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzd;
import com.google.android.gms.internal.mlkit_vision_common.zzh;

public final class zzi
extends zzh {
    public static final zzh zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    static {
        Object[] objectArray = new Object[]{};
        zzi zzi2 = new zzi(objectArray, 0);
        zza = zzi2;
    }

    public zzi(Object[] objectArray, int n10) {
        this.zzb = objectArray;
        this.zzc = n10;
    }

    public final Object get(int n10) {
        int n11 = this.zzc;
        zzd.zza(n10, n11);
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

