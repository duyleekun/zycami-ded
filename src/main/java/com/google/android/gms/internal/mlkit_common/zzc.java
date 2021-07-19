/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import com.google.android.gms.internal.mlkit_common.zzd;
import java.util.concurrent.Callable;

public final class zzc
implements Callable {
    private final Context zza;

    public zzc(Context context) {
        this.zza = context;
    }

    public final Object call() {
        return zzd.zzb(this.zza);
    }
}

