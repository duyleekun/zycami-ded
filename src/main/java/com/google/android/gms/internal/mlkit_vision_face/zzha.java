/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzgv;
import com.google.android.gms.internal.mlkit_vision_face.zzgy;
import com.google.android.gms.internal.mlkit_vision_face.zziz;

public final class zzha
extends zzgv {
    private zzha() {
        super(null);
    }

    public /* synthetic */ zzha(zzgy zzgy2) {
        this();
    }

    private static zzgm zzb(Object object, long l10) {
        return (zzgm)zziz.zzf(object, l10);
    }

    public final void zza(Object object, long l10) {
        zzha.zzb(object, l10).zzb();
    }

    public final void zza(Object object, Object object2, long l10) {
        zzgm zzgm2 = zzha.zzb(object, l10);
        object2 = zzha.zzb(object2, l10);
        int n10 = zzgm2.size();
        int n11 = object2.size();
        if (n10 > 0 && n11 > 0) {
            boolean bl2 = zzgm2.zza();
            if (!bl2) {
                zzgm2 = zzgm2.zzb(n11 += n10);
            }
            zzgm2.addAll(object2);
        }
        if (n10 > 0) {
            object2 = zzgm2;
        }
        zziz.zza(object, l10, object2);
    }
}

