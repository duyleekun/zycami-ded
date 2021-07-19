/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbl;
import com.google.android.gms.internal.clearcut.zzbm;
import com.google.android.gms.internal.clearcut.zzco;

public abstract class zzbk {
    private static volatile boolean zzft = true;
    private int zzfq = 100;
    private int zzfr = -1 >>> 1;
    private boolean zzfs = false;

    private zzbk() {
    }

    public /* synthetic */ zzbk(zzbl zzbl2) {
        this();
    }

    public static long zza(long l10) {
        long l11 = l10 >>> 1;
        return -(l10 & 1L) ^ l11;
    }

    public static zzbk zza(byte[] byArray, int n10, int n11, boolean bl2) {
        Object object = new zzbm(byArray, 0, n11, false, null);
        try {
            ((zzbk)object).zzl(n11);
            return object;
        }
        catch (zzco zzco2) {
            object = new IllegalArgumentException(zzco2);
            throw object;
        }
    }

    public static int zzm(int n10) {
        int n11 = n10 >>> 1;
        return -(n10 & 1) ^ n11;
    }

    public abstract int zzaf();

    public abstract int zzl(int var1);
}

