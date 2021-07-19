/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzjb;
import java.util.concurrent.atomic.AtomicReference;

public final class zzha
implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzhn zzd;

    public zzha(zzhn zzhn2, AtomicReference atomicReference, String string2, String string3, String string4) {
        this.zzd = zzhn2;
        this.zza = atomicReference;
        this.zzb = string3;
        this.zzc = string4;
    }

    public final void run() {
        zzjb zzjb2 = this.zzd.zzx.zzy();
        AtomicReference atomicReference = this.zza;
        String string2 = this.zzb;
        String string3 = this.zzc;
        zzjb2.zzn(atomicReference, null, string2, string3);
    }
}

