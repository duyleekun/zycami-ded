/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzad;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzad$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzeh;
import com.google.android.gms.internal.mlkit_vision_face.zzei;
import com.google.android.gms.internal.mlkit_vision_face.zzel$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;

public final class zzej
implements zzel$zzb {
    public static final Component zza;
    private final zzeh zzb;

    static {
        Component$Builder component$Builder = Component.builder(zzel$zzb.class);
        Object object = Dependency.required(zzeh.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = zzei.zza;
        zza = component$Builder.factory((ComponentFactory)object).build();
    }

    public zzej(zzeh zzeh2) {
        this.zzb = zzeh2;
    }

    public final void zza(zzbm$zzad zzhn2) {
        zzeh zzeh2 = this.zzb;
        zzbm$zzad$zza zzbm$zzad$zza = zzbm$zzad.zza(zzhn2);
        zzhn2 = zzbm$zzbh.zza(zzhn2.zza()).zza(true);
        zzhn2 = (zzbm$zzad)((zzgd)zzbm$zzad$zza.zza((zzbm$zzbh$zza)zzhn2).zzh());
        zzeh2.zza((zzbm$zzad)zzhn2);
    }
}

