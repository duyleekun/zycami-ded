/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbx;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzby
extends zzhs
implements zziy {
    private static final zzby zzi;
    private int zza;
    private zzck zze;
    private zzcd zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        zzby zzby2;
        zzi = zzby2 = new zzby();
        zzhs.zzby(zzby.class, zzby2);
    }

    private zzby() {
    }

    public static zzby zzi() {
        return zzi;
    }

    public static /* synthetic */ zzby zzj() {
        return zzi;
    }

    public static /* synthetic */ void zzk(zzby zzby2, String string2) {
        int n10;
        zzby2.zza = n10 = zzby2.zza | 8;
        zzby2.zzh = string2;
    }

    public final boolean zza() {
        int n10 = this.zza;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            return n11 != 0;
        }
        return false;
    }

    public final zzck zzb() {
        zzck zzck2 = this.zze;
        if (zzck2 == null) {
            zzck2 = zzck.zzi();
        }
        return zzck2;
    }

    public final boolean zzc() {
        int n10 = this.zza & 2;
        return n10 != 0;
    }

    public final zzcd zzd() {
        zzcd zzcd2 = this.zzf;
        if (zzcd2 == null) {
            zzcd2 = zzcd.zzk();
        }
        return zzcd2;
    }

    public final boolean zze() {
        int n10 = this.zza & 4;
        return n10 != 0;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        int n10 = this.zza & 8;
        return n10 != 0;
    }

    public final String zzh() {
        return this.zzh;
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
                    if (n10 != n12) {
                        if (n10 != n11) {
                            return null;
                        }
                        return zzi;
                    }
                    zzbx zzbx2 = new zzbx(null);
                    return zzbx2;
                }
                zzby zzby2 = new zzby();
                return zzby2;
            }
            Object[] objectArray = new Object[n11];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = "zzf";
            objectArray[n13] = "zzg";
            objectArray[n12] = "zzh";
            return zzhs.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1007\u0002\u0004\u1008\u0003", objectArray);
        }
        return by2;
    }
}

