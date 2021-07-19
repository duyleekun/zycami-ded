/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzgi;

public final class zzge$zzj$zza
extends Enum
implements zzcj {
    private static final zzck zzbq;
    private static final /* enum */ zzge$zzj$zza zzwk;
    private static final /* enum */ zzge$zzj$zza zzwl;
    private static final /* enum */ zzge$zzj$zza zzwm;
    private static final /* synthetic */ zzge$zzj$zza[] zzwn;
    private final int value;

    static {
        zzge$zzj$zza zzge$zzj$zza;
        zzge$zzj$zza zzge$zzj$zza2;
        Object object = new zzge$zzj$zza("UNKNOWN", 0, 0);
        zzwk = object;
        int n10 = 1;
        zzwl = zzge$zzj$zza2 = new zzge$zzj$zza("AUTO_TIME_OFF", n10, n10);
        int n11 = 2;
        zzwm = zzge$zzj$zza = new zzge$zzj$zza("AUTO_TIME_ON", n11, n11);
        zzge$zzj$zza[] zzge$zzj$zzaArray = new zzge$zzj$zza[3];
        zzge$zzj$zzaArray[0] = object;
        zzge$zzj$zzaArray[n10] = zzge$zzj$zza2;
        zzge$zzj$zzaArray[n11] = zzge$zzj$zza;
        zzwn = zzge$zzj$zzaArray;
        zzbq = object = new zzgi();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzge$zzj$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzge$zzj$zza[] values() {
        return (zzge$zzj$zza[])zzwn.clone();
    }

    public static zzge$zzj$zza zzat(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return zzwm;
            }
            return zzwl;
        }
        return zzwk;
    }

    public static zzck zzd() {
        return zzbq;
    }

    public final int zzc() {
        return this.value;
    }
}

