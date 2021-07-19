/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzad$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzcb;
import com.google.android.gms.internal.mlkit_vision_face.zzel;

public final class zzem
implements Runnable {
    private final zzel zza;
    private final zzbm$zzad$zza zzb;
    private final zzcb zzc;

    public zzem(zzel zzel2, zzbm$zzad$zza zzbm$zzad$zza, zzcb zzcb2) {
        this.zza = zzel2;
        this.zzb = zzbm$zzad$zza;
        this.zzc = zzcb2;
    }

    public final void run() {
        zzel zzel2 = this.zza;
        zzbm$zzad$zza zzbm$zzad$zza = this.zzb;
        zzcb zzcb2 = this.zzc;
        zzel2.zzb(zzbm$zzad$zza, zzcb2);
    }
}

