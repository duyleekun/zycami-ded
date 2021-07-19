/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcy;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzcz
extends zzhs
implements zziy {
    private static final zzcz zzg;
    private int zza;
    private int zze;
    private long zzf;

    static {
        zzcz zzcz2;
        zzg = zzcz2 = new zzcz();
        zzhs.zzby(zzcz.class, zzcz2);
    }

    private zzcz() {
    }

    public static zzcy zze() {
        return (zzcy)zzg.zzbt();
    }

    public static /* synthetic */ zzcz zzf() {
        return zzg;
    }

    public static /* synthetic */ void zzg(zzcz zzcz2, int n10) {
        int n11;
        zzcz2.zza = n11 = zzcz2.zza | 1;
        zzcz2.zze = n10;
    }

    public static /* synthetic */ void zzh(zzcz zzcz2, long l10) {
        int n10;
        zzcz2.zza = n10 = zzcz2.zza | 2;
        zzcz2.zzf = l10;
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

    public final boolean zzc() {
        int n10 = this.zza & 2;
        return n10 != 0;
    }

    public final long zzd() {
        return this.zzf;
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
                    zzcy zzcy2 = new zzcy(null);
                    return zzcy2;
                }
                zzcz zzcz2 = new zzcz();
                return zzcz2;
            }
            Object[] objectArray = new Object[n12];
            objectArray[0] = "zza";
            objectArray[n11] = "zze";
            objectArray[n13] = "zzf";
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1002\u0001", objectArray);
        }
        return (byte)n11;
    }
}

