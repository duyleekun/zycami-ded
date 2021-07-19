/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import com.google.android.gms.internal.mlkit_vision_common.zzdi;
import com.google.android.gms.internal.mlkit_vision_common.zzdp;
import com.google.android.gms.internal.mlkit_vision_common.zzdw;

public final class zzdn {
    private final zzdw zza;
    private final byte[] zzb;

    private zzdn(int n10) {
        Object object = new byte[n10];
        this.zzb = object;
        object = zzdw.zza(object);
        this.zza = object;
    }

    public /* synthetic */ zzdn(int n10, zzdi zzdi2) {
        this(n10);
    }

    public final zzdf zza() {
        this.zza.zzb();
        byte[] byArray = this.zzb;
        zzdp zzdp2 = new zzdp(byArray);
        return zzdp2;
    }

    public final zzdw zzb() {
        return this.zza;
    }
}

