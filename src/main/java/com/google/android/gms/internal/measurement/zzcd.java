/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbz;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzcd
extends zzhs
implements zziy {
    private static final zzcd zzj;
    private int zza;
    private int zze;
    private boolean zzf;
    private String zzg;
    private String zzh;
    private String zzi;

    static {
        zzcd zzcd2;
        zzj = zzcd2 = new zzcd();
        zzhs.zzby(zzcd.class, zzcd2);
    }

    private zzcd() {
        String string2;
        this.zzg = string2 = "";
        this.zzh = string2;
        this.zzi = string2;
    }

    public static zzcd zzk() {
        return zzj;
    }

    public static /* synthetic */ zzcd zzm() {
        return zzj;
    }

    public final boolean zza() {
        int n10 = this.zza;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            return n11 != 0;
        }
        return false;
    }

    public final zzcc zzb() {
        int n10 = this.zze;
        zzcc zzcc2 = zzcc.zza(n10);
        if (zzcc2 == null) {
            zzcc2 = zzcc.zza;
        }
        return zzcc2;
    }

    public final boolean zzc() {
        int n10 = this.zza & 2;
        return n10 != 0;
    }

    public final boolean zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        int n10 = this.zza & 4;
        return n10 != 0;
    }

    public final String zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        int n10 = this.zza & 8;
        return n10 != 0;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        int n10 = this.zza & 0x10;
        return n10 != 0;
    }

    public final String zzj() {
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
                    object = null;
                    if (n10 != n12) {
                        if (n10 != n11) {
                            return null;
                        }
                        return zzj;
                    }
                    zzbz zzbz2 = new zzbz(null);
                    return zzbz2;
                }
                zzcd zzcd2 = new zzcd();
                return zzcd2;
            }
            Object[] objectArray = new Object[7];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = object = zzcc.zzb();
            objectArray[n13] = "zzf";
            objectArray[n12] = "zzg";
            objectArray[n11] = "zzh";
            objectArray[6] = "zzi";
            return zzhs.zzbz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1008\u0002\u0004\u1008\u0003\u0005\u1008\u0004", objectArray);
        }
        return by2;
    }
}

