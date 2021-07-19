/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.face.internal;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzad$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbx;
import com.google.android.gms.internal.mlkit_vision_face.zzel$zzc;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.internal.zzb;

public final class zze
implements zzel$zzc {
    private final zzb zza;
    private final long zzb;
    private final zzbx zzc;
    private final int zzd;
    private final int zze;
    private final InputImage zzf;

    public zze(zzb zzb2, long l10, zzbx zzbx2, int n10, int n11, InputImage inputImage) {
        this.zza = zzb2;
        this.zzb = l10;
        this.zzc = zzbx2;
        this.zzd = n10;
        this.zze = n11;
        this.zzf = inputImage;
    }

    public final zzbm$zzad$zza zza() {
        zzb zzb2 = this.zza;
        long l10 = this.zzb;
        zzbx zzbx2 = this.zzc;
        int n10 = this.zzd;
        int n11 = this.zze;
        InputImage inputImage = this.zzf;
        return zzb2.zza(l10, zzbx2, n10, n11, inputImage);
    }
}

