/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzn;
import java.util.concurrent.Callable;

public final class zzm
implements Callable {
    private final String zza;

    public zzm(String string2) {
        this.zza = string2;
    }

    public final Object call() {
        return zzn.zzb(this.zza);
    }
}

