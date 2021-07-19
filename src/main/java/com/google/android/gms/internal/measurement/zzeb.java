/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdx;
import com.google.android.gms.internal.measurement.zzea;
import com.google.android.gms.internal.measurement.zzeg;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;

public final class zzeb
extends zzhs
implements zziy {
    private static final zzeb zzg;
    private int zza;
    private zzhz zze;
    private zzdx zzf;

    static {
        zzeb zzeb2;
        zzg = zzeb2 = new zzeb();
        zzhs.zzby(zzeb.class, zzeb2);
    }

    private zzeb() {
        zzhz zzhz2;
        this.zze = zzhz2 = zzhs.zzbE();
    }

    public static /* synthetic */ zzeb zza() {
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
                    zzea zzea2 = new zzea(null);
                    return zzea2;
                }
                zzeb zzeb2 = new zzeb();
                return zzeb2;
            }
            Object[] objectArray = new Object[n11];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n13] = zzeg.class;
            objectArray[n12] = "zzf";
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u1009\u0000", objectArray);
        }
        return by2;
    }
}

