/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzfu;
import com.google.android.gms.internal.mlkit_vision_face.zzfv;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zze;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import com.google.android.gms.internal.mlkit_vision_face.zzjn;
import java.util.Map;

public final class zzft
extends zzfu {
    public final int zza(Map.Entry object) {
        object = (zzgd$zzd)object.getKey();
        object = new NoSuchMethodError();
        throw object;
    }

    public final zzfv zza(Object object) {
        return ((zzgd$zze)object).zzc;
    }

    public final void zza(zzjn object, Map.Entry entry) {
        object = (zzgd$zzd)entry.getKey();
        object = new NoSuchMethodError();
        throw object;
    }

    public final boolean zza(zzhl zzhl2) {
        return zzhl2 instanceof zzgd$zze;
    }

    public final zzfv zzb(Object object) {
        object = (zzgd$zze)object;
        zzfv zzfv2 = ((zzgd$zze)object).zzc;
        boolean bl2 = zzfv2.zzc();
        if (bl2) {
            ((zzgd$zze)object).zzc = zzfv2 = (zzfv)((zzgd$zze)object).zzc.clone();
        }
        return ((zzgd$zze)object).zzc;
    }

    public final void zzc(Object object) {
        ((zzfu)this).zza(object).zzb();
    }
}

