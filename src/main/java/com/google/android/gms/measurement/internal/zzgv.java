/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzjb;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgv
implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzhn zzc;

    public zzgv(zzhn zzhn2, AtomicReference atomicReference, boolean bl2) {
        this.zzc = zzhn2;
        this.zza = atomicReference;
        this.zzb = bl2;
    }

    public final void run() {
        zzjb zzjb2 = this.zzc.zzx.zzy();
        AtomicReference atomicReference = this.zza;
        boolean bl2 = this.zzb;
        zzjb2.zzt(atomicReference, bl2);
    }
}

