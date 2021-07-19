/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbu;
import com.google.android.gms.internal.measurement.zzcn;
import com.google.android.gms.internal.measurement.zzco;
import com.google.android.gms.internal.measurement.zzcr;
import com.google.android.gms.internal.measurement.zzeb;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;
import java.util.List;

public final class zzcp
extends zzhs
implements zziy {
    private static final zzcp zzn;
    private int zza;
    private long zze;
    private String zzf;
    private int zzg;
    private zzhz zzh;
    private zzhz zzi;
    private zzhz zzj;
    private String zzk;
    private boolean zzl;
    private zzhz zzm;

    static {
        zzcp zzcp2;
        zzn = zzcp2 = new zzcp();
        zzhs.zzby(zzcp.class, zzcp2);
    }

    private zzcp() {
        zzhz zzhz2;
        Object object = "";
        this.zzf = object;
        this.zzh = zzhz2 = zzhs.zzbE();
        this.zzi = zzhz2 = zzhs.zzbE();
        this.zzj = zzhz2 = zzhs.zzbE();
        this.zzk = object;
        this.zzm = object = zzhs.zzbE();
    }

    public static zzco zzj() {
        return (zzco)zzn.zzbt();
    }

    public static zzcp zzk() {
        return zzn;
    }

    public static /* synthetic */ zzcp zzm() {
        return zzn;
    }

    public static /* synthetic */ void zzn(zzcp zzcp2, int n10, zzcn zzcn2) {
        zzcn2.getClass();
        zzhz zzhz2 = zzcp2.zzi;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            zzcp2.zzi = zzhz2 = zzhs.zzbF(zzhz2);
        }
        zzcp2.zzi.set(n10, zzcn2);
    }

    public static /* synthetic */ void zzo(zzcp zzcp2) {
        zzhz zzhz2;
        zzcp2.zzj = zzhz2 = zzhs.zzbE();
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

    public final boolean zzc() {
        int n10 = this.zza & 2;
        return n10 != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final List zze() {
        return this.zzh;
    }

    public final int zzf() {
        return this.zzi.size();
    }

    public final zzcn zzg(int n10) {
        return (zzcn)this.zzi.get(n10);
    }

    public final List zzh() {
        return this.zzj;
    }

    public final boolean zzi() {
        return this.zzl;
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
                        return zzn;
                    }
                    zzco zzco2 = new zzco(null);
                    return zzco2;
                }
                zzcp zzcp2 = new zzcp();
                return zzcp2;
            }
            Object[] objectArray = new Object[14];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = "zzf";
            objectArray[n13] = "zzg";
            objectArray[n12] = "zzh";
            objectArray[n11] = zzcr.class;
            objectArray[6] = "zzi";
            objectArray[7] = zzcn.class;
            objectArray[8] = "zzj";
            objectArray[9] = zzbu.class;
            objectArray[10] = "zzk";
            objectArray[11] = "zzl";
            objectArray[12] = "zzm";
            objectArray[13] = zzeb.class;
            return zzhs.zzbz(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001\u1002\u0000\u0002\u1008\u0001\u0003\u1004\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007\u1008\u0003\b\u1007\u0004\t\u001b", objectArray);
        }
        return by2;
    }
}

