/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzeo;
import com.google.android.gms.internal.mlkit_common.zzep;
import com.google.android.gms.internal.mlkit_common.zzez;
import com.google.android.gms.internal.mlkit_common.zzfc;

public final class zzex {
    private final zzfc zza;
    private final byte[] zzb;

    private zzex(int n10) {
        Object object = new byte[n10];
        this.zzb = object;
        object = zzfc.zza(object);
        this.zza = object;
    }

    public /* synthetic */ zzex(int n10, zzeo zzeo2) {
        this(n10);
    }

    public final zzep zza() {
        this.zza.zzb();
        byte[] byArray = this.zzb;
        zzez zzez2 = new zzez(byArray);
        return zzez2;
    }

    public final zzfc zzb() {
        return this.zza;
    }
}

