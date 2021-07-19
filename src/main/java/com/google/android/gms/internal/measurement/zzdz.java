/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdy;
import com.google.android.gms.internal.measurement.zzeg;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;

public final class zzdz
extends zzhs
implements zziy {
    private static final zzdz zzg;
    private int zza;
    private String zze = "";
    private zzhz zzf;

    static {
        zzdz zzdz2;
        zzg = zzdz2 = new zzdz();
        zzhs.zzby(zzdz.class, zzdz2);
    }

    private zzdz() {
        zzhz zzhz2;
        this.zzf = zzhz2 = zzhs.zzbE();
    }

    public static /* synthetic */ zzdz zza() {
        return zzg;
    }

    public final Object zzl(int n10, Object object, Object object2) {
        byte by2 = 1;
        if ((n10 += -1) != 0) {
            int n11 = 4;
            int n12 = 3;
            int n13 = 2;
            if (n10 != n13) {
                if (n10 != n12) {
                    by2 = 0;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 != n11) {
                            return null;
                        }
                        return zzg;
                    }
                    zzdy zzdy2 = new zzdy(null);
                    return zzdy2;
                }
                zzdz zzdz2 = new zzdz();
                return zzdz2;
            }
            Object[] objectArray = new Object[n11];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n13] = "zzf";
            objectArray[n12] = zzeg.class;
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u1008\u0000\u0002\u001b", objectArray);
        }
        return by2;
    }
}

