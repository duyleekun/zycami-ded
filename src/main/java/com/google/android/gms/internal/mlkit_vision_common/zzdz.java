/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzea;
import com.google.android.gms.internal.mlkit_vision_common.zzeb;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzd;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zze;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import com.google.android.gms.internal.mlkit_vision_common.zzht;
import java.util.Map;

public final class zzdz
extends zzea {
    public final int zza(Map.Entry object) {
        object = (zzej$zzd)object.getKey();
        object = new NoSuchMethodError();
        throw object;
    }

    public final zzeb zza(Object object) {
        return ((zzej$zze)object).zzc;
    }

    public final void zza(zzht object, Map.Entry entry) {
        object = (zzej$zzd)entry.getKey();
        object = new NoSuchMethodError();
        throw object;
    }

    public final boolean zza(zzfr zzfr2) {
        return zzfr2 instanceof zzej$zze;
    }

    public final zzeb zzb(Object object) {
        object = (zzej$zze)object;
        zzeb zzeb2 = ((zzej$zze)object).zzc;
        boolean bl2 = zzeb2.zzc();
        if (bl2) {
            ((zzej$zze)object).zzc = zzeb2 = (zzeb)((zzej$zze)object).zzc.clone();
        }
        return ((zzej$zze)object).zzc;
    }

    public final void zzc(Object object) {
        ((zzea)this).zza(object).zzb();
    }
}

