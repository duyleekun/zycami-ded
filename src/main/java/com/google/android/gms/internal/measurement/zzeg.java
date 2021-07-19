/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzec;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;

public final class zzeg
extends zzhs
implements zziy {
    private static final zzeg zzk;
    private int zza;
    private int zze;
    private zzhz zzf;
    private String zzg;
    private String zzh;
    private boolean zzi;
    private double zzj;

    static {
        zzeg zzeg2;
        zzk = zzeg2 = new zzeg();
        zzhs.zzby(zzeg.class, zzeg2);
    }

    private zzeg() {
        Object object = zzhs.zzbE();
        this.zzf = object;
        this.zzg = object = "";
        this.zzh = object;
    }

    public static /* synthetic */ zzeg zza() {
        return zzk;
    }

    public final Object zzl(int n10, Object object, Object object2) {
        byte by2 = 1;
        if ((n10 += -1) != 0) {
            int n11 = 5;
            int n12 = 4;
            int n13 = 3;
            int n14 = 2;
            if (n10 != n14) {
                if (n10 != n13) {
                    by2 = 0;
                    object = null;
                    if (n10 != n12) {
                        if (n10 != n11) {
                            return null;
                        }
                        return zzk;
                    }
                    zzec zzec2 = new zzec(null);
                    return zzec2;
                }
                zzeg zzeg2 = new zzeg();
                return zzeg2;
            }
            Object[] objectArray = new Object[9];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = object = zzef.zzb();
            objectArray[n13] = "zzf";
            objectArray[n12] = zzeg.class;
            objectArray[n11] = "zzg";
            objectArray[6] = "zzh";
            objectArray[7] = "zzi";
            objectArray[8] = "zzj";
            return zzhs.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u001b\u0003\u1008\u0001\u0004\u1008\u0002\u0005\u1007\u0003\u0006\u1000\u0004", objectArray);
        }
        return by2;
    }
}

