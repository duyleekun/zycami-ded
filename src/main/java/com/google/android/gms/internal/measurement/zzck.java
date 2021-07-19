/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcg;
import com.google.android.gms.internal.measurement.zzcj;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;
import java.util.List;

public final class zzck
extends zzhs
implements zziy {
    private static final zzck zzi;
    private int zza;
    private int zze;
    private String zzf = "";
    private boolean zzg;
    private zzhz zzh;

    static {
        zzck zzck2;
        zzi = zzck2 = new zzck();
        zzhs.zzby(zzck.class, zzck2);
    }

    private zzck() {
        zzhz zzhz2;
        this.zzh = zzhz2 = zzhs.zzbE();
    }

    public static zzck zzi() {
        return zzi;
    }

    public static /* synthetic */ zzck zzj() {
        return zzi;
    }

    public final boolean zza() {
        int n10 = this.zza;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            return n11 != 0;
        }
        return false;
    }

    public final zzcj zzb() {
        int n10 = this.zze;
        zzcj zzcj2 = zzcj.zza(n10);
        if (zzcj2 == null) {
            zzcj2 = zzcj.zza;
        }
        return zzcj2;
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

    public final boolean zzf() {
        return this.zzg;
    }

    public final List zzg() {
        return this.zzh;
    }

    public final int zzh() {
        return this.zzh.size();
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
                    object = null;
                    if (n10 != n12) {
                        if (n10 != n11) {
                            return null;
                        }
                        return zzi;
                    }
                    zzcg zzcg2 = new zzcg(null);
                    return zzcg2;
                }
                zzck zzck2 = new zzck();
                return zzck2;
            }
            Object[] objectArray = new Object[6];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = object = zzcj.zzb();
            objectArray[n13] = "zzf";
            objectArray[n12] = "zzg";
            objectArray[n11] = "zzh";
            return zzhs.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u1008\u0001\u0003\u1007\u0002\u0004\u001a", objectArray);
        }
        return by2;
    }
}

