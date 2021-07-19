/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;
import java.util.List;

public final class zzbu
extends zzhs
implements zziy {
    private static final zzbu zzj;
    private int zza;
    private int zze;
    private zzhz zzf;
    private zzhz zzg;
    private boolean zzh;
    private boolean zzi;

    static {
        zzbu zzbu2;
        zzj = zzbu2 = new zzbu();
        zzhs.zzby(zzbu.class, zzbu2);
    }

    private zzbu() {
        zzhz zzhz2;
        this.zzf = zzhz2 = zzhs.zzbE();
        this.zzg = zzhz2 = zzhs.zzbE();
    }

    public static /* synthetic */ zzbu zzi() {
        return zzj;
    }

    public static /* synthetic */ void zzj(zzbu zzbu2, int n10, zzcf zzcf2) {
        zzcf2.getClass();
        zzhz zzhz2 = zzbu2.zzf;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            zzbu2.zzf = zzhz2 = zzhs.zzbF(zzhz2);
        }
        zzbu2.zzf.set(n10, zzcf2);
    }

    public static /* synthetic */ void zzk(zzbu zzbu2, int n10, zzbw zzbw2) {
        zzbw2.getClass();
        zzhz zzhz2 = zzbu2.zzg;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            zzbu2.zzg = zzhz2 = zzhs.zzbF(zzhz2);
        }
        zzbu2.zzg.set(n10, zzbw2);
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

    public final List zzc() {
        return this.zzf;
    }

    public final int zzd() {
        return this.zzf.size();
    }

    public final zzcf zze(int n10) {
        return (zzcf)this.zzf.get(n10);
    }

    public final List zzf() {
        return this.zzg;
    }

    public final int zzg() {
        return this.zzg.size();
    }

    public final zzbw zzh(int n10) {
        return (zzbw)this.zzg.get(n10);
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
                        return zzj;
                    }
                    zzbt zzbt2 = new zzbt(null);
                    return zzbt2;
                }
                zzbu zzbu2 = new zzbu();
                return zzbu2;
            }
            Object[] objectArray = new Object[8];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = "zzf";
            objectArray[n13] = zzcf.class;
            objectArray[n12] = "zzg";
            objectArray[n11] = zzbw.class;
            objectArray[6] = "zzh";
            objectArray[7] = "zzi";
            return zzhs.zzbz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u1004\u0000\u0002\u001b\u0003\u001b\u0004\u1007\u0001\u0005\u1007\u0002", objectArray);
        }
        return by2;
    }
}

