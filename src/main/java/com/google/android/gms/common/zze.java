/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common;

import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzd;
import java.util.concurrent.Callable;

public final class zze
implements Callable {
    private final boolean zza;
    private final String zzb;
    private final zzd zzc;

    public zze(boolean bl2, String string2, zzd zzd2) {
        this.zza = bl2;
        this.zzb = string2;
        this.zzc = zzd2;
    }

    public final Object call() {
        boolean bl2 = this.zza;
        String string2 = this.zzb;
        zzd zzd2 = this.zzc;
        return com.google.android.gms.common.zzc.zza(bl2, string2, zzd2);
    }
}

