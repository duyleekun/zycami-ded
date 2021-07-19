/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgx;
import com.google.android.gms.internal.mlkit_vision_face.zzgy;
import com.google.android.gms.internal.mlkit_vision_face.zzha;

public abstract class zzgv {
    private static final zzgv zza;
    private static final zzgv zzb;

    static {
        zzgv zzgv2 = new zzgx(null);
        zza = zzgv2;
        zzgv2 = new zzha(null);
        zzb = zzgv2;
    }

    private zzgv() {
    }

    public /* synthetic */ zzgv(zzgy zzgy2) {
        this();
    }

    public static zzgv zza() {
        return zza;
    }

    public static zzgv zzb() {
        return zzb;
    }

    public abstract void zza(Object var1, long var2);

    public abstract void zza(Object var1, Object var2, long var3);
}

