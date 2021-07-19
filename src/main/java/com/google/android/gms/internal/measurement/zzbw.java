/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;
import java.util.List;

public final class zzbw
extends zzhs
implements zziy {
    private static final zzbw zzm;
    private int zza;
    private int zze;
    private String zzf = "";
    private zzhz zzg;
    private boolean zzh;
    private zzcd zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        zzbw zzbw2;
        zzm = zzbw2 = new zzbw();
        zzhs.zzby(zzbw.class, zzbw2);
    }

    private zzbw() {
        zzhz zzhz2;
        this.zzg = zzhz2 = zzhs.zzbE();
    }

    public static zzbv zzn() {
        return (zzbv)zzm.zzbt();
    }

    public static /* synthetic */ zzbw zzo() {
        return zzm;
    }

    public static /* synthetic */ void zzp(zzbw zzbw2, String string2) {
        int n10;
        zzbw2.zza = n10 = zzbw2.zza | 2;
        zzbw2.zzf = string2;
    }

    public static /* synthetic */ void zzq(zzbw zzbw2, int n10, zzby zzby2) {
        zzby2.getClass();
        zzhz zzhz2 = zzbw2.zzg;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            zzbw2.zzg = zzhz2 = zzhs.zzbF(zzhz2);
        }
        zzbw2.zzg.set(n10, zzby2);
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

    public final List zzd() {
        return this.zzg;
    }

    public final int zze() {
        return this.zzg.size();
    }

    public final zzby zzf(int n10) {
        return (zzby)this.zzg.get(n10);
    }

    public final boolean zzg() {
        int n10 = this.zza & 8;
        return n10 != 0;
    }

    public final zzcd zzh() {
        zzcd zzcd2 = this.zzi;
        if (zzcd2 == null) {
            zzcd2 = zzcd.zzk();
        }
        return zzcd2;
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final boolean zzj() {
        return this.zzk;
    }

    public final boolean zzk() {
        int n10 = this.zza & 0x40;
        return n10 != 0;
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
                        return zzm;
                    }
                    zzbv zzbv2 = new zzbv(null);
                    return zzbv2;
                }
                zzbw zzbw2 = new zzbw();
                return zzbw2;
            }
            Object[] objectArray = new Object[10];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = "zzf";
            objectArray[n13] = "zzg";
            objectArray[n12] = zzby.class;
            objectArray[n11] = "zzh";
            objectArray[6] = "zzi";
            objectArray[7] = "zzj";
            objectArray[8] = "zzk";
            objectArray[9] = "zzl";
            return zzhs.zzbz(zzm, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u1004\u0000\u0002\u1008\u0001\u0003\u001b\u0004\u1007\u0002\u0005\u1009\u0003\u0006\u1007\u0004\u0007\u1007\u0005\b\u1007\u0006", objectArray);
        }
        return by2;
    }

    public final boolean zzm() {
        return this.zzl;
    }
}

