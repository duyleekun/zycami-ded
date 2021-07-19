/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdt;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzdu
extends zzhs
implements zziy {
    private static final zzdu zzk;
    private int zza;
    private long zze;
    private String zzf;
    private String zzg;
    private long zzh;
    private float zzi;
    private double zzj;

    static {
        zzdu zzdu2;
        zzk = zzdu2 = new zzdu();
        zzhs.zzby(zzdu.class, zzdu2);
    }

    private zzdu() {
        String string2;
        this.zzf = string2 = "";
        this.zzg = string2;
    }

    public static zzdt zzj() {
        return (zzdt)zzk.zzbt();
    }

    public static /* synthetic */ zzdu zzk() {
        return zzk;
    }

    public static /* synthetic */ void zzm(zzdu zzdu2, long l10) {
        int n10;
        zzdu2.zza = n10 = zzdu2.zza | 1;
        zzdu2.zze = l10;
    }

    public static /* synthetic */ void zzn(zzdu zzdu2, String string2) {
        int n10;
        string2.getClass();
        zzdu2.zza = n10 = zzdu2.zza | 2;
        zzdu2.zzf = string2;
    }

    public static /* synthetic */ void zzo(zzdu zzdu2, String string2) {
        int n10;
        string2.getClass();
        zzdu2.zza = n10 = zzdu2.zza | 4;
        zzdu2.zzg = string2;
    }

    public static /* synthetic */ void zzp(zzdu zzdu2) {
        String string2;
        int n10;
        zzdu2.zza = n10 = zzdu2.zza & 0xFFFFFFFB;
        zzdu2.zzg = string2 = zzdu.zzk.zzg;
    }

    public static /* synthetic */ void zzq(zzdu zzdu2, long l10) {
        int n10;
        zzdu2.zza = n10 = zzdu2.zza | 8;
        zzdu2.zzh = l10;
    }

    public static /* synthetic */ void zzr(zzdu zzdu2) {
        int n10;
        zzdu2.zza = n10 = zzdu2.zza & 0xFFFFFFF7;
        zzdu2.zzh = 0L;
    }

    public static /* synthetic */ void zzs(zzdu zzdu2, double d10) {
        int n10;
        zzdu2.zza = n10 = zzdu2.zza | 0x20;
        zzdu2.zzj = d10;
    }

    public static /* synthetic */ void zzt(zzdu zzdu2) {
        int n10;
        zzdu2.zza = n10 = zzdu2.zza & 0xFFFFFFDF;
        zzdu2.zzj = 0.0;
    }

    public final boolean zza() {
        int n10 = this.zza;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            return n11 != 0;
        }
        return false;
    }

    public final long zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        int n10 = this.zza & 4;
        return n10 != 0;
    }

    public final String zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        int n10 = this.zza & 8;
        return n10 != 0;
    }

    public final long zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        int n10 = this.zza & 0x20;
        return n10 != 0;
    }

    public final double zzi() {
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
                    zzdt zzdt2 = new zzdt(null);
                    return zzdt2;
                }
                zzdu zzdu2 = new zzdu();
                return zzdu2;
            }
            Object[] objectArray = new Object[7];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = "zzf";
            objectArray[n13] = "zzg";
            objectArray[n12] = "zzh";
            objectArray[n11] = "zzi";
            objectArray[6] = "zzj";
            return zzhs.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u1002\u0000\u0002\u1008\u0001\u0003\u1008\u0002\u0004\u1002\u0003\u0005\u1001\u0004\u0006\u1000\u0005", objectArray);
        }
        return by2;
    }
}

