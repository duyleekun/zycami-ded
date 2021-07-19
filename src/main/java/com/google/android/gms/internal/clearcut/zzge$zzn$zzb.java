/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzgj;

public final class zzge$zzn$zzb
extends Enum
implements zzcj {
    private static final zzck zzbq;
    private static final /* enum */ zzge$zzn$zzb zzxf;
    private static final /* enum */ zzge$zzn$zzb zzxg;
    private static final /* enum */ zzge$zzn$zzb zzxh;
    private static final /* enum */ zzge$zzn$zzb zzxi;
    private static final /* enum */ zzge$zzn$zzb zzxj;
    private static final /* synthetic */ zzge$zzn$zzb[] zzxk;
    private final int value;

    static {
        zzge$zzn$zzb zzge$zzn$zzb;
        zzge$zzn$zzb zzge$zzn$zzb2;
        zzge$zzn$zzb zzge$zzn$zzb3;
        zzge$zzn$zzb zzge$zzn$zzb4;
        Object object = new zzge$zzn$zzb("UNKNOWN", 0, 0);
        zzxf = object;
        int n10 = 1;
        zzxg = zzge$zzn$zzb4 = new zzge$zzn$zzb("MOBILE", n10, n10);
        int n11 = 2;
        zzxh = zzge$zzn$zzb3 = new zzge$zzn$zzb("TABLET", n11, n11);
        int n12 = 3;
        zzxi = zzge$zzn$zzb2 = new zzge$zzn$zzb("DESKTOP", n12, n12);
        int n13 = 4;
        zzxj = zzge$zzn$zzb = new zzge$zzn$zzb("GOOGLE_HOME", n13, n13);
        zzge$zzn$zzb[] zzge$zzn$zzbArray = new zzge$zzn$zzb[5];
        zzge$zzn$zzbArray[0] = object;
        zzge$zzn$zzbArray[n10] = zzge$zzn$zzb4;
        zzge$zzn$zzbArray[n11] = zzge$zzn$zzb3;
        zzge$zzn$zzbArray[n12] = zzge$zzn$zzb2;
        zzge$zzn$zzbArray[n13] = zzge$zzn$zzb;
        zzxk = zzge$zzn$zzbArray;
        zzbq = object = new zzgj();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzge$zzn$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzge$zzn$zzb[] values() {
        return (zzge$zzn$zzb[])zzxk.clone();
    }

    public static zzge$zzn$zzb zzau(int n10) {
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
                        return zzxj;
                    }
                    return zzxi;
                }
                return zzxh;
            }
            return zzxg;
        }
        return zzxf;
    }

    public static zzck zzd() {
        return zzbq;
    }

    public final int zzc() {
        return this.value;
    }
}

