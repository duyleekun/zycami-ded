/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzgv;

public final class zzgu
extends zzgv {
    private final byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd = -1 >>> 1;

    public /* synthetic */ zzgu(byte[] byArray, int n10, int n11, boolean bl2, zzgt zzgt2) {
        super(null);
        this.zza = byArray;
        this.zzb = 0;
    }

    public final int zza(int n10) {
        n10 = this.zzd;
        this.zzd = 0;
        int n11 = this.zzb;
        int n12 = this.zzc;
        this.zzb = n11 += n12;
        if (n11 > 0) {
            this.zzc = n11;
            this.zzb = 0;
        } else {
            this.zzc = 0;
        }
        return n10;
    }
}

