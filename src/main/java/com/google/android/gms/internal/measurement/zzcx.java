/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcw;
import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzcx
extends zzhs
implements zziy {
    private static final zzcx zzi;
    private int zza;
    private int zze;
    private zzdq zzf;
    private zzdq zzg;
    private boolean zzh;

    static {
        zzcx zzcx2;
        zzi = zzcx2 = new zzcx();
        zzhs.zzby(zzcx.class, zzcx2);
    }

    private zzcx() {
    }

    public static zzcw zzh() {
        return (zzcw)zzi.zzbt();
    }

    public static /* synthetic */ zzcx zzi() {
        return zzi;
    }

    public static /* synthetic */ void zzj(zzcx zzcx2, int n10) {
        int n11;
        zzcx2.zza = n11 = zzcx2.zza | 1;
        zzcx2.zze = n10;
    }

    public static /* synthetic */ void zzk(zzcx zzcx2, zzdq zzdq2) {
        int n10;
        zzdq2.getClass();
        zzcx2.zzf = zzdq2;
        zzcx2.zza = n10 = zzcx2.zza | 2;
    }

    public static /* synthetic */ void zzm(zzcx zzcx2, zzdq zzdq2) {
        int n10;
        zzcx2.zzg = zzdq2;
        zzcx2.zza = n10 = zzcx2.zza | 4;
    }

    public static /* synthetic */ void zzn(zzcx zzcx2, boolean bl2) {
        int n10;
        zzcx2.zza = n10 = zzcx2.zza | 8;
        zzcx2.zzh = bl2;
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

    public final zzdq zzc() {
        zzdq zzdq2 = this.zzf;
        if (zzdq2 == null) {
            zzdq2 = zzdq.zzm();
        }
        return zzdq2;
    }

    public final boolean zzd() {
        int n10 = this.zza & 4;
        return n10 != 0;
    }

    public final zzdq zze() {
        zzdq zzdq2 = this.zzg;
        if (zzdq2 == null) {
            zzdq2 = zzdq.zzm();
        }
        return zzdq2;
    }

    public final boolean zzf() {
        int n10 = this.zza & 8;
        return n10 != 0;
    }

    public final boolean zzg() {
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
                    zzcw zzcw2 = new zzcw(null);
                    return zzcw2;
                }
                zzcx zzcx2 = new zzcx();
                return zzcx2;
            }
            Object[] objectArray = new Object[n11];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = "zzf";
            objectArray[n13] = "zzg";
            objectArray[n12] = "zzh";
            return zzhs.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u1007\u0003", objectArray);
        }
        return by2;
    }
}

