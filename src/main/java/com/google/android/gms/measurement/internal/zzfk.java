/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzy;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzgn;

public final class zzfk
implements Runnable {
    public final /* synthetic */ zzgn zza;
    public final /* synthetic */ zzfl zzb;

    public zzfk(zzfl zzfl2, zzgn zzgn2) {
        this.zzb = zzfl2;
        this.zza = zzgn2;
    }

    public final void run() {
        zzfl zzfl2 = this.zzb;
        Object object = this.zza;
        zzfl.zzO(zzfl2, (zzgn)object);
        zzfl2 = this.zzb;
        object = this.zza.zzg;
        zzfl2.zza((zzy)object);
    }
}

