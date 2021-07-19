/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzdk;
import com.google.android.gms.internal.measurement.zzdn;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;

public final class zzdo
extends zzhs
implements zziy {
    private static final zzdo zzg;
    private int zza;
    private int zze = 1;
    private zzhz zzf;

    static {
        zzdo zzdo2;
        zzg = zzdo2 = new zzdo();
        zzhs.zzby(zzdo.class, zzdo2);
    }

    private zzdo() {
        zzhz zzhz2;
        this.zzf = zzhz2 = zzhs.zzbE();
    }

    public static zzdk zza() {
        return (zzdk)zzg.zzbt();
    }

    public static /* synthetic */ zzdo zzb() {
        return zzg;
    }

    public static /* synthetic */ void zzc(zzdo zzdo2, zzdd zzdd2) {
        zzdd2.getClass();
        zzhz zzhz2 = zzdo2.zzf;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            zzdo2.zzf = zzhz2 = zzhs.zzbF(zzhz2);
        }
        zzdo2.zzf.add(zzdd2);
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
                        return zzg;
                    }
                    zzdk zzdk2 = new zzdk(null);
                    return zzdk2;
                }
                zzdo zzdo2 = new zzdo();
                return zzdo2;
            }
            Object[] objectArray = new Object[n11];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = object = zzdn.zzb();
            objectArray[n13] = "zzf";
            objectArray[n12] = zzdd.class;
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u001b", objectArray);
        }
        return by2;
    }
}

