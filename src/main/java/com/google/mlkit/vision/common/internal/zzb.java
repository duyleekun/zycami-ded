/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.common.internal;

import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.util.concurrent.Callable;

public final class zzb
implements Callable {
    public static final Callable zza;

    static {
        zzb zzb2 = new zzb();
        zza = zzb2;
    }

    private zzb() {
    }

    public final Object call() {
        return MobileVisionBase.zza();
    }
}

