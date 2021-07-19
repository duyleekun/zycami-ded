/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzek;
import com.google.android.gms.measurement.internal.zzel;
import java.util.Map;

public final class zzem
implements Runnable {
    private final zzel zza;
    private final int zzb;
    private final Throwable zzc;
    private final byte[] zzd;
    private final String zze;
    private final Map zzf;

    public /* synthetic */ zzem(String string2, zzel zzel2, int n10, Throwable throwable, byte[] byArray, Map map, zzek zzek2) {
        Preconditions.checkNotNull(zzel2);
        this.zza = zzel2;
        this.zzb = n10;
        this.zzc = throwable;
        this.zzd = byArray;
        this.zze = string2;
        this.zzf = map;
    }

    public final void run() {
        zzel zzel2 = this.zza;
        String string2 = this.zze;
        int n10 = this.zzb;
        Throwable throwable = this.zzc;
        byte[] byArray = this.zzd;
        Map map = this.zzf;
        zzel2.zza(string2, n10, throwable, byArray, map);
    }
}

