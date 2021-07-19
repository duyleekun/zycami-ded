/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;
import java.util.List;

public final class zzdb
extends zzhs
implements zziy {
    private static final zzdb zzj;
    private int zza;
    private zzhz zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private int zzi;

    static {
        zzdb zzdb2;
        zzj = zzdb2 = new zzdb();
        zzhs.zzby(zzdb.class, zzdb2);
    }

    private zzdb() {
        zzhz zzhz2;
        this.zze = zzhz2 = zzhs.zzbE();
        this.zzf = "";
    }

    public static zzda zzk() {
        return (zzda)zzj.zzbt();
    }

    public static /* synthetic */ zzdb zzm() {
        return zzj;
    }

    public static /* synthetic */ void zzn(zzdb zzdb2, int n10, zzdf zzdf2) {
        zzdf2.getClass();
        zzdb2.zzv();
        zzdb2.zze.set(n10, zzdf2);
    }

    public static /* synthetic */ void zzo(zzdb zzdb2, zzdf zzdf2) {
        zzdf2.getClass();
        zzdb2.zzv();
        zzdb2.zze.add(zzdf2);
    }

    public static /* synthetic */ void zzp(zzdb object, Iterable iterable) {
        ((zzdb)object).zzv();
        object = ((zzdb)object).zze;
        zzgb.zzbs(iterable, (List)object);
    }

    public static /* synthetic */ void zzq(zzdb zzdb2) {
        zzhz zzhz2;
        zzdb2.zze = zzhz2 = zzhs.zzbE();
    }

    public static /* synthetic */ void zzr(zzdb zzdb2, int n10) {
        zzdb2.zzv();
        zzdb2.zze.remove(n10);
    }

    public static /* synthetic */ void zzs(zzdb zzdb2, String string2) {
        int n10;
        string2.getClass();
        zzdb2.zza = n10 = zzdb2.zza | 1;
        zzdb2.zzf = string2;
    }

    public static /* synthetic */ void zzt(zzdb zzdb2, long l10) {
        int n10;
        zzdb2.zza = n10 = zzdb2.zza | 2;
        zzdb2.zzg = l10;
    }

    public static /* synthetic */ void zzu(zzdb zzdb2, long l10) {
        int n10;
        zzdb2.zza = n10 = zzdb2.zza | 4;
        zzdb2.zzh = l10;
    }

    private final void zzv() {
        zzhz zzhz2 = this.zze;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            this.zze = zzhz2 = zzhs.zzbF(zzhz2);
        }
    }

    public final List zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final zzdf zzc(int n10) {
        return (zzdf)this.zze.get(n10);
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        int n10 = this.zza & 2;
        return n10 != 0;
    }

    public final long zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        int n10 = this.zza & 4;
        return n10 != 0;
    }

    public final long zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        int n10 = this.zza & 8;
        return n10 != 0;
    }

    public final int zzj() {
        return this.zzi;
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
                    zzda zzda2 = new zzda(null);
                    return zzda2;
                }
                zzdb zzdb2 = new zzdb();
                return zzdb2;
            }
            Object[] objectArray = new Object[7];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = zzdf.class;
            objectArray[n13] = "zzf";
            objectArray[n12] = "zzg";
            objectArray[n11] = "zzh";
            objectArray[6] = "zzi";
            return zzhs.zzbz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002\u1008\u0000\u0003\u1002\u0001\u0004\u1002\u0002\u0005\u1004\u0003", objectArray);
        }
        return by2;
    }
}

