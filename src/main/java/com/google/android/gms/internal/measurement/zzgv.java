/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgt;

public class zzgv {
    public /* synthetic */ zzgv(zzgt zzgt2) {
    }

    public static int zzb(int n10) {
        int n11 = n10 >>> 1;
        return -(n10 & 1) ^ n11;
    }

    public static long zzc(long l10) {
        long l11 = l10 >>> 1;
        return -(l10 & 1L) ^ l11;
    }
}

