/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzfn;
import com.google.android.gms.internal.mlkit_vision_face.zzfo;
import com.google.android.gms.internal.mlkit_vision_face.zzgl;

public abstract class zzfl {
    private int zza = 100;
    private int zzb = -1 >>> 1;
    private boolean zzc = false;

    private zzfl() {
    }

    public /* synthetic */ zzfl(zzfo zzfo2) {
        this();
    }

    public static zzfl zza(byte[] byArray, int n10, int n11, boolean bl2) {
        Object object = new zzfn(byArray, 0, n11, false, null);
        try {
            ((zzfl)object).zza(n11);
            return object;
        }
        catch (zzgl zzgl2) {
            object = new IllegalArgumentException(zzgl2);
            throw object;
        }
    }

    public abstract int zza();

    public abstract int zza(int var1);
}

