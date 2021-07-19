/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzce;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzcf
extends zzhs
implements zziy {
    private static final zzcf zzk;
    private int zza;
    private int zze;
    private String zzf = "";
    private zzby zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        zzcf zzcf2;
        zzk = zzcf2 = new zzcf();
        zzhs.zzby(zzcf.class, zzcf2);
    }

    private zzcf() {
    }

    public static zzce zzi() {
        return (zzce)zzk.zzbt();
    }

    public static /* synthetic */ zzcf zzj() {
        return zzk;
    }

    public static /* synthetic */ void zzk(zzcf zzcf2, String string2) {
        int n10;
        zzcf2.zza = n10 = zzcf2.zza | 2;
        zzcf2.zzf = string2;
    }

    public final boolean zza() {
        int n10 = this.zza;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            return n11 != 0;
        }
        return false;
    }

    public final int zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final zzby zzd() {
        zzby zzby2 = this.zzg;
        if (zzby2 == null) {
            zzby2 = zzby.zzi();
        }
        return zzby2;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        int n10 = this.zza & 0x20;
        return n10 != 0;
    }

    public final boolean zzh() {
        return this.zzj;
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
                        return zzk;
                    }
                    zzce zzce2 = new zzce(null);
                    return zzce2;
                }
                zzcf zzcf2 = new zzcf();
                return zzcf2;
            }
            Object[] objectArray = new Object[7];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = "zzf";
            objectArray[n13] = "zzg";
            objectArray[n12] = "zzh";
            objectArray[n11] = "zzi";
            objectArray[6] = "zzj";
            return zzhs.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1008\u0001\u0003\u1009\u0002\u0004\u1007\u0003\u0005\u1007\u0004\u0006\u1007\u0005", objectArray);
        }
        return by2;
    }
}

