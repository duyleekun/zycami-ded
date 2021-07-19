/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzaa;
import com.google.android.gms.internal.mlkit_common.zzad;

public final class zzaf
extends zzaa {
    private final zzad zza;

    public zzaf(zzad zzad2, int n10) {
        int n11 = zzad2.size();
        super(n11, n10);
        this.zza = zzad2;
    }

    public final Object zza(int n10) {
        return this.zza.get(n10);
    }
}

