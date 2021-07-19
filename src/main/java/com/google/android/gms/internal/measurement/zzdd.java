/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdc;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzdd
extends zzhs
implements zziy {
    private static final zzdd zzg;
    private int zza;
    private String zze = "";
    private long zzf;

    static {
        zzdd zzdd2;
        zzg = zzdd2 = new zzdd();
        zzhs.zzby(zzdd.class, zzdd2);
    }

    private zzdd() {
    }

    public static zzdc zza() {
        return (zzdc)zzg.zzbt();
    }

    public static /* synthetic */ zzdd zzb() {
        return zzg;
    }

    public static /* synthetic */ void zzc(zzdd zzdd2, String string2) {
        int n10;
        string2.getClass();
        zzdd2.zza = n10 = zzdd2.zza | 1;
        zzdd2.zze = string2;
    }

    public static /* synthetic */ void zzd(zzdd zzdd2, long l10) {
        int n10;
        zzdd2.zza = n10 = zzdd2.zza | 2;
        zzdd2.zzf = l10;
    }

    public final Object zzl(int n10, Object object, Object object2) {
        int n11 = 1;
        if ((n10 += -1) != 0) {
            int n12 = 3;
            int n13 = 2;
            if (n10 != n13) {
                if (n10 != n12) {
                    n11 = 4;
                    n12 = 0;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 != n11) {
                            return null;
                        }
                        return zzg;
                    }
                    zzdc zzdc2 = new zzdc(null);
                    return zzdc2;
                }
                zzdd zzdd2 = new zzdd();
                return zzdd2;
            }
            Object[] objectArray = new Object[n12];
            objectArray[0] = "zza";
            objectArray[n11] = "zze";
            objectArray[n13] = "zzf";
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1002\u0001", objectArray);
        }
        return (byte)n11;
    }
}

