/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzcm;
import com.google.android.gms.internal.mlkit_vision_common.zzcn;
import com.google.android.gms.internal.mlkit_vision_common.zzcq$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzad;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzad$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh$zza;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;

public final class zzco
implements zzcq$zzb {
    public static final Component zza;
    private final zzcm zzb;

    static {
        Component$Builder component$Builder = Component.builder(zzcq$zzb.class);
        Object object = Dependency.required(zzcm.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = zzcn.zza;
        zza = component$Builder.factory((ComponentFactory)object).build();
    }

    public zzco(zzcm zzcm2) {
        this.zzb = zzcm2;
    }

    public final void zza(zzr$zzad zzft2) {
        zzcm zzcm2 = this.zzb;
        zzr$zzad$zza zzr$zzad$zza = zzr$zzad.zza(zzft2);
        zzft2 = zzr$zzbh.zza(zzft2.zza()).zza(true);
        zzft2 = (zzr$zzad)((zzej)zzr$zzad$zza.zza((zzr$zzbh$zza)zzft2).zzh());
        zzcm2.zza((zzr$zzad)zzft2);
    }
}

