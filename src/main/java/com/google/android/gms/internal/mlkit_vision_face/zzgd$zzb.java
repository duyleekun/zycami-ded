/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzfv;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zze;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;

public class zzgd$zzb
extends zzgd$zza
implements zzhn {
    public zzgd$zzb(zzgd$zze zzgd$zze) {
        super(zzgd$zze);
    }

    public void zzc() {
        super.zzc();
        Object object = this.zza;
        zzgd zzgd2 = object;
        zzgd2 = (zzgd$zze)object;
        ((zzgd$zze)zzgd2).zzc = object = (zzfv)((zzgd$zze)object).zzc.clone();
    }

    public /* synthetic */ zzgd zze() {
        return (zzgd$zze)((zzgd$zza)this).zzg();
    }

    public /* synthetic */ zzhl zzg() {
        boolean bl2 = this.zzb;
        if (bl2) {
            return (zzgd$zze)this.zza;
        }
        ((zzgd$zze)this.zza).zzc.zzb();
        return (zzgd$zze)super.zze();
    }
}

