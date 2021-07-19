/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcz;
import com.google.android.gms.internal.measurement.zzdp;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;
import java.util.List;

public final class zzdq
extends zzhs
implements zziy {
    private static final zzdq zzh;
    private zzhy zza;
    private zzhy zze;
    private zzhz zzf;
    private zzhz zzg;

    static {
        zzdq zzdq2;
        zzh = zzdq2 = new zzdq();
        zzhs.zzby(zzdq.class, zzdq2);
    }

    private zzdq() {
        zzhz zzhz2;
        this.zza = zzhz2 = zzhs.zzbC();
        this.zze = zzhz2 = zzhs.zzbC();
        zzhz2 = zzhs.zzbE();
        this.zzf = zzhz2;
        zzhz2 = zzhs.zzbE();
        this.zzg = zzhz2;
    }

    public static zzdp zzk() {
        return (zzdp)zzh.zzbt();
    }

    public static zzdq zzm() {
        return zzh;
    }

    public static /* synthetic */ zzdq zzn() {
        return zzh;
    }

    public static /* synthetic */ void zzo(zzdq object, Iterable iterable) {
        zzhy zzhy2 = ((zzdq)object).zza;
        boolean bl2 = zzhy2.zza();
        if (!bl2) {
            ((zzdq)object).zza = zzhy2 = zzhs.zzbD(zzhy2);
        }
        object = ((zzdq)object).zza;
        zzgb.zzbs(iterable, (List)object);
    }

    public static /* synthetic */ void zzp(zzdq zzdq2) {
        zzhy zzhy2;
        zzdq2.zza = zzhy2 = zzhs.zzbC();
    }

    public static /* synthetic */ void zzq(zzdq object, Iterable iterable) {
        zzhy zzhy2 = ((zzdq)object).zze;
        boolean bl2 = zzhy2.zza();
        if (!bl2) {
            ((zzdq)object).zze = zzhy2 = zzhs.zzbD(zzhy2);
        }
        object = ((zzdq)object).zze;
        zzgb.zzbs(iterable, (List)object);
    }

    public static /* synthetic */ void zzr(zzdq zzdq2) {
        zzhy zzhy2;
        zzdq2.zze = zzhy2 = zzhs.zzbC();
    }

    public static /* synthetic */ void zzs(zzdq object, Iterable iterable) {
        ((zzdq)object).zzw();
        object = ((zzdq)object).zzf;
        zzgb.zzbs(iterable, (List)object);
    }

    public static /* synthetic */ void zzt(zzdq zzdq2, int n10) {
        zzdq2.zzw();
        zzdq2.zzf.remove(n10);
    }

    public static /* synthetic */ void zzu(zzdq object, Iterable iterable) {
        ((zzdq)object).zzx();
        object = ((zzdq)object).zzg;
        zzgb.zzbs(iterable, (List)object);
    }

    public static /* synthetic */ void zzv(zzdq zzdq2, int n10) {
        zzdq2.zzx();
        zzdq2.zzg.remove(n10);
    }

    private final void zzw() {
        zzhz zzhz2 = this.zzf;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            this.zzf = zzhz2 = zzhs.zzbF(zzhz2);
        }
    }

    private final void zzx() {
        zzhz zzhz2 = this.zzg;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            this.zzg = zzhz2 = zzhs.zzbF(zzhz2);
        }
    }

    public final List zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final List zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final List zze() {
        return this.zzf;
    }

    public final int zzf() {
        return this.zzf.size();
    }

    public final zzcz zzg(int n10) {
        return (zzcz)this.zzf.get(n10);
    }

    public final List zzh() {
        return this.zzg;
    }

    public final int zzi() {
        return this.zzg.size();
    }

    public final zzds zzj(int n10) {
        return (zzds)this.zzg.get(n10);
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
                        return zzh;
                    }
                    zzdp zzdp2 = new zzdp(null);
                    return zzdp2;
                }
                zzdq zzdq2 = new zzdq();
                return zzdq2;
            }
            Object[] objectArray = new Object[6];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = "zzf";
            objectArray[n13] = zzcz.class;
            objectArray[n12] = "zzg";
            objectArray[n11] = zzds.class;
            return zzhs.zzbz(zzh, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", objectArray);
        }
        return by2;
    }
}

