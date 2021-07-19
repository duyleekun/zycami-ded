/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzde;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;
import java.util.List;

public final class zzdf
extends zzhs
implements zziy {
    private static final zzdf zzk;
    private int zza;
    private String zze;
    private String zzf;
    private long zzg;
    private float zzh;
    private double zzi;
    private zzhz zzj;

    static {
        zzdf zzdf2;
        zzk = zzdf2 = new zzdf();
        zzhs.zzby(zzdf.class, zzdf2);
    }

    private zzdf() {
        Object object = "";
        this.zze = object;
        this.zzf = object;
        this.zzj = object = zzhs.zzbE();
    }

    public static zzde zzn() {
        return (zzde)zzk.zzbt();
    }

    public static /* synthetic */ zzdf zzo() {
        return zzk;
    }

    public static /* synthetic */ void zzp(zzdf zzdf2, String string2) {
        int n10;
        string2.getClass();
        zzdf2.zza = n10 = zzdf2.zza | 1;
        zzdf2.zze = string2;
    }

    public static /* synthetic */ void zzq(zzdf zzdf2, String string2) {
        int n10;
        string2.getClass();
        zzdf2.zza = n10 = zzdf2.zza | 2;
        zzdf2.zzf = string2;
    }

    public static /* synthetic */ void zzr(zzdf zzdf2) {
        String string2;
        int n10;
        zzdf2.zza = n10 = zzdf2.zza & 0xFFFFFFFD;
        zzdf2.zzf = string2 = zzdf.zzk.zzf;
    }

    public static /* synthetic */ void zzs(zzdf zzdf2, long l10) {
        int n10;
        zzdf2.zza = n10 = zzdf2.zza | 4;
        zzdf2.zzg = l10;
    }

    public static /* synthetic */ void zzt(zzdf zzdf2) {
        int n10;
        zzdf2.zza = n10 = zzdf2.zza & 0xFFFFFFFB;
        zzdf2.zzg = 0L;
    }

    public static /* synthetic */ void zzu(zzdf zzdf2, double d10) {
        int n10;
        zzdf2.zza = n10 = zzdf2.zza | 0x10;
        zzdf2.zzi = d10;
    }

    public static /* synthetic */ void zzv(zzdf zzdf2) {
        int n10;
        zzdf2.zza = n10 = zzdf2.zza & 0xFFFFFFEF;
        zzdf2.zzi = 0.0;
    }

    public static /* synthetic */ void zzw(zzdf zzdf2, zzdf zzdf3) {
        zzdf3.getClass();
        zzdf2.zzz();
        zzdf2.zzj.add(zzdf3);
    }

    public static /* synthetic */ void zzx(zzdf object, Iterable iterable) {
        ((zzdf)object).zzz();
        object = ((zzdf)object).zzj;
        zzgb.zzbs(iterable, (List)object);
    }

    public static /* synthetic */ void zzy(zzdf zzdf2) {
        zzhz zzhz2;
        zzdf2.zzj = zzhz2 = zzhs.zzbE();
    }

    private final void zzz() {
        zzhz zzhz2 = this.zzj;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            this.zzj = zzhz2 = zzhs.zzbF(zzhz2);
        }
    }

    public final boolean zza() {
        int n10 = this.zza;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            return n11 != 0;
        }
        return false;
    }

    public final String zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        int n10 = this.zza & 2;
        return n10 != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        int n10 = this.zza & 4;
        return n10 != 0;
    }

    public final long zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        int n10 = this.zza & 8;
        return n10 != 0;
    }

    public final float zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        int n10 = this.zza & 0x10;
        return n10 != 0;
    }

    public final double zzj() {
        return this.zzi;
    }

    public final List zzk() {
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
                    zzde zzde2 = new zzde(null);
                    return zzde2;
                }
                zzdf zzdf2 = new zzdf();
                return zzdf2;
            }
            Object[] objectArray = new Object[8];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = "zzf";
            objectArray[n13] = "zzg";
            objectArray[n12] = "zzh";
            objectArray[n11] = "zzi";
            objectArray[6] = "zzj";
            objectArray[7] = zzdf.class;
            return zzhs.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u1002\u0002\u0004\u1001\u0003\u0005\u1000\u0004\u0006\u001b", objectArray);
        }
        return by2;
    }

    public final int zzm() {
        return this.zzj.size();
    }
}

