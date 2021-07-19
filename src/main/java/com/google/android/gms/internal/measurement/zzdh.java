/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdg;
import com.google.android.gms.internal.measurement.zzdj;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;
import java.util.List;

public final class zzdh
extends zzhs
implements zziy {
    private static final zzdh zze;
    private zzhz zza;

    static {
        zzdh zzdh2;
        zze = zzdh2 = new zzdh();
        zzhs.zzby(zzdh.class, zzdh2);
    }

    private zzdh() {
        zzhz zzhz2;
        this.zza = zzhz2 = zzhs.zzbE();
    }

    public static zzdg zzc() {
        return (zzdg)zze.zzbt();
    }

    public static /* synthetic */ zzdh zzd() {
        return zze;
    }

    public static /* synthetic */ void zze(zzdh zzdh2, zzdj zzdj2) {
        zzdj2.getClass();
        zzhz zzhz2 = zzdh2.zza;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            zzdh2.zza = zzhz2 = zzhs.zzbF(zzhz2);
        }
        zzdh2.zza.add(zzdj2);
    }

    public final List zza() {
        return this.zza;
    }

    public final zzdj zzb(int n10) {
        return (zzdj)this.zza.get(0);
    }

    public final Object zzl(int n10, Object object, Object object2) {
        int n11 = 1;
        if ((n10 += -1) != 0) {
            int n12 = 2;
            if (n10 != n12) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    n12 = 0;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 != n11) {
                            return null;
                        }
                        return zze;
                    }
                    zzdg zzdg2 = new zzdg(null);
                    return zzdg2;
                }
                zzdh zzdh2 = new zzdh();
                return zzdh2;
            }
            Object[] objectArray = new Object[n12];
            objectArray[0] = "zza";
            objectArray[n11] = zzdj.class;
            return zzhs.zzbz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
        }
        return (byte)n11;
    }
}

