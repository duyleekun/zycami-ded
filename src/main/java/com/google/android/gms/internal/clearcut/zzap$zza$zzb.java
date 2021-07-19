/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzar;
import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzck;

public final class zzap$zza$zzb
extends Enum
implements zzcj {
    private static final zzck zzbq;
    private static final /* enum */ zzap$zza$zzb zzet;
    private static final /* enum */ zzap$zza$zzb zzeu;
    private static final /* enum */ zzap$zza$zzb zzev;
    private static final /* synthetic */ zzap$zza$zzb[] zzew;
    private final int value;

    static {
        zzap$zza$zzb zzap$zza$zzb;
        zzap$zza$zzb zzap$zza$zzb2;
        Object object = new zzap$zza$zzb("UNKNOWN", 0, 0);
        zzet = object;
        int n10 = 1;
        zzeu = zzap$zza$zzb2 = new zzap$zza$zzb("ON", n10, n10);
        int n11 = 2;
        zzev = zzap$zza$zzb = new zzap$zza$zzb("OFF", n11, n11);
        zzap$zza$zzb[] zzap$zza$zzbArray = new zzap$zza$zzb[3];
        zzap$zza$zzbArray[0] = object;
        zzap$zza$zzbArray[n10] = zzap$zza$zzb2;
        zzap$zza$zzbArray[n11] = zzap$zza$zzb;
        zzew = zzap$zza$zzbArray;
        zzbq = object = new zzar();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzap$zza$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzap$zza$zzb[] values() {
        return (zzap$zza$zzb[])zzew.clone();
    }

    public static zzck zzd() {
        return zzbq;
    }

    public static zzap$zza$zzb zze(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return zzev;
            }
            return zzeu;
        }
        return zzet;
    }

    public final int zzc() {
        return this.value;
    }
}

