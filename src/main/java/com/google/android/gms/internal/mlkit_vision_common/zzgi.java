/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzfp;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import com.google.android.gms.internal.mlkit_vision_common.zzgd;

public final class zzgi
implements zzfp {
    private final zzfr zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzgi(zzfr zzfr2, String string2, Object[] objectArray) {
        this.zza = zzfr2;
        this.zzb = string2;
        this.zzc = objectArray;
        zzfr2 = null;
        int n10 = string2.charAt(0);
        int n11 = 55296;
        if (n10 < n11) {
            this.zzd = n10;
            return;
        }
        n10 &= 0x1FFF;
        int n12 = 13;
        int n13 = 1;
        while (true) {
            int n14 = n13 + 1;
            if ((n13 = (int)string2.charAt(n13)) < n11) break;
            n13 = (n13 & 0x1FFF) << n12;
            n10 |= n13;
            n12 += 13;
            n13 = n14;
        }
        int n15 = n13 << n12;
        this.zzd = n10 |= n15;
    }

    public final int zza() {
        int n10 = this.zzd;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            return zzgd.zza;
        }
        return zzgd.zzb;
    }

    public final boolean zzb() {
        int n10 = this.zzd;
        int n11 = 2;
        return (n10 &= n11) == n11;
    }

    public final zzfr zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}

