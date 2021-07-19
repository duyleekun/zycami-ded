/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzgk;
import com.google.android.gms.internal.mlkit_common.zzgm;
import com.google.android.gms.internal.mlkit_common.zzgn;

public abstract class zzgl {
    private static final zzgl zza;
    private static final zzgl zzb;

    static {
        zzgl zzgl2 = new zzgn(null);
        zza = zzgl2;
        zzgl2 = new zzgm(null);
        zzb = zzgl2;
    }

    private zzgl() {
    }

    public /* synthetic */ zzgl(zzgk zzgk2) {
        this();
    }

    public static zzgl zza() {
        return zza;
    }

    public static zzgl zzb() {
        return zzb;
    }

    public abstract void zza(Object var1, long var2);

    public abstract void zza(Object var1, Object var2, long var3);
}

