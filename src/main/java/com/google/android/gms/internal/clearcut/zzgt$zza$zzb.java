/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzgv;

public final class zzgt$zza$zzb
extends Enum
implements zzcj {
    private static final /* enum */ zzgt$zza$zzb zzbim;
    private static final /* enum */ zzgt$zza$zzb zzbin;
    private static final /* enum */ zzgt$zza$zzb zzbio;
    private static final /* synthetic */ zzgt$zza$zzb[] zzbip;
    private static final zzck zzbq;
    private final int value;

    static {
        zzgt$zza$zzb zzgt$zza$zzb;
        zzgt$zza$zzb zzgt$zza$zzb2;
        Object object = new zzgt$zza$zzb("NO_RESTRICTION", 0, 0);
        zzbim = object;
        int n10 = 1;
        zzbin = zzgt$zza$zzb2 = new zzgt$zza$zzb("SIDEWINDER_DEVICE", n10, n10);
        int n11 = 2;
        zzbio = zzgt$zza$zzb = new zzgt$zza$zzb("LATCHSKY_DEVICE", n11, n11);
        zzgt$zza$zzb[] zzgt$zza$zzbArray = new zzgt$zza$zzb[3];
        zzgt$zza$zzbArray[0] = object;
        zzgt$zza$zzbArray[n10] = zzgt$zza$zzb2;
        zzgt$zza$zzbArray[n11] = zzgt$zza$zzb;
        zzbip = zzgt$zza$zzbArray;
        zzbq = object = new zzgv();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzgt$zza$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzgt$zza$zzb[] values() {
        return (zzgt$zza$zzb[])zzbip.clone();
    }

    public static zzgt$zza$zzb zzbe(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return zzbio;
            }
            return zzbin;
        }
        return zzbim;
    }

    public static zzck zzd() {
        return zzbq;
    }

    public final int zzc() {
        return this.value;
    }
}

