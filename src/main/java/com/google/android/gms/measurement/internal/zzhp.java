/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzhq;
import java.util.Map;

public final class zzhp
implements Runnable {
    private final zzhq zza;
    private final int zzb;
    private final Exception zzc;
    private final byte[] zzd;
    private final Map zze;

    public zzhp(zzhq zzhq2, int n10, Exception exception, byte[] byArray, Map map) {
        this.zza = zzhq2;
        this.zzb = n10;
        this.zzc = exception;
        this.zzd = byArray;
        this.zze = map;
    }

    public final void run() {
        zzhq zzhq2 = this.zza;
        int n10 = this.zzb;
        Exception exception = this.zzc;
        byte[] byArray = this.zzd;
        Map map = this.zze;
        zzhq2.zza(n10, exception, byArray, map);
    }
}

