/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzgg;

public final class zzge$zze$zzb
extends Enum
implements zzcj {
    private static final zzck zzbq;
    private static final /* enum */ zzge$zze$zzb zzuc;
    private static final /* enum */ zzge$zze$zzb zzud;
    private static final /* enum */ zzge$zze$zzb zzue;
    private static final /* enum */ zzge$zze$zzb zzuf;
    private static final /* enum */ zzge$zze$zzb zzug;
    private static final /* synthetic */ zzge$zze$zzb[] zzuh;
    private final int value;

    static {
        zzge$zze$zzb zzge$zze$zzb;
        zzge$zze$zzb zzge$zze$zzb2;
        zzge$zze$zzb zzge$zze$zzb3;
        zzge$zze$zzb zzge$zze$zzb4;
        Object object = new zzge$zze$zzb("CLIENT_UNKNOWN", 0, 0);
        zzuc = object;
        int n10 = 1;
        zzud = zzge$zze$zzb4 = new zzge$zze$zzb("CHIRP", n10, n10);
        int n11 = 2;
        zzue = zzge$zze$zzb3 = new zzge$zze$zzb("WAYMO", n11, n11);
        int n12 = 3;
        zzuf = zzge$zze$zzb2 = new zzge$zze$zzb("GV_ANDROID", n12, n12);
        int n13 = 4;
        zzug = zzge$zze$zzb = new zzge$zze$zzb("GV_IOS", n13, n13);
        zzge$zze$zzb[] zzge$zze$zzbArray = new zzge$zze$zzb[5];
        zzge$zze$zzbArray[0] = object;
        zzge$zze$zzbArray[n10] = zzge$zze$zzb4;
        zzge$zze$zzbArray[n11] = zzge$zze$zzb3;
        zzge$zze$zzbArray[n12] = zzge$zze$zzb2;
        zzge$zze$zzbArray[n13] = zzge$zze$zzb;
        zzuh = zzge$zze$zzbArray;
        zzbq = object = new zzgg();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzge$zze$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzge$zze$zzb[] values() {
        return (zzge$zze$zzb[])zzuh.clone();
    }

    public static zzge$zze$zzb zzar(int n10) {
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
                        return zzug;
                    }
                    return zzuf;
                }
                return zzue;
            }
            return zzud;
        }
        return zzuc;
    }

    public static zzck zzd() {
        return zzbq;
    }

    public final int zzc() {
        return this.value;
    }
}

