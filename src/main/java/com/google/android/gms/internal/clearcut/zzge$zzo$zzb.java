/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzgl;

public final class zzge$zzo$zzb
extends Enum
implements zzcj {
    private static final zzck zzbq;
    private static final /* enum */ zzge$zzo$zzb zzyw;
    private static final /* enum */ zzge$zzo$zzb zzyx;
    private static final /* enum */ zzge$zzo$zzb zzyy;
    private static final /* synthetic */ zzge$zzo$zzb[] zzyz;
    private final int value;

    static {
        zzge$zzo$zzb zzge$zzo$zzb;
        zzge$zzo$zzb zzge$zzo$zzb2;
        Object object = new zzge$zzo$zzb("NONE", 0, 0);
        zzyw = object;
        int n10 = 1;
        zzyx = zzge$zzo$zzb2 = new zzge$zzo$zzb("WALL_CLOCK_SET", n10, n10);
        int n11 = 2;
        zzyy = zzge$zzo$zzb = new zzge$zzo$zzb("DEVICE_BOOT", n11, n11);
        zzge$zzo$zzb[] zzge$zzo$zzbArray = new zzge$zzo$zzb[3];
        zzge$zzo$zzbArray[0] = object;
        zzge$zzo$zzbArray[n10] = zzge$zzo$zzb2;
        zzge$zzo$zzbArray[n11] = zzge$zzo$zzb;
        zzyz = zzge$zzo$zzbArray;
        zzbq = object = new zzgl();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzge$zzo$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzge$zzo$zzb[] values() {
        return (zzge$zzo$zzb[])zzyz.clone();
    }

    public static zzge$zzo$zzb zzaw(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return zzyy;
            }
            return zzyx;
        }
        return zzyw;
    }

    public static zzck zzd() {
        return zzbq;
    }

    public final int zzc() {
        return this.value;
    }
}

