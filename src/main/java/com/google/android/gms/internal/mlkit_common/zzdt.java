/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzav$zzad$zza;
import com.google.android.gms.internal.mlkit_common.zzbg;
import com.google.android.gms.internal.mlkit_common.zzds;

public final class zzdt
implements Runnable {
    private final zzds zza;
    private final zzav$zzad$zza zzb;
    private final zzbg zzc;

    public zzdt(zzds zzds2, zzav$zzad$zza zzav$zzad$zza, zzbg zzbg2) {
        this.zza = zzds2;
        this.zzb = zzav$zzad$zza;
        this.zzc = zzbg2;
    }

    public final void run() {
        zzds zzds2 = this.zza;
        zzav$zzad$zza zzav$zzad$zza = this.zzb;
        zzbg zzbg2 = this.zzc;
        zzds2.zzb(zzav$zzad$zza, zzbg2);
    }
}

