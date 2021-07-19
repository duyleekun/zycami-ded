/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzav$zzad;
import com.google.android.gms.internal.mlkit_common.zzav$zzad$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzbh;
import com.google.android.gms.internal.mlkit_common.zzav$zzbh$zza;
import com.google.android.gms.internal.mlkit_common.zzdo;
import com.google.android.gms.internal.mlkit_common.zzdp;
import com.google.android.gms.internal.mlkit_common.zzds$zza;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;

public final class zzdq
implements zzds$zza {
    public static final Component zza;
    private final zzdo zzb;

    static {
        Component$Builder component$Builder = Component.builder(zzds$zza.class);
        Object object = Dependency.required(zzdo.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = zzdp.zza;
        zza = component$Builder.factory((ComponentFactory)object).build();
    }

    public zzdq(zzdo zzdo2) {
        this.zzb = zzdo2;
    }

    public final void zza(zzav$zzad zzhd2) {
        zzdo zzdo2 = this.zzb;
        zzav$zzad$zza zzav$zzad$zza = zzav$zzad.zza(zzhd2);
        zzhd2 = zzav$zzbh.zza(zzhd2.zza()).zza(true);
        zzhd2 = (zzav$zzad)((zzfq)zzav$zzad$zza.zza((zzav$zzbh$zza)zzhd2).zzg());
        zzdo2.zza((zzav$zzad)zzhd2);
    }
}

