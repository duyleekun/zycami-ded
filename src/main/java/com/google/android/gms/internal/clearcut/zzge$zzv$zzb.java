/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzgr;

public final class zzge$zzv$zzb
extends Enum
implements zzcj {
    public static final /* enum */ zzge$zzv$zzb zzbhk;
    private static final /* enum */ zzge$zzv$zzb zzbhl;
    private static final /* enum */ zzge$zzv$zzb zzbhm;
    private static final /* enum */ zzge$zzv$zzb zzbhn;
    private static final /* enum */ zzge$zzv$zzb zzbho;
    private static final /* synthetic */ zzge$zzv$zzb[] zzbhp;
    private static final zzck zzbq;
    private final int value;

    static {
        zzge$zzv$zzb zzge$zzv$zzb;
        zzge$zzv$zzb zzge$zzv$zzb2;
        zzge$zzv$zzb zzge$zzv$zzb3;
        zzge$zzv$zzb zzge$zzv$zzb4;
        Object object = new zzge$zzv$zzb("DEFAULT", 0, 0);
        zzbhk = object;
        int n10 = 1;
        zzbhl = zzge$zzv$zzb4 = new zzge$zzv$zzb("UNMETERED_ONLY", n10, n10);
        int n11 = 2;
        zzbhm = zzge$zzv$zzb3 = new zzge$zzv$zzb("UNMETERED_OR_DAILY", n11, n11);
        int n12 = 3;
        zzbhn = zzge$zzv$zzb2 = new zzge$zzv$zzb("FAST_IF_RADIO_AWAKE", n12, n12);
        int n13 = 4;
        zzbho = zzge$zzv$zzb = new zzge$zzv$zzb("NEVER", n13, n13);
        zzge$zzv$zzb[] zzge$zzv$zzbArray = new zzge$zzv$zzb[5];
        zzge$zzv$zzbArray[0] = object;
        zzge$zzv$zzbArray[n10] = zzge$zzv$zzb4;
        zzge$zzv$zzbArray[n11] = zzge$zzv$zzb3;
        zzge$zzv$zzbArray[n12] = zzge$zzv$zzb2;
        zzge$zzv$zzbArray[n13] = zzge$zzv$zzb;
        zzbhp = zzge$zzv$zzbArray;
        zzbq = object = new zzgr();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzge$zzv$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzge$zzv$zzb[] values() {
        return (zzge$zzv$zzb[])zzbhp.clone();
    }

    public static zzge$zzv$zzb zzbc(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            return null;
                        }
                        return zzbho;
                    }
                    return zzbhn;
                }
                return zzbhm;
            }
            return zzbhl;
        }
        return zzbhk;
    }

    public static zzck zzd() {
        return zzbq;
    }

    public final int zzc() {
        return this.value;
    }
}

