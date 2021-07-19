/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzf;
import com.google.android.gms.internal.mlkit_vision_common.zzh;

public final class zzg
extends zzf {
    private final zzh zza;

    public zzg(zzh zzh2, int n10) {
        int n11 = zzh2.size();
        super(n11, n10);
        this.zza = zzh2;
    }

    public final Object zza(int n10) {
        return this.zza.get(n10);
    }
}

