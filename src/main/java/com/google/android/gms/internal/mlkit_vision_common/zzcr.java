/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzag;
import com.google.android.gms.internal.mlkit_vision_common.zzcq;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzad$zza;

public final class zzcr
implements Runnable {
    private final zzcq zza;
    private final zzr$zzad$zza zzb;
    private final zzag zzc;

    public zzcr(zzcq zzcq2, zzr$zzad$zza zzr$zzad$zza, zzag zzag2) {
        this.zza = zzcq2;
        this.zzb = zzr$zzad$zza;
        this.zzc = zzag2;
    }

    public final void run() {
        zzcq zzcq2 = this.zza;
        zzr$zzad$zza zzr$zzad$zza = this.zzb;
        zzag zzag2 = this.zzc;
        zzcq2.zza(zzr$zzad$zza, zzag2);
    }
}

