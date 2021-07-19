/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzfd;
import com.google.android.gms.internal.mlkit_vision_common.zzfe;
import com.google.android.gms.internal.mlkit_vision_common.zzfg;

public abstract class zzfb {
    private static final zzfb zza;
    private static final zzfb zzb;

    static {
        zzfb zzfb2 = new zzfd(null);
        zza = zzfb2;
        zzfb2 = new zzfg(null);
        zzb = zzfb2;
    }

    private zzfb() {
    }

    public /* synthetic */ zzfb(zzfe zzfe2) {
        this();
    }

    public static zzfb zza() {
        return zza;
    }

    public static zzfb zzb() {
        return zzb;
    }

    public abstract void zza(Object var1, long var2);

    public abstract void zza(Object var1, Object var2, long var3);
}

